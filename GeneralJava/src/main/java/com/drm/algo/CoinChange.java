package com.drm.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Find exact change of input amount with currencies 1,3,4,5,10,20,30,40,50,100
 * such that you use the minimum no. of coins from at most four denominations
 * 
 * change for 167 should be - 100, 50, 10, 1, 1, 1, 1, 1, 1, 1
 * 196 - 100, 50, 40, 1, 1, 1, 1, 1, 1
 * 
 * @author drm
 *
 */
public class CoinChange {
  public static void main(String[] args) {
    System.out.println(changeOf(167));
  }

  static Map<Integer, Integer> changeOf(int amt) {
    int densUsed = 0;
    int[] den = new int[]{1, 3, 4, 5, 10, 20, 30, 40, 50, 100};
    Map<Integer, Integer> coins = new HashMap<>();
    
    int hundreds = amt / 100;
    int left = amt % 100;
    coins.put(100, hundreds);
    
    if(hundreds > 0) densUsed++;
    
    if(left > 60) {
      int fifties = amt / 50;
      left = left % 50;
      coins.put(50, fifties);
      if(fifties > 0) densUsed++;
      
      int forties = left / 40;
      left = left % 40;
      coins.put(40, forties);
      if(forties > 0) densUsed++;
      
      int thirties = left / 30;
      left = left % 30;
      coins.put(30, thirties);
      if(thirties > 0) densUsed++;
      
      int twenties = left / 20;
      left = left % 20;
      coins.put(20, twenties);
      if(twenties > 0) densUsed++;
      
      int tens = left / 10;
      left = left % 10;
      coins.put(10, tens);
      if(tens > 0) densUsed++;
      
      addOnes(coins, left, densUsed);
    } else {
      addOnes(coins, left, densUsed);
    }
    
    return coins;
  }
  
  private static void addOnes(Map<Integer, Integer> coins, int left, int densUsed) {
    
  }
}
