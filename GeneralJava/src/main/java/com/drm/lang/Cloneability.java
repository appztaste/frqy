package com.drm.lang;

public class Cloneability extends CloneabilityParent implements Cloneable {
  int i = 0;
  
  public static void main(String[] args) {
    Cloneability c = new Cloneability();
    //Cloneability c2 = c.clone();
  }
}

class CloneabilityParent {
  int j = 0;
}
