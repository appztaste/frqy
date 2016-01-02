package com.drm.search;

import java.util.Arrays;

import com.drm.sort.InsertionSort;

public class BinarySearch {

  public static void main(String[] args) {
    //check Arrays' binary search
    int[] a = {8, 3, 12, 6, 1, 5, 7, 0};
    int key = 19;
    
    InsertionSort.simple(a, true);//we need a sorted array for binary search, use a simple insertion sort
    System.out.println(Arrays.toString(a));
    System.out.println(search(0, a.length - 1, key, a));
    System.out.println(searchR(0, a.length - 1, key, a));
  }
  
  public static int search(int low, int high, int key, int[] a) {
    while(low <= high) {
      int mid = low + (high - low)/2;
      
      if(a[mid] == key) {
        return mid;
      } else if (a[mid] > key) {//coded for ascending ordered array
        high = mid - 1;
      } else {
        low = mid + 1;
      } 
    }
    
    /*
     * 1) low and high would have converged to this point, so both are same, it doesn't matter which variable you use
     * 2) this returns the point where it would be inserted and all prior sorted elements shifted in case of 
     * an insertion sort using binary search. (of course ignore the negative sign, that just indicates the key wasn't found)
     */
    return -low;
  }
  
  public static int searchR(int lo, int hi, int key, int[] a) {
    if(hi < lo) return -lo;
    
    int mid = lo + (hi - lo) /2;
    
    if(a[mid] == key) {
      return mid;
    } else if (a[mid] > key) {
      hi = mid - 1;
    } else {
      lo = mid + 1;
    }
    
    return searchR(lo, hi, key, a);
  }
}
