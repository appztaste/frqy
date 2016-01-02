package com.drm.jvm;

public class PermgenSpaceError {

  public static void main(String[] args) {
    for(long i = 0; i < Long.MAX_VALUE; i++) {
      byte[] b = new byte[100000000];
    }
  }

}
