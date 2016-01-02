package com.drm.algo.ninja;

public class RotateMatrixByOneUnitAlt {

  public static void main(String[] args) {
    rotate(new int[][]{
        {2, 3, 4, 5},
        {1, 6, 7, 8},
        {4, 2, 1, 9},
        {5, 3, 2, 4}
        }, 4);
  }
  
  static void rotate(int[][] a, int size) {
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        System.out.println(a[i][j] + ": " + i + ", " + j);
        
        int circle = i < j ? i : j;
        
        if(circle % 2 == 0 ) {
          int newpos[] = posn(i, j, size, 1);
          System.out.println(a[i][j] + ": " + newpos[0] + ", " + newpos[1]);
        } else {
          int newpos[] = posn(i, j, size, -1);
          System.out.println(a[i][j] + ": " + newpos[0] + ", " + newpos[1]);
        }
      }
      
      System.out.println();
    }
  }
  
  static int[] posn(int i, int j, int size, int rotateBy) {
    int hilo[] = hilo(i, j, size);
    
    int newi = i + rotateBy;
    int newj = -1;
    if(newi > hilo[1]) {
      newi = newi - rotateBy;
      newj = j - rotateBy;
    }
    if(newj < hilo[2]) {
      newj = newj + rotateBy;
      newi = i - rotateBy;
    }
    
    if(newi < hilo[0]) {
      newi = newi + rotateBy;
      newj = j + rotateBy;
    }
    
    if(newj > hilo[3]) {
      newj = newj - rotateBy;
      newi = i + rotateBy;
    }
    
    return new int[]{newi, newj};
  }
  
  static int[] hilo(int i, int j, int size) {
    int rd = size - 1 - j;
    int ld = j;
    int xd = ld < rd ? ld : rd;
    
    int xlo = xd;
    int xhi = size - 1 - xd;
    
    int td = i;
    int bd = size - 1 - i;
    int yd = td < bd ? td : bd;
    
    int ylo = yd;
    int yhi = size - 1 - yd;
    
    return new int[]{xlo, xhi, ylo, yhi};
  }

}
