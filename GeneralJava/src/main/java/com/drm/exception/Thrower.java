package com.drm.exception;

public class Thrower {
  private static final ThreadLocal<Exception> toThrow = new ThreadLocal<Exception>();

  public static void throwUnsafely(Exception e) {
    try {
      toThrow.set(e);
      Thrower.class.newInstance();
    } catch (InstantiationException f) {
      throw new RuntimeException("unexpected exception while throwing expected exception", f);
    } catch (IllegalAccessException f) {
      throw new RuntimeException("unexpected exception while throwing expected exception", f);
    } finally {
      toThrow.remove();
    }
  }

  private Thrower() throws Exception {
    throw toThrow.get();
  }
}
