package com.drm.algo;

public class RearrangeOddEven {
  static int odds;
  static int evens;
  static boolean even;
  
  public static void main(String[] args) {
    int[] a = new int[]{1, 3, 4, 2, 5, 7, 8, 6};//4,1,2,3,8,5,6,7
    //1,3,5,7,2,6,4,8
    
    rearrange(a, 0, 1);
  }
  
  static void rearrange(int[] a, int idx1, int idx2) {
    if(idx1 % 2 == 0 && a[idx1] % 2 == 0
        && idx2 % 2 == 1 && a[idx2] % 2 == 1) {
      rearrange(a, idx1 + 2, idx2 + 2);
    } else if(idx1 % 2 == 0 && a[idx1] % 2 == 1
        && idx2 % 2 == 1 && a[idx2] % 2 == 0) {
      
      swap(a, idx1, idx2);
      rearrange(a, idx1 + 2, idx2 + 2);
    } else if(idx1 % 2 == 0 && a[idx1] % 2 == 1
        && idx2 % 2 == 1 && a[idx2] % 2 == 1) {
      
      swap(a, idx1, idx2);
      rearrange(a, idx1, idx2 + 1);
    } else if(idx1 % 2 == 0 && a[idx1] % 2 == 0
        && idx2 % 2 == 1 && a[idx2] % 2 == 0) {
      
      swap(a, idx1, idx2);
      rearrange(a, idx1, idx2 + 1);
    } else {
      System.out.println("oops!");
    }
  }
  
  static void swap(int a[], int idx1, int idx2) {
    a[idx1] = a[idx1] - a[idx2];
    a[idx2] = a[idx1] + a[idx2];
    a[idx1] = a[idx2] - a[idx1];
  }
  
  
}
