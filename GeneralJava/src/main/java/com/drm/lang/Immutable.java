package com.drm.lang;

public class Immutable {
  private int i = 0;
  
  int getI() {
    return i;
  }
}

class ImmutableBuster extends Immutable {
  ImmutableBuster() {
    //super.
  }
}