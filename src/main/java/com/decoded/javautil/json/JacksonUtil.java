package com.decoded.javautil.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Optional;


/**
 * Utility for dealing with {@link ObjectMapper} and other Jackson features.
 */
public class JacksonUtil {
  private static final Logger LOG = LoggerFactory.getLogger(JacksonUtil.class);

  /**
   * Serialize a string to the specified type using Jackson. Returns Optional.empty() if object mapper returns null or
   * throws exceptions.
   *
   * @param json   A {@link String} of json. Nullable so that dynamic operations can pass null, and let the Optional
   *               branching
   *               handle the result.
   * @param toType the {@link Class}
   * @param <T>    the type of the class
   * @return Optional of the specified type or empty if it cannot be deserialized
   */
  public static <T> Optional<T> deserialize(@Nullable String json, Class<T> toType) {
    try {
      return Optional.ofNullable(new ObjectMapper().readValue(json, toType));
    } catch (IOException ex) {
      LOG.warn("Deserialize exception", ex);
      return Optional.empty();
    }
  }

  /**
   * Deserialize a type reference
   *
   * @param json the json
   * @param toType the type reference
   * @param <T> the type
   * @return the optional instance of T or empty optional.
   */
  public static <T> Optional<T> deserialize(@Nullable String json, TypeReference<T> toType) {
    try {
      return Optional.ofNullable(new ObjectMapper().readValue(json, toType));
    } catch (IOException ex) {
      LOG.warn("Deserialize exception", ex);
      return Optional.empty();
    }
  }

  /**
   * Serialize a type to JSON
   *
   * @param object the object of type T
   * @param <T>    the type of the object
   * @return a {@link String} of JSON.
   */
  public static <T> String serialize(T object) {
    try {
      return new ObjectMapper().writeValueAsString(object);
    } catch (IOException ex) {
      LOG.warn("Serialize exception", ex);
      throw new RuntimeException("Could not serialize object due to error", ex);
    }
  }
}
