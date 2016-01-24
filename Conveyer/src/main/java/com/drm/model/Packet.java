package com.drm.model;

import java.util.concurrent.atomic.AtomicLong;

public class Packet {
  private final AtomicLong packetIdCounter = new AtomicLong();
  private long packetId;
  private Barcode barcode;
  private double weight;
  private int armId;
  
  public Packet() {
    this.packetId = packetIdCounter.incrementAndGet();
  }

  public long getPacketId() {
    return packetId;
  }

  public void setPacketId(long packetId) {
    this.packetId = packetId;
  }

  public Barcode getBarcode() {
    return barcode;
  }

  public void setBarcode(Barcode barcode) {
    this.barcode = barcode;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getArmId() {
    return armId;
  }

  public void setArmId(int armId) {
    this.armId = armId;
  }


}
