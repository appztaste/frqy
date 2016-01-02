package com.drm.sort;

import java.util.Arrays;

import com.drm.search.BinarySearch;

public class InsertionSort extends Sort {

  public static void main(String[] args) {
    int[] a = {8, 3, 12, 6, 1, 5, 7, 0};
    //simple(a, false);
    binarySort(a);
    System.out.println(Arrays.toString(a));
  }
  
  static void binarySort(int[] a) {
    for(int i = 1; i < a.length; i++) {
      int curr = a[i];
      int pos = 0 - BinarySearch.search(0, i - 1, curr, a);
      
      if(pos != i) {
        System.out.println(curr + " should be at: " + pos);
        shift(a, pos, i - 1, 1);
        a[pos] = curr;
      }
    }
  }
  
  public static void simple(int[] a, boolean asc) {
    for(int i = 1; i < a.length; i++) {
      for(int j = i; j > 0; j--) {
        int res = asc ? a[j] - a[j - 1] : a[j - 1] - a[j]; 
        if(res < 0) {
          swap(a, j, j - 1);
        } else {
          break;
        }
      }
    }
  }
  
  /**
   * assumed that subarray from end till (end + offset) are empty or stored elsewhere already
   * @param a
   * @param start
   * @param end
   * @param offset
   */
  static void shift(int[] a, int start, int end, int offset) {
    if(end < start) throw new IllegalArgumentException("end should be >= start");
    
    int sublength = end - start + 1;
    if(a.length < sublength + offset) throw new IllegalArgumentException("array isn't big enough for shifting");
    
    for(int i = end; i >= start; i--) {
      a[i + offset] = a[i];
    }
  }

}
