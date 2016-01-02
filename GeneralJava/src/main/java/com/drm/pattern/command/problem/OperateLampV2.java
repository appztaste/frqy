package com.drm.pattern.command.problem;

public class OperateLampV2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class Switch {
  Lamp lamp;
  
  /**
   * Switch is associated to lamp via aggregation. usually a lamp would have a switch.
   * but that way you will need the lamp object inorder to 
   * @param lamp
   */
  Switch(Lamp lamp) {
    this.lamp = lamp; 
  }
}

class Lamp {
  
}