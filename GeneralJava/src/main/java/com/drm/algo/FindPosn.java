package com.drm.algo;

public class FindPosn {

  public static void main(String[] args) {
    System.out.println(findPos(6, new int[] {3, 4, 3, 2, 3, 4, 5, 6, 7}));
  }

  static int findPos(int num, int[] array) {
    for (int i = 0, diff = Math.abs(num - array[i]); i < array.length; i += diff) {
      diff = Math.abs(num - array[i]);
      if (diff == 0) return i;
    }

    return -1;
  }

}
