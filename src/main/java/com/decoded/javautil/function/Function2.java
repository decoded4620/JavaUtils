package com.decoded.javautil.function;

@FunctionalInterface
public interface Function2<A, B, R> {
  public R apply(A a, B b);
}
