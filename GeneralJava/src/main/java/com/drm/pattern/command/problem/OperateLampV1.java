package com.drm.pattern.command.problem;

/**
 * Operation on a simple Lamp via a switch (or directly).
 * @author drm
 *
 */
public class OperateLampV1 {

  public static void main(String[] args) {
    Lamp lamp1 = new Lamp("lamp1");
    Switch sw = new Switch(1);
    sw.setLamp(lamp1);
    
    //keep clicking :)
    sw.press();
    sw.press();
    sw.press();
    
    Lamp lamp2 = new Lamp("lamp2");
    sw.setLamp(lamp2);//rewired
    
    sw.press();
    sw.press();
    
    //someone can directly call on/off methods on Lamp. these don't have any side effects though
    lamp2.on();
    lamp2.off();
  }

}

/**
 * A Lamp has a switch. but switch isn't created within the lamp.
 * We can later on wire the switch to let's say a fan. So, a switch should
 * independently know which electric appliance it's associated with. That's why the owner
 * of the relation has to be Switch. You can make it a bidirectional relation - but that's not
 * necessary - we've done it this way here to represent real life scenario.
 * So this is an aggregation relation, not composition.
 * 
 * @author drm
 *
 */
class Lamp {
  private String name;
  private Switch sw; //the association will be done from Switch class as it's the owner.
  private boolean on;//by default when a lamp is off when it's created.
  
  Lamp(String name) {
    this.name = name;
  }

  public void on() {
    if(sw == null) {
      System.out.println("Lamp " + this + " hasn't been wired to a switch yet");
      System.out.println("First wire it to a switch and then press() that");
    } else {
      on = true;
      System.out.println(name + " turned on!");
    }
  }
  
  public void off() {
    if(sw == null) {
      System.out.println("Lamp " + this + " hasn't been wired to a switch yet");
      System.out.println("First wire it to a switch and then press() that");
    } else {
      on = false;
      System.out.println(name + " turned off!");
    }
  }
  
  public String toString() {
    return name;
  }

  /**
   * no setters for name, don't want the name of a lamp to change once it's created
   * @return
   */
  public String getName() {
    return name;
  }
  
  /**
   * @return
   */
  public Switch getSw() {
    return sw;
  }
  
  public void setSw(Switch sw) {
    this.sw = sw;
  }

  /**
   * no setters for changing state. it can only be changed from within publicly exposed on/off methods.
   * @return
   */
  public boolean isOn() {
    return on;
  }
}

/**
 * Switch receives press command which affects the Lamp (receiver).
 * @author drm
 *
 */
class Switch {
  /**
   * switch at which index on the switch-board. this was added to show you that a switch
   * can be rewired to some other appliance later on. the sequence on the board remains same.  
   */
  private int seq;
  private Lamp lamp;
  
  Switch(int seq) {
    this.seq = seq;
  }
  
  //toggle the switch and fire events on lamp
  void press() {
    System.out.println("Switch " + seq + " has been pressed");
    if(lamp == null) {
      System.out.println("Switch " + this + " hasn't been wired yet");
    } else {
      System.out.println("Switch " + this + " is wired to " + lamp);

      if(lamp.isOn()){
        lamp.off();
      } else {
        lamp.on();
      }
    }
  }
  
  public String toString() {
    return "" + seq;
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public Lamp getLamp() {
    return lamp;
  }

  public void setLamp(Lamp lamp) {
    this.lamp = lamp;
    this.lamp.setSw(this);
  }
}