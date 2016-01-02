package com.drm.lang;

public class InnerClasses {
  
  InnerClasses() {
    System.out.println(this);
  }
  
  class A extends InnerClasses{
    A() {
      System.out.println(this);
      System.out.println(InnerClasses.this);
    }
  }
  
  //class B extends A{}
  
  /*void m() {
    class A extends InnerClasses.A{}  
  }*/
  
  public static void main(String[] args) {
    InnerClasses i = new InnerClasses();
    InnerClasses.A a = i.new A();
  }
}
