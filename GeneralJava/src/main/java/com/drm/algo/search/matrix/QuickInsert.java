package com.drm.algo.search.matrix;


public class QuickInsert extends SearchGraph {
  
  public QuickInsert(int max) {
    super(max);
  }
  
  public int root(int i) {
    while(array[i] != i) i = root(array[i]);
    
    return i;
  }

  @Override
  protected void connect(int node1, int node2) {
    array[node1] = root(node2);
    printArray();
  }

  @Override
  protected boolean isConnected(int node1, int node2) {
    return root(node1) == root(node2);
  }
  
}
