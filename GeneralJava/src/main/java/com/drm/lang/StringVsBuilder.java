package com.drm.lang;

public class StringVsBuilder {

  public static void main(String[] args) throws InterruptedException {
    String s = "a" + "b";
    String s1 = s + "c";
    String s2 = new String("abc");
    String s3 = new String("def");
    
    Thread.sleep(120000);
  }

}
