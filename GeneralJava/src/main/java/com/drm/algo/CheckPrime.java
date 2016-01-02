package com.drm.algo;

public class CheckPrime {

  public static void main(String[] args) {
    checkPrime(1);
    checkPrime(1, 2);
    checkPrime(1, 2, 3);
    checkPrime(1, 2, 3, 4);
    checkPrime(1, 2, 3, 4, 5);
    checkPrime(1, 2, 3, 4, 5, 6, 8, 9);
  }

  public static void checkPrime(int ... nums) {
    boolean prime = true;
    for(int i : nums) {
      for(int j = i - 1; j > 1; j--) {
        if(i % j == 0) {
          System.out.println();
          prime = false;
          break;
        }
      }
      
      if(prime) System.out.println(i);
    }
  }
}
