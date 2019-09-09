package com.decoded.javautil.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;


public class BasePar {
  private final CountDownLatch latch;
  private long timeout = 60000;
  private final CompletableFuture<Void> task;

  public BasePar(int parCount) {
    latch = new CountDownLatch(parCount);
    task = CompletableFuture.runAsync(() -> {
      try {
        latch.await(timeout, TimeUnit.MILLISECONDS);
      } catch (InterruptedException ex) {
        // didn't load everything
        throw new RuntimeException("Task timed out", ex);
      }
    });
  }

  public <T> void countdown(CompletableFuture<T> future, Consumer<T> result) {
    if (latch.getCount() > 0) {
      future.thenAccept(res -> {
        result.accept(res);
        latch.countDown();
      });
    }
  }

  protected CompletableFuture<Void> getTask() {
    return task;
  }
}
