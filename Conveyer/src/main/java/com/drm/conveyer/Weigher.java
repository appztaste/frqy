package com.drm.conveyer;

final public class Weigher implements Runnable {
  private static final Weigher INSTANCE = new Weigher();
  
  private Weigher() {}

  public void run() {
    // TODO Auto-generated method stub
    
  }
  
  public static final Weigher getInstance() {
    return INSTANCE;
  }

}
