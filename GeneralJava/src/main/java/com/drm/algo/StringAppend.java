package com.drm.algo;

import java.util.ArrayList;
import java.util.Collection;

public class StringAppend {

  public static void main(String[] args) {
    String s = "";
    
    for(int i = 0; i < 20; i++) {
      s += String.valueOf(i);
    }
    
    final Collection<? extends Number> foo = new ArrayList<Number>();
    //foo.add(new Integer(1));
    foo.add(null);
    //foo.add(new Object());
    foo = null;
  }

}
