package com.decoded.javautil;

/**
 * Replacement for JavaFX Pair (not in newer JVM after 1.8)
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class Pair<K, V> {
  private final K key;
  private final V value;

  public static <KS, VS> Pair<KS, VS> of(KS key, VS value) {
    return new Pair<>(key, value);
  }

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  /**
   * Gets the key
   * @return type of K
   */
  public K getKey() {
    return key;
  }

  /**
   * Gets the value
   * @return type of V
   */
  public V getValue() {
    return value;
  }
}
