package com.decoded.javautil.path;

import org.junit.Test;


public class PathUtilsTest {
  @Test
  public void testBasic() {
    String test = PathUtils.joinToPath("x", "y");
    assert(test.equals("x/y"));
  }

  @Test
  public void testBasicLeft() {
    String test = PathUtils.joinToPath("x/", "y");
    assert(test.equals("x/y"));
  }
  @Test
  public void testBasicRight() {
    String test = PathUtils.joinToPath("x", "/y");
    assert(test.equals("x/y"));
  }

  @Test
  public void testLeftAndRight() {
    String test = PathUtils.joinToPath("x/", "/y");
    assert(test.equals("x/y"));
  }

  @Test
  public void testLeftRoot() {
    String test = PathUtils.joinToPath("/", "y");
    assert(test.equals("/y"));
  }
  @Test
  public void testRightRoot() {
    String test = PathUtils.joinToPath("x", "/");
    assert(test.equals("x/"));
  }

  @Test
  public void testLeftEmpty() {
    String test = PathUtils.joinToPath("", "y");
    assert(test.equals("y"));
  }
  @Test
  public void testRightEmpty() {
    String test = PathUtils.joinToPath("x", "");
    assert(test.equals("x"));
  }
  @Test
  public void testBothEmpty() {
    String test = PathUtils.joinToPath("", "");
    assert(test.equals(""));
  }

  @Test
  public void testBothRoot() {
    String test = PathUtils.joinToPath("/", "/");
    assert(test.equals("/"));
  }

  @Test
  public void testLeftNull() {
    String test = PathUtils.joinToPath(null, "yy");
    assert(test.equals("yy"));
  }
  @Test
  public void testRightNull() {
    String test = PathUtils.joinToPath("xx", null);
    assert(test.equals("xx"));
  }

  @Test
  public void testChaining() {
    String test = PathUtils.joinToPath("xx", "/yy", "aa/", "bb");
    assert(test.equals("xx/yy/aa/bb"));
  }

  @Test
  public void testNullEmptyChaining() {
    String test = PathUtils.joinToPath("xx", null, "aa/", "", "bb");
    assert(test.equals("xx/aa/bb"));
  }
}
