package com.decoded.javautil.path;

import org.apache.commons.lang3.StringUtils;


public class PathUtils {
  /**
   * Joins any number of parts into a path
   * @param parts array of parts
   * @return the final path part0/part1/part2 ... etc.
   */
  public static String joinToPath(String... parts) {
    String path = "";
    for (int i = 0; i < parts.length; i++) {
      path = joinPathParts(path, parts[i]);
    }

    return path;
  }

  /**
   * Join left and right strings into a path
   * <code>left/right</code>
   * @param left left part
   * @param right right part
   * @return the joined path left/right
   */
  private static String joinPathParts(String left, String right) {
    if(StringUtils.isEmpty(right)) {
      return left;
    } else if(StringUtils.isEmpty(left)) {
      return right;
    }

    if(right.charAt(0) == '/') {
      if(left.charAt(left.length() - 1) == '/') {
        return left + (right.length()  == 1 ? "" : right.substring(1));
      } else {
        return left + right;
      }
    } else {
      if(left.charAt(left.length() - 1) == '/') {
        return left + right;
      } else {
        return left + '/' + right;
      }
    }
  }
}
