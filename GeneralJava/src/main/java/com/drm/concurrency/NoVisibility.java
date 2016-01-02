package com.drm.concurrency;

/**
 * This program goes into infinite loop always. since the compiler will reorder this: while(true) {
 * if(ready) {}}
 * 
 * to if(ready){ while(true) {}}
 * 
 * as the latter is more efficient since we won't need to go in a while loop if ready is already
 * set.
 * 
 * This reordering optimization can be prevented if you just added some statements between while and
 * if.
 * 
 * @author drm
 *
 */
public class NoVisibility {
  private static boolean ready;

  public static void main(String[] args) throws InterruptedException {
    
    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          if (ready) {
            System.out.println("Finished");
            break;
          }
        }
      }
    }).start();

    Thread.sleep(1000);
    System.out.println("Changing");
    ready = true;
    
  }
}
