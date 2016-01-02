package com.drm.algo;

public class SwapIntegers {
  static int i = 10, j = 2;
  public static void main(String[] args) {
    swapBySubtraction(i, j);
    swapByDivision(i, j);
    swapByXor(i, j);
  }
  
  static void swapBySubtraction(int a, int b) {
    a = a - b;
    b = b + a;
    a = b - a;
    
    System.out.println("a = " + a + ", b = " + b);
  }
  
  static void swapByDivision(int a, int b) {
    a = a / b;
    b = b * a;
    a = b / a;
    
    System.out.println("a = " + a + ", b = " + b);
  }
  
  static void swapByXor(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    
    System.out.println("a = " + a + ", b = " + b);
  }

}
