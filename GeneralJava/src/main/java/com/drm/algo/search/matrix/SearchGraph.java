package com.drm.algo.search.matrix;

import java.util.Arrays;

public abstract class SearchGraph {
  protected int[] array;

  SearchGraph(int max) {
    array = new int[max];

    for(int i = 0; i < max; i++) {
      array[i] = i;
    }
    
    printArray();
  }
  public int getLength() {
    return array == null ? 0 : array.length;
  }

  public void printArray() {
    System.out.println(Arrays.toString(array));
  }
  
  abstract protected void connect(int node1, int node2);
  abstract protected boolean isConnected(int node1, int node2);

}
