package com.drm.lang;

public class IntegerOverflow {

  public static void main(String[] args) throws Exception {
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Double.MIN_VALUE);
    System.out.println(Double.MAX_VALUE);
    System.out.println(Double.min(Double.MIN_VALUE, 0.0d));
    System.out.println(Double.MIN_VALUE < 0.0d);
    System.out.println(0.0/0.0 == 0.0/0.0);
    
    /*
     * overflows because unsigned left shift keeps moving the single bit to the left
     * until it falls off the edge. so the last
     * why does it print minvalue
     * understand 2's complement
     * how to see what a certain byte representation will print 
     * why deosn't this work i<<<=1
     */
    /*for(int i = 1; i < Integer.MAX_VALUE; i >>>= 1) {
      System.out.println(i);
    }*/
    
    /*for(int i = 1; i < Integer.MAX_VALUE; i += 100000) {
      System.out.println(i);
    }*/
  }
}
