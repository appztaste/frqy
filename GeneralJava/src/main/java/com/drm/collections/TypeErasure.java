package com.drm.collections;

import java.sql.SQLException;

public class TypeErasure<T extends Exception> {
  public static void main(String[] args) {
    new TypeErasure<RuntimeException>().pleaseThrow(new SQLException());
  }
  
  private void pleaseThrow(final Exception e) throws T {
    throw (T) e;
  }
}
