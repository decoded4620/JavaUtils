package com.decoded.javautil.concurrent;

import java.util.concurrent.CompletableFuture;


public class Mixer {
  /**
   * Parallel execute completable future, and map results nicely to a handler
   * @param aF the future of a
   * @param bF the future of b
   * @param <A> the type of a
   * @param <B> the type of b
   * @return a {@link Par2}
   */
  public static <A, B> Par2<A, B> par(CompletableFuture<A> aF, CompletableFuture<B> bF) {
    return new Par2<>(aF, bF);
  }

  /**
   * Parallel execute completable future, and map results nicely to a handler
   * @param aF future of a
   * @param bF future of b
   * @param cF future of c
   * @param <A> type of a
   * @param <B> type of b
   * @param <C> type of c
   * @return a {@link Par3}
   */
  public static <A, B, C> Par3<A, B, C> par(CompletableFuture<A> aF, CompletableFuture<B> bF, CompletableFuture<C> cF) {
    return new Par3<>(aF, bF, cF);
  }

  /**
   * Parallel execute completable future, and map results nicely to a handler
   * @param aF future of a
   * @param bF future of b
   * @param cF future of c
   * @param dF future of d
   * @param <A> type of a
   * @param <B> type of b
   * @param <C> type of c
   * @param <D> type of d
   * @return a {@link Par4}
   */
  public static <A, B, C, D> Par4<A, B, C, D> par(CompletableFuture<A> aF,
      CompletableFuture<B> bF,
      CompletableFuture<C> cF,
      CompletableFuture<D> dF) {
    return new Par4<>(aF, bF, cF, dF);
  }

  /**
   * The future value (Completed)
   * @param value a value
   * @param <U> the type
   * @return a {@link CompletableFuture} of the value.
   */
  public static <U> CompletableFuture<U> future(U value) {
    return CompletableFuture.completedFuture(value);
  }
}
