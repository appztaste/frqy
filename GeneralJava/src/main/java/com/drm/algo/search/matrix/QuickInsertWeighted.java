package com.drm.algo.search.matrix;


public class QuickInsertWeighted extends SearchGraph {
  
  int[] weight;
  
  public QuickInsertWeighted(int max) {
    super(max);
    weight = new int[max];
    
    for(int i = 0; i < max; i++) {
      weight[i] = 0;
    }
  }
  
  public int root(int i) {
    while(array[i] != i) {
      array[i] = array[array[i]];
      i = root(array[i]);
    }
    
    return i;
  }

  @Override
  protected void connect(int node1, int node2) {
    int i = root(node1);
    int j = root(node2);
    if(i == j) return;
    
    if(weight[i] < weight[j]) {
      array[i] = j;
      weight[j] += weight[i];
    } else {
      array[j] = i;
      weight[i] += weight[j];
    }
    printArray();
  }

  @Override
  protected boolean isConnected(int node1, int node2) {
    return root(node1) == root(node2);
  }
  
}
