package com.decoded.javautil;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Replacement for JavaFX Pair (not in newer JVM after 1.8)
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class Pair<K, V> {
  private final K key;
  private final V value;

  @JsonCreator
  public Pair(@JsonProperty("key") K key, @JsonProperty("value") V value) {
    this.key = key;
    this.value = value;
  }

  public static <KS, VS> Pair<KS, VS> of(KS key, VS value) {
    return new Pair<>(key, value);
  }

  /**
   * Gets the key
   *
   * @return type of K
   */
  @JsonProperty
  public K getKey() {
    return key;
  }

  /**
   * Gets the value
   *
   * @return type of V
   */
  @JsonProperty
  public V getValue() {
    return value;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("key", key).append("value", value).toString();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Pair<?, ?> pair = (Pair<?, ?>) o;

    return new EqualsBuilder().append(key, pair.key).append(value, pair.value).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(key).append(value).toHashCode();
  }
}
