package com.drm.algo.search.matrix;


public class QuickFind extends SearchGraph {
  public QuickFind(int max) {
    super(max);
  }

  public void connect(int node1, int node2) {
    int oldValue = array[node1];
    for (int i = 0; i < array.length; i++) {
      if(array[i] == oldValue) {
        array[i] = array[node2];
      }
    }
    printArray();
  }

  public boolean isConnected(int node1, int node2) {
    return array[node1] == array[node2];
  }

}
