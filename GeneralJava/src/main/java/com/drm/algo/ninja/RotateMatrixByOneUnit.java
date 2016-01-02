package com.drm.algo.ninja;

import com.drm.algo.RotateMatrixByOneFace;

public class RotateMatrixByOneUnit {
  static int[][] res = new int[][]{
    {2, 3, 4, 5},
    {1, 6, 7, 8},
    {4, 2, 1, 9},
    {5, 3, 2, 4}
  };
  
  public static void main(String[] args) {
    /*RotateMatrixByOneFace.printMatrix(rotate(new int[][]{
        {2, 3, 4, 5},
        {1, 6, 7, 8},
        {4, 2, 1, 9},
        {5, 3, 2, 4}
    }));
    
    System.out.println();
    
    RotateMatrixByOneFace.printMatrix(rotate(new int[][]{
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}
    }));
    
    System.out.println();

    RotateMatrixByOneFace.printMatrix(rotate(new int[][]{
        {1, 2, 3, 4, 5, 6},
        {6, 7, 8, 9, 10, 5},
        {11, 12, 13, 14, 15, 4},
        {16, 17, 18, 19, 20, 3},
        {21, 22, 23, 24, 25, 2},
        {1, 2, 3, 4, 5, 6}
    }));*/
    
    System.out.println();
    
    RotateMatrixByOneFace.printMatrix(rotate(new int[][]{
        {2, 3, 4, 5},
        {1, 6, 7, 8},
        {4, 2, 1, 9},
        {5, 3, 2, 4}
    }, 3));
  }

  static int[][] rotate(int[][] a) {
    return rotate(a, 1);
  }
  
  static int[][] rotate(int[][] a, int steps) {
    int size = a.length;
    int limit = size/2;
    int oldval = -1;
    int actualSteps = steps % (size * 4);
    
    for(int i = 0; i < limit; i++, size--) {
      int x = i, y = i, xd = 0, yd = 1;
      
      while(true) {
        
        int[] newpos = move(a, x, y, i, actualSteps, size);
        int newx = newpos[0], newy = newpos[1];
        
        if(oldval == -1) {
          oldval = a[x][y];
        } else {
          int tmp = a[newx][newy];
          a[newx][newy] = oldval;
          oldval = tmp;
        }
        
        if(x == i && y == size -1) {
          xd = 1;
          yd = 0;
        } else if (x == size -1 && y == size - 1) {
          xd = 0;
          yd = -1;
        } else if (x == size - 1 && y == i) {
          xd = -1;
          yd = 0;
        }

        x = x + xd;
        y = y + yd;

        if(x == i && y == i) {
          a[newx][newy] = oldval;
          break;
        }
      }
      
      //System.out.println();
    }
    
    return a;
  }
  
  static int[] move(int[][] a, int ox, int oy, int i, int steps, int size) {
    int x = ox, y = oy, xd = 0, yd = 1;
    
    for (int j = 0; j < steps; j++) {
      if (x == i) {
        if (y == size - 1) {
          yd = 0;
          xd = 1;
        } else {
          xd = 0;
          yd = 1;
        }
      } else if (x == size - 1) {
        if (y == 0) {
          yd = 0;
          xd = -1;
        } else {
          yd = -1;
          xd = 0;
        }
      }
      x = x + xd;
      y = y + yd;
    }
    
    return new int[]{x, y};
  }

}
