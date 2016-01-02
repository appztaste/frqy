package com.drm.algo;

/**
 * rotates by 90. see how to 
 * a) rotate n(input) no. of times.
 * b) rotate in place
 * c) rotate with less complexity
 * 
 * @author drm
 *
 */
public class RotateMatrixByOneFace {
  static int n = 4;
  static int num = 1;
  static int[][] matrix = new int[n][n];
  static int[][] newmatrix = new int[n][n];

  public static void main(String[] args) {
    
    printMatrix(populateMatrix(matrix));
    printMatrix(rotateMatrix(matrix));
    System.out.println(matrix.length + "x" + matrix[0].length);
  }
  
  static int[][] populateMatrix(int[][] matrix) {
    for(int i = 0; i < n ; i++) {
      for(int j = 0; j < n; j++) {
        matrix[i][j] = num++;
      }
    }
    
    return matrix;
  }
  
  public static void printMatrix(int[][] matrix) {
    for(int i = 0; i < matrix.length ; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }
    
    System.out.println();
  }
  
  static int[][] rotateMatrix(int[][] matrix) {
    for(int i = 0; i < n ; i++) {
      for(int j = 0; j < n; j++) {
        newmatrix[j][n-i-1] = matrix[i][j];
      }
    }
    
    return newmatrix;
  }
  
  public static void swap(int[][] matrix, int[] from, int[] to) {
    //System.out.println("Swapping " + matrix[from[0]][from[1]] + " and " + matrix[to[0]][to[1]]);
    int tmp = matrix[from[0]][from[1]];
    matrix[from[0]][from[1]] = matrix[to[0]][to[1]];
    matrix[to[0]][to[1]] = tmp;
  }

}
