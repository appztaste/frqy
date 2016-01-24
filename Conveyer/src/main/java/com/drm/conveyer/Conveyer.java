package com.drm.conveyer;

/**
 * Created by drm on 24-01-2016.
 */
final public class Conveyer implements Runnable {
  private static final Conveyer INSTANCE = new Conveyer();
  
  private Conveyer() {}
  
  public static final Conveyer getInstance() {
    return INSTANCE;
  }

  public void run() {
    // TODO Auto-generated method stub
    
  }
}
