package com.drm.exception;

import java.io.IOException;

public class TryCatchFinally {
  public static void main(String[] args) {
    //multiCatch();//nothing printed
    //returnVoidInAll();//t-f
    //returnVoidInAllWithExcepionInTry();//t-c-f
    //returnVoidInAllWithExceptionInTryCatch();
    System.out.println(returnAssignmentInAll());
    //System.out.println(returnCalculationInAll());
    //System.out.println(returnCalculationInAllWithThrows());
    //returnInTryCatchNoFinally();
  }

  static void multiCatch() {
    String s = null;
    try {
        String s2 = String.valueOf(s);
      
        //doesn't work as char[] method is called, only valueOf(Object) returns "null" when obj is null
        //String s2 = String.valueOf(null);
        if(s2 == null) {
            throw new IOException();    
        }
    } catch(java.io.IOException | NullPointerException e1) {
        //e1 = new Exception(); //e1 is final implicitly and can't be reassigned
        e1.printStackTrace();
    } catch(Exception e2) {
        e2.printStackTrace();
    }
  }
  
  static void returnVoidInAll() {
    try {
      System.out.println("try");
      return;
    } catch (Exception e) {
      // TODO Auto-generated catch block
      System.out.println("catch");
      e.printStackTrace();
      return;
    } finally {
      System.out.println("finally");
      return;
    }
  }
  
  static void returnVoidInAllWithExcepionInTry() {
    try {
      System.out.println("try");
      throw new Exception("exception from try");
      //return;//unreachable code
    } catch (Exception e) {
      System.out.println("catch");
      return;
    } finally {
      System.out.println("finally");
      return;
    }
  }
  
  static void returnVoidInAllWithExceptionInTryCatch() {
    try {
      System.out.println("try");
      throw new Exception("exception from try");
      //return;//unreachable code
    } catch (Exception e) {
      System.out.println("catch");
      throw new Exception("from catch");//java doesn't complain about handling this!
      //return; //unreachable code
    } finally {
      System.out.println("finally");
      return;
    }
  }
  
  static void returnVoidInAllWithExceptionInTryCatchFinally() {
    try {
      System.out.println("try");
      throw new Exception("exception from try");
      //return;//unreachable code
    } catch (Exception e) {
      System.out.println("catch");
      //throw new Exception("from catch");//java doesn't complain about handling this! so it won't be thrown if finally has return statement!!
      //return; //unreachable code
    } finally {
      System.out.println("finally");
      //throw new Exception("from finally");//java complains about this! so it will be thrown
      //return;//unreachable code
    }
  }
  
  static void returnVoidInAllWithExceptionInTryFinally() {
    try {
      System.out.println("try");
      throw new Exception("exception from try");//return statement in finally gobbles all exception, does it also gobble all calulcations/assignements?
      //return;//unreachable code
    } finally {
      System.out.println("finally");
      //throw new Exception("from finally");//java complains about this! so it will be thrown
      return;
    }
  }
  
  static int returnIntInAllWithDiffValues() { return 0;}
  
  static int returnAssignmentInAll() {
    int a = 0;
    try {
      System.out.println("try");
      a = 1;//ignored
      //throw new Error("error"); finally eats up errors as well
      //throw new StackOverflowError("error"); // even stackoverflowerrors, see MonsterFinally class
      //return a;
    } catch(Exception e) {
      System.out.println("catch");
      a = 2;//ignored
      return a;
    } finally {
      System.out.println("finally");
      a = 3;//this one is returned, since finally globs everything
      return a;
    }
  }
  
  static int returnCalculationInAll() {
    int a = 0;
    try {
      System.out.println("try");
      a = a + 1;//ignored
      return a;
    } catch(Exception e) {
      System.out.println("catch");
      a = a + 2;//ignored
      return a;
    } finally {
      System.out.println("finally");
      a = a + 3;//this one is returned, since finally globs everything. returns 4 since it considers the calculation done in try
      return a;
    }
  }
  
  static int returnCalculationInAllWithThrows() {
    int a = 0;
    try {
      System.out.println("try");
      a = a + 1;//ignored
      throw new Exception("exception from try");
      //return a;
    } catch(Exception e) {
      System.out.println("catch");
      a = a + 2;//ignored
      return a;
    } finally {
      System.out.println("finally");
      a = a + 3;//this one is returned, since finally globs everything. returns 6 since it considers the calculation done in try and catch
      return a;
    }
  }
  
  static void returnInTryCatchNoFinally() {//prints try
    try {
      System.out.println("try");
      return;
    } catch (Exception e) {
      System.out.println("catch");
      return;
    }
  }
  
  static void returnInTryCatchNotInFinally() {//prints try-finally
    try {
      System.out.println("try");
      return;
    } catch (Exception e) {
      System.out.println("catch");
      return;
    } finally {
      System.out.println("finally");
    }
  }
  
  static int returnOnlyInFinally() {//returns 0 since finally is always executed
    try {
      System.out.println("try");
    } catch (Exception e) {
      System.out.println("catch");
    } finally {
      System.out.println("finally");
      return 0;
    }
  }
  
  static void tryWithFinallyOnly() {}
}
