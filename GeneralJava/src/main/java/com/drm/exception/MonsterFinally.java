package com.drm.exception;

public class MonsterFinally {
  public static void main(String[] args) {
    m();
  }
  
  static void m() {
    try {
      System.out.println("try");
      A a = new A();
      return;
    } catch (Exception e) {
      System.out.println("catch");
      return;
    } finally {
      System.out.println("finally");
      return;
    }
  }
}

class A {
  A a = new A();//this causes stackoverflow error, but finally in m() eats it up
  
  A() {
    System.out.println("A's constructor");
  }
}
