package com.drm.math;

import java.util.Scanner;

public class CheckPrime {

  public static void main(String[] args) {
    Scanner sc = null;
    try {
      sc = new Scanner(System.in);
      
      while(sc.hasNext()) {
        int num = sc.nextInt();
        
        if(num <= 0) {
          break;
        }
        
        System.out.println(isPrime(num));
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      sc.close();
    }
  }
  
  static boolean isPrime(int num) {
    boolean res = true;
    for(int i = num - 1; i > 1; i--) {
      if(num % i == 0) {
        System.out.println(num + " is not prime");
        res = false;
        break;
      }
    }
    
    return res;
  }

}
