package com.drm.pool;

import java.util.Arrays;

public class SingletonClub {
  public static void main(String[] args) {
    SingletonAction.init(10);
    
    Runnable runnable = new Runnable(){
      public void run() {
        while (true) {
          System.out.println(SingletonAction.getInstance());
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };
    
    new Thread(runnable, "thread1").start();
    new Thread(runnable, "thread2").start();
  }
}

class SingletonAction {
  private static SingletonAction[] singletons;
  private static int count;
  private String name;
  
  private SingletonAction(String name) {
    this.name = name;
  }
  
  public static void init(int size) {
    singletons = new SingletonAction[size];
  }
  
  public void action() {
    System.out.println("Pizza.action()");
  }
  
  synchronized public static SingletonAction getInstance() {
    System.out.println("Incoming thread: " + Thread.currentThread().getName() + ", Count: " + count);
    System.out.println("Singletons: " + Arrays.toString(singletons));
    SingletonAction singleton = null;
    
    if(count < singletons.length) {
      singleton = new SingletonAction("" + count);
      singletons[count++] = singleton;
    } 
    
    System.out.println("Singletons: " + Arrays.toString(singletons));
    return singleton;
  }
  
  @Override
  public String toString() {
    return name;
  }
}
