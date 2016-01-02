package com.drm.hr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArray {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    try {
      int strings = s.nextInt();
      Map<String, Integer> map = new HashMap<>();
      
      for(int i = 0; i < strings; i++) {
        String str = s.next();
        int cnt = safeGet(map.get(str));
        map.put(str, ++cnt);
      }
      
      int queries = s.nextInt();
      for(int i = 0; i < queries; i++) {
        System.out.println(safeGet(map.get(s.next())));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      s.close();
    }
  }
  
  static int safeGet(Integer i) {
    return i == null ? 0 : i;
  }

}
