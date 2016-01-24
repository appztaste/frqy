package com.drm.conveyer;

final public class Scanner implements Runnable {
  private static final Scanner INSTANCE = new Scanner();
  
  private Scanner() {}
  
  public void scan() {
    
  }

  public void run() {
    // TODO Auto-generated method stub
    
  }
  
  public static final Scanner getInstance() {
    return INSTANCE;
  }
}
