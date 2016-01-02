package com.drm.sort;

import java.util.Arrays;

public class ShellSort {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sort(new int[]{5, 6, 8, 2, 4, 1, 9, 3, 7, 5})));
  }
  
  public static int[] sort(int[] a) {
    int n = a.length, h = 1;
    
    while(h < n/3) h = 3*h + 1;
    
    while(h >= 1) {
      for(int i = h; i < n; i++) {
        for(int j = i; j >= h && a[j-h] - a[j] > 0; j -= h) {
          Sort.swap(a, j, j-h);
        }
      }
      
      h = h/3;
    }
    
    return a;
  }

}
