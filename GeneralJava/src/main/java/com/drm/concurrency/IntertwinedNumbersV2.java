package com.drm.concurrency;

public class IntertwinedNumbersV2 {

  public static void main(String[] args) {
    Object lock = new Object();
    Stream stream1 = new Stream(0, lock);
    Stream stream2 = new Stream(1, lock);
    stream1.next = stream2;
    stream2.next = stream1;
    
    stream1.start();
    stream2.start();
    
    stream1.proceed = true;
    synchronized (lock) {
      lock.notify();
    }
  }

}

/**
 * 
 * @author drm
 *
 */
class Stream extends Thread {
  //doesn't have to be volatile since it's only usage is for checking the wait loop,
  //we'll be ok even if it misfires
  boolean proceed;
  Stream next;
  Object lock;
  int counter;
  
  Stream(int counter, Object lock) {
    this.counter = counter;
    this.lock = lock;
  }
  
  @Override
  public void run() {
    //run1();
    run2();
  }
  
  private void run1() {
    if(next != null) {
      String name = Thread.currentThread().getName();
      while (true) {
        synchronized (lock) {
          try {
            Thread.sleep(1000);//just to slow down printing 
          } catch (InterruptedException e1) {
            e1.printStackTrace();
          }
          
          while (!proceed) {
            try {
              lock.wait(3000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          
          System.out.println(name + ": " + counter);
          counter += 2;
          this.proceed = false;
          next.proceed = true;
          lock.notify();
        }
      }
    }
  }
  
  private void run2() {
    if(next != null) {
      String name = Thread.currentThread().getName();
      while (true) {
        synchronized (lock) {
          if(proceed) {
            System.out.println(name + ": " + counter);

            counter += 2;
            this.proceed = false;
            next.proceed = true;
            lock.notify();

            try {
              Thread.sleep(1000);//just to slow down printing 
            } catch (InterruptedException e1) {
              e1.printStackTrace();
            }
          } else {
            try {
              lock.wait(3000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }   
    }   
  }
}