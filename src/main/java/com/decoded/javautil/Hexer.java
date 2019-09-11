package com.decoded.javautil;

/**
 * Converter for byte arrays / strings
 */
public class Hexer {

  /**
   * Creates a hex version of a byte array
   * @param hashInBytes the hash bytes
   * @return a hex string
   */
  public static String bytesToHex(byte[] hashInBytes) {
    StringBuilder sb = new StringBuilder();
    for(byte theByte : hashInBytes) {
      sb.append(Integer.toString((theByte & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }
}
