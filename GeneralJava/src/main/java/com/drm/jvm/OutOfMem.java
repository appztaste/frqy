package com.drm.jvm;

public class OutOfMem {

  public static void main(String[] args) {
    arraySizeExceedsVmLimit();
  }

  static void arraySizeExceedsVmLimit() {
    for (int i = 3; i >= 0; i--) {
      try {
        int[] arr = new int[Integer.MAX_VALUE-i];
        System.out.format("Successfully initialized an array with %,d elements.\n", Integer.MAX_VALUE-i);
      } catch (Throwable t) {
        t.printStackTrace();
      }
    }
  }
}
