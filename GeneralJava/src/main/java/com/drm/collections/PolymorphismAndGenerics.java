package com.drm.collections;
import java.io.IOException;
import java.util.List;


public class PolymorphismAndGenerics {}

class Child extends Parent {
  int i = 5;
  static int k = 6;
  
  static void s1() { System.out.println("Child.s1()");}
  
  //can't change return type while overriding (even in case of a static method!)
  //static boolean s2() { System.out.println("Child.s2()");}
  static String s3() { System.out.println("Child.s3()"); return null;}
  
  //can't throw wider exception, static method even though is not overriding (it's hiding)
  //still follows all rules of overriding
  //static void s4() throws Exception { System.out.println("Child.s4()"); }
  
  void m1() { System.out.println("in 1");}
  
  void m5(String s) { System.out.println("in 1.5-s");}
  
  void m6(Object obj) { System.out.println("in 1.6-o");}
  
  void m7(int i) { System.out.println("in 1.7-i");}
  
  String m8() { System.out.println("in 1.8-s"); return null;}
  
  Object m9() { System.out.println("in 1.9-o"); return null;}
  
  void m10() throws IOException { System.out.println("in 1.10, IOException");}
  
  void m11(List<String> ls) { System.out.println("in 1.11-ls");}
  
  void m12(List<?> lu) { System.out.println("in 1.12-lu");}
  
  void m13(List<Object> lo) { System.out.println("in 1.13-lo");}
  
  List<String> m14() { System.out.println("in 1.14-ls"); return null; }
  
  List<Object> m15() { System.out.println("1.15-lo"); return null; }
  
  List<?> m16() { System.out.println("1.16-lu"); return null; }
  
  <T> T m17() { System.out.println("in 1.17-t"); return null; }
  
  <T> T m18(List<T> lt) { System.out.println("in 1.18-lt"); return null;}
}

class Parent {
  int i = 0;
  int j = 1;
  static int k = 2;
  static int l = 3;
  
  static void s1() { System.out.println("Parent.s1()");}
  
  static void s2() { System.out.println("Parent.s2()");}
  
  static Object s3() { System.out.println("Parent.s3()"); return null;}
  
  static void s4() throws IOException { System.out.println("Parent.s4()"); }
  
  void m1() { System.out.println("in 2"); }
  
  void m2(String s) {}
  
  //duplicate method since name and signature are same
  /*void m2(String s) {
    
  }*/
  
  //again duplicate method, varying only return type is not enough
  //for overloading: name should be same, sig should be diff
  //return type doesn't matter
  /*int m2(String s) {
    
  }*/
  
  void m2(int i) { System.out.println("m2 overloaded with int"); }
  
  int m2(double d) {
    System.out.println("m2 overloaded with double. return type is diff - doesn't matter");
    return 0;
  }
  
  void m2(Integer i) { System.out.println("m2 overloaded with Integer. Object and primitives are not same"); }
  
  void m2(char c) { System.out.println("m2 overloaded with char"); }
  
  void m2(boolean b) { System.out.println("m2 overloaded with bool"); }
  
  void m3(Integer i) { System.out.println("m3(Integer), ints will be autoboxed"); }
  
  void m4(int i) { System.out.println("m4(int), chars will be coerced"); }
  
  void m5(Object o) { System.out.println("2.5(o)"); }
  
  void m6(String s) { System.out.println("2.6(s)"); }
}

class Test3 {
  public static void main(String[] args) {
    Child t1 = new Child();
    t1.m1();
    t1.m2(0);//int is not coerced into double, more specific method(int) is chosen
    t1.m2(new Integer(1));//more specific method (Integer) is chosen
    t1.m2(false);//no coercing
    t1.m2('c');//no coercing
    t1.m3(0);//autoboxed to Integer
    t1.m4('c');//coerced to int
    t1.m5(new Object());//no overriding, 2.5-o is called
    t1.m5("");//1.5-s is called
    t1.m6(new Object());
    t1.m6("");
    
    System.out.println(t1.i + ", " + t1.j + ", " + t1.k);
    t1.s1();t1.s2();t1.s3();
    
    Parent t2 = new Child();
    System.out.println(t2.i + ", " + t2.j + ", " + t2.k);
    t2.s1();t2.s2();t2.s3();
    
    Parent t3 = new Parent();
    System.out.println(t3.i + ", " + t3.j + ", " + t3.k);
    t3.s1();t3.s2();t3.s3();
    
    t1.i = 15;
    t1.j = 16;
    t1.k = 17;
    t2.i = 18;
    t2.j = 19;
    t2.k = 20;
    t3.i = 21;
    t3.j = 22;
    t3.k = 23;
    
    System.out.println(t1.i + ", " + t1.j + ", " + t1.k);
    System.out.println(t2.i + ", " + t2.j + ", " + t2.k);
    System.out.println(t3.i + ", " + t3.j + ", " + t3.k);
  }
}