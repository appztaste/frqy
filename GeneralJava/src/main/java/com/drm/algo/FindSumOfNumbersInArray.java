package com.drm.algo;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author drm
 *
 */
public class FindSumOfNumbersInArray {

  public static void main(String[] args) {
    int[] num1 = new int[]{9, 2, 1, 0, 6, 5};
    int[] num2 = new int[]{4, 3, 8, 0, 7, 5, 4};
    
    System.out.println(Arrays.toString(findSumWithoutStack(num1, num2)));
    System.out.println(921065 + 4380754);
  }
  
  static int[] findSumWithoutStack(int[] num1, int[] num2) {
    Stack<Integer> s = new Stack<>();
    int sum = 0;

    int i = num1.length - 1, j = num2.length - 1;
    while(i >= 0 || j >= 0) {
      if(i >= 0) {
        sum += num1[i];
        i--;
      }
      
      if(j >= 0)  {
        sum += num2[j];
        j--;
      }

      if(sum >= 10) {
        s.push(sum % 10);
        sum = 1;
      } else {
        s.push(sum);
        sum = 0;
      }
    }

    int[] res = new int[s.size()];
    int idx = 0;
    while(!s.empty()) {
      res[idx] = s.pop();
      idx++;
    }
    
    return res;
  }

}
