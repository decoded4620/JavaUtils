package com.decoded.javautil.concurrent;

import com.decoded.javautil.function.Function2;

import java.util.concurrent.CompletableFuture;


public class Par2<X, Y> extends BasePar {
  private volatile X xResult = null;
  private volatile Y yResult = null;

  public Par2(CompletableFuture<X> futureX, CompletableFuture<Y> futureY) {
    super(2);

    countdown(futureX, x -> xResult = x);
    countdown(futureY, y -> yResult = y);
  }

  public <R> CompletableFuture<R> map(Function2<X, Y, R> resultMapper) {
    return getTask().thenApply(aVoid -> resultMapper.apply(xResult, yResult));
  }

  /**
   * Allows nesting of futures
   * @param resultMapper the function which returns a {@link CompletableFuture} of a new type "R"
   * @param <R> the new type returned by a nested future.
   * @return a {@link CompletableFuture} of the type based on the resultMappers return value (completable future of R).
   */
  public <R> CompletableFuture<R> flatMap(Function2<X, Y, CompletableFuture<R>> resultMapper) {
    return getTask().thenCompose(aVoid -> resultMapper.apply(xResult, yResult));
  }
}
