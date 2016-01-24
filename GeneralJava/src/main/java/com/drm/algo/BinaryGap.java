package com.drm.algo;

public class BinaryGap {

  public static void main(String[] args) {
    System.out.println(solution(1041));
  }

  static int solution(int n) {
    String bin = Integer.toBinaryString(n);
    int i = bin.indexOf("1"), i2 = -1, gap = 0;

    while (i != -1) {
      i2 = bin.indexOf("1", i + 1);

      if (i2 != -1) {
        int newgap = i2 - i - 1;
        gap = gap > newgap ? gap : newgap;
      }

      i = i2;
    }

    return gap;
  }

}
