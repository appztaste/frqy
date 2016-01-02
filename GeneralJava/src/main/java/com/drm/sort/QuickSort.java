package com.drm.sort;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortArray(new int[]{8, 3, 12, 6, 1, 5, 7, 0})));
  }
  
  public static int[] sortArray(int[] a) {
    sort(a, 0, a.length - 1);
    return a;
  }
  
  public static void sort(int []a, int lo, int hi) {
    if(hi <= lo) return;
    int partition = partition(a, lo, hi);
    sort(a, lo, partition - 1);
    sort(a, partition + 1, hi);
  }
  
  public static int partition(int[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    
    while (true) {
      while (a[++i] <= a[lo] && i < hi) {
      }

      while (a[--j] >= a[lo] && j > lo) {
      }
      
      if(i >= j) break;
      Sort.swap(a, i, j);
    }
    
    Sort.swap(a, j, lo);
    
    return j;
  }

}
