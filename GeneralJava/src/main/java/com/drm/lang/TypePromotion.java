package com.drm.lang;

/**
 * promotion order - char, short, int, long, float, double
 * promotion doesn't happen in case of wrapper objects
 * boolean doesn't get promoted
 * null is considered an object(small o), now both arrays and Objects qualify. it first goes to array, then to Object
 *  multiple arrays or objects create ambigous error
 * arrays are not autoboxed/unboxed, neither are they promoted
 * 
 * @author drm
 *
 */
public class TypePromotion {
  public static void main(String[] args) {
    //m(1);//int, long, float, double, Integer, Object - throws TypePromotion error after commenting Object
    //m(1.1); //double, Double, Object. not converted to long!
    //m(1.1f);//float, double, Float, Object
    //m(1L);//long, float, double, Long, Object
    //m(new Integer(1));//Integer, Object, int, long, float, double
    //m('a');//char, int, long, float, double, Character, object
    //m(true);//boolean, Boolean, Object
    //m(null);//arrays(char[]/int[]/String[]), Object - presence of more than one array or object throws ambigous error
    m(new int[]{});
  }
  
  static void m(int a, int b){ System.out.println("m1 called");}
  static void m(int a, long b){System.out.println("m2 called");}
  static void m(long a, long b){System.out.println("m3 called");}
  static void m(int a){System.out.println("m4 called");}
  static void m(long a){System.out.println("m5 called");}
  static void m(double a){System.out.println("m6 called");}
  static void m(float a){System.out.println("m7 called");}
  static void m(String a){System.out.println("m8 called");}
  static void m(boolean a){System.out.println("m9 called");}
  static void m(char a){System.out.println("m10 called");}
  static void m(Object a){System.out.println("m11 called");}
  static void m(int[] a){System.out.println("m12 called");}
  static void m(char[] a){System.out.println("m13 called");}
  static void m(Integer a){System.out.println("m14 called");}
  static void m(Boolean a){System.out.println("m15 called");}
  static void m(Character a){System.out.println("m16 called");}
  static void m(Long a){System.out.println("m17 called");}
  static void m(Float a){System.out.println("m18 called");}
  static void m(Double a){System.out.println("m19 called");}
  static void m(String[] a){System.out.println("m20 called");}
  static void m(Integer[] a){System.out.println("m21 called");}
  static void m(Long[] a){System.out.println("m22 called");}
}
