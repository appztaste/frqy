package com.drm.algo;

public class ReverseNumWithoutVar {
  public static void main(String[] args) {
    System.out.println(reverse(103543212, length(103543212)));
  }
  
  static int reverse (int num, int factor) {
    if(num < 10) return num;
    return (num % 10) * (int)Math.pow(10, factor - 1) + reverse(num / 10, factor - 1);
  }
  
  static int length(int num) {
    if(num < 10) return 1;
    return 1 + length(num / 10);
  }
}
