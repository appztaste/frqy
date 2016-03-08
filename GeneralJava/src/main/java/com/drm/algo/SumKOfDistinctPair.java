package com.drm.algo;

import java.util.*;

/**
 * Given an input array and sum k, find number pairs in the array which add up to k.
 * numbers can repeat. output should be distinct pairs.
 *
 * Input:
 * 16 (number to find)
 * 12 (no. of numbers)
 * 5 10 2 3 9 6 8 4 7 11 9 8 (numbers)
 *
 * Output:
 * 5, 11
 * 10, 6
 * 9, 7
 * 8, 8
 *
 * @author drm
 */
public class SumKOfDistinctPair {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      process(sc);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sc.close();
    }
  }

  private static void process(Scanner sc) {
    int sum = sc.nextInt();
    int count = sc.nextInt();
    int[] input = new int[count];

    for(int i = 0; i < count; i++) {
      input[i] = sc.nextInt();
    }

    Map<Integer, Integer> result = findNumber(input, sum);
    if(result.size() > 0) {
      for(Map.Entry<Integer, Integer> e : result.entrySet()) {
        System.out.println(e.getKey() + ", " + e.getValue());
      }
    } else {
      System.out.println("No pair found");
    }
  }

  private static Map<Integer, Integer> findNumber(int[] input, int sum) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> result = new HashMap<>();

    for(int i = 0; i < input.length; i++) {
      int diff = sum - input[i];

      if(diff >= 0 && map.containsKey(diff) && !result.containsKey(diff) && !result.containsValue(diff)) {
        result.put(diff, input[i]);
      }

      map.put(input[i], i);
    }

    return result;
  }

}
