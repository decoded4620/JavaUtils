package com.decoded.javautil.function;

@FunctionalInterface
public interface Function1<A, R> {
  R apply(A arg);
}
