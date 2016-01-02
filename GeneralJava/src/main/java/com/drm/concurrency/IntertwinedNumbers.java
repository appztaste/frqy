package com.drm.concurrency;

//use lock and condition to print odd-even numbers from different threads
//use wait/notify
public class IntertwinedNumbers {
  int count;
  
  public static void main(String[] args) {
    IntertwinedNumbers num = new IntertwinedNumbers();
    new Th(num).start();
    new Th2(num).start();
  }
}

class Th extends Thread {
  int count = 0;
  IntertwinedNumbers mutex;
  
  Th(IntertwinedNumbers m) {
    mutex = m;
  }
  
  public void run() {
    for(int j = 0; j < 50; j++) {
      System.out.println(this);
      synchronized (mutex) {
        if(mutex.count == 0) {
          System.out.println(this + ":" + this.count);
          this.count += 2;
          mutex.count = 1;
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

class Th2 extends Thread {
  int count = 1;
  
  IntertwinedNumbers mutex;
  
  Th2(IntertwinedNumbers m) {
    mutex = m;
  }
  
  public void run() {
    for(int j = 0; j < 50; j++) {
      System.out.println(this);
      synchronized (mutex) {
        if(mutex.count == 1) {
          System.out.println(this + ":" + this.count);
          this.count += 2;
          mutex.count = 0;
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}