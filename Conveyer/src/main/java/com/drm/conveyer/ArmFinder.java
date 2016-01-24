package com.drm.conveyer;

final public class ArmFinder implements Runnable {
  private static final ArmFinder INSTANCE = new ArmFinder();
  
  private ArmFinder() {}
  
  public static final ArmFinder getInstance() {
    return INSTANCE;
  }
  
  public void run() {
    // TODO Auto-generated method stub
    
  }

}
