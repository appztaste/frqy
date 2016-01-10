package com.drm.algo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class KVPStrings {

  public static void main(String[] args) {
    Map<Integer, String> m = new TreeMap<>(new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.intValue() - o2.intValue();
      }
      
    });
    
    m.put(1, "1");
    m.put(3, "3");
    m.put(2, "2");
    m.put(5, "5");
    m.put(4, "4");
    
    System.out.println(m);
  }

}
