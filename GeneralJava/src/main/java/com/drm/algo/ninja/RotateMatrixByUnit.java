package com.drm.algo.ninja;

import java.util.Arrays;

import static com.drm.algo.RotateMatrixByOneFace.*;

public class RotateMatrixByUnit {
  static int[][] res = new int[][]{
    {2, 3, 4, 5},
    {1, 6, 7, 8},
    {4, 2, 1, 9},
    {5, 3, 2, 4}
  };
  
  public static void main(String[] args) {
    printMatrix(rotate(new int[][]{
        {2, 3, 4, 5},
        {1, 6, 7, 8},
        {4, 2, 1, 9},
        {5, 3, 2, 4}
    }, 2));
    
    printMatrix(rotate(new int[][]{
        {1,     2,      3,      4,      5},
        {6,     7,      8,      9,      10},
        {11,    12,     13,     14,     15},
        {16,    17,     18,     19,     20},
        {21,    22,     23,     24,     25}
    }, 5));
    
    printMatrix(rotate(new int[][]{
        {1,     2,      3,      4,      5,      6},
        {6,     7,      8,      9,      10,     5},
        {11,    12,     13,     14,     15,     4},
        {16,    17,     18,     19,     20,     3},
        {21,    22,     23,     24,     25,     2},
        {1,     2,      3,      4,      5,      6}
    }, 3));
    
    printMatrix(rotate(new int[][]{
        {2, 3, 4, 5},
        {1, 6, 7, 8},
        {4, 2, 1, 9},
        {5, 3, 2, 4}
    }, 6));
    
    printMatrix(rotate(new int[][]{
        {2, 3, 4, 5},
        {1, 6, 7, 8},
        {4, 2, 1, 9},
        {5, 3, 2, 4}
    }, -4));
  }

  static int[][] rotate(int[][] matrix) {
    return rotate(matrix, 1);
  }
  
  static int[][] rotate(int[][] matrix, int steps) {
    int size = matrix.length;
    int limit = size/2;
    
    for(int ring = 0; ring < limit; ring++, size = size - 2) {
      
      int flatSize = 4 * (size - 1) - 1;
      int actualSteps = steps % (flatSize + 1);
      int pivot = flatSize - actualSteps;
      
      if(actualSteps == 0) continue;
      
      //System.out.println("Ring: " + ring);
      for(int j = 0, k = pivot; j < k; j++, k--) {
        swap(matrix, find2dIndices(j, size, ring), find2dIndices(k, size, ring));
      }
      
      //printMatrix(matrix);
      
      for(int j = pivot + 1, k = flatSize; j < k; j++, k--) {
        swap(matrix, find2dIndices(j, size, ring), find2dIndices(k, size, ring));
      }
      
      //printMatrix(matrix);
      
      for(int j = 0, k = flatSize; j < k; j++, k--) {
        swap(matrix, find2dIndices(j, size, ring), find2dIndices(k, size, ring));
      }
      
      //printMatrix(matrix);
    }
    
    return matrix;
  }
  
  static int[] find2dIndices(int flatIdx, int size, int ring) {
    int x = 0, y = 0;
    int[] res = new int[2];
    
    int seg = flatIdx / (size - 1);
    int spill = flatIdx % (size - 1);
    
    if(spill == 0) {
      seg--;
      spill = size - 1;
    }
    
    if(seg == 0) {
      x = 0; y = spill; 
    } else if(seg == 1) {
      y = size - 1; x = spill;
    } else if(seg == 2) {
      x = size - 1; y = size - 1 - spill;
    } else if(seg == 3) {
      y = 0; x = size - 1 - spill;
    }
    
    res[0] = x + ring; res[1] = y + ring;
    
    //System.out.println("2D indices for flat index " + flatIdx + " are: " + Arrays.toString(res));
    
    return res;
  }

}
