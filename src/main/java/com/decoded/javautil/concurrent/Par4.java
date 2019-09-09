package com.decoded.javautil.concurrent;

import com.decoded.javautil.function.Function3;
import com.decoded.javautil.function.Function4;

import java.util.concurrent.CompletableFuture;


public class Par4<W, X, Y, Z> extends BasePar {
  private volatile W wResult = null;
  private volatile X xResult = null;
  private volatile Y yResult = null;
  private volatile Z zResult = null;

  public Par4(CompletableFuture<W> futureW,
      CompletableFuture<X> futureX,
      CompletableFuture<Y> futureY,
      CompletableFuture<Z> futureZ) {
    super(3);
    countdown(futureW, w -> wResult = w);
    countdown(futureX, x -> xResult = x);
    countdown(futureY, y -> yResult = y);
    countdown(futureZ, z -> zResult = z);
  }

  public <R> CompletableFuture<R> map(Function4<W, X, Y, Z, R> resultMapper) {
    return getTask().thenApply(aVoid -> resultMapper.apply(wResult, xResult, yResult, zResult));
  }


  /**
   * Allows nesting of futures
   * @param resultMapper the function which returns a {@link CompletableFuture} of a new type "R"
   * @param <R> the new type returned by a nested future.
   * @return a {@link CompletableFuture} of the type based on the resultMappers return value (completable future of R).
   */
  public <R> CompletableFuture<R> flatMap(Function4<W, X, Y, Z, CompletableFuture<R>> resultMapper) {
    return getTask().thenCompose(aVoid -> resultMapper.apply(wResult, xResult, yResult, zResult));
  }
}
