package com.drm.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSumPairFromTwoArrays {

  public static void main(String[] args) {
    List<int[]> pairs = findSumPairs(new int[]{6, 2, 3, 8, 4, 12, 9, 13}, 
        new int[]{0, 8, 3, 6, 4}, 12);
    
    for(int[] pair : pairs) {
      System.out.println(Arrays.toString(pair));
    }
  }
  
  public static List<int[]> findSumPairs(int[] a, int[] b, int sum) {
    List<int[]> result = new ArrayList<int[]>();
    Arrays.sort(b);
    
    for(int i = 0; i < a.length; i++) {
      int idx = Arrays.binarySearch(b, sum - a[i]);
      if(idx >= 0) {
        result.add(new int[]{a[i], b[idx]});
      }
    }
    
    return result;
  }

}
