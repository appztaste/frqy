package com.drm.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Judge {
  static List<String> validNums = new ArrayList<String>();
  
  static {
    validNums.add("zero");
    validNums.add("one");
    validNums.add("two");
    validNums.add("three");
    validNums.add("four");
    validNums.add("five");
    validNums.add("six");
    validNums.add("seven");
    validNums.add("eight");
    validNums.add("nine");
    validNums.add("ten");
  }
  
  public static void main(String[] args) {
    String input = "1, 0, -2, 4, tener, three";
    String[] inputs = input.split(",");
    List<String> num = new ArrayList<>();
    
    for(String in : inputs) {
      try {
        Integer in1 = Integer.parseInt(in);
        num.add(in);
      } catch (NumberFormatException e) {
        String in2 = "";
        if(in.startsWith("negative")) {
          in2 = in.split("\\s")[1];
        } else {
          in2 = in;
        }
        
        if(validNums.contains(in2)) {
          num.add(in);
        } else {
          num.add("Invalid: " + in);
        }
      }
      
    }
    
    Collections.sort(num, new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        try {
          int i1 = Integer.parseInt(o1);
          int i2 = Integer.parseInt(o2);
          return i1 - i2;
        } catch (NumberFormatException e) {
          boolean isNegative1 = o1.startsWith("negative");
          boolean isNegative2 = o2.startsWith("negative");    
          
          
        }
        
        return ;
      }
      
    });
  }
}
