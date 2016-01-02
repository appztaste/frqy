package com.drm.ds;

public class PriorityQueue<E extends Comparable<E>> {
  private E[] heap;
  private int size;
  
  public PriorityQueue(int capacity) {
    heap = (E[]) (new Comparable[capacity + 1]);
    size = capacity + 1;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public void insert(E e) {
    heap[size] = e;
    swim(size);
  }
  
  public E getMax() {
    return heap[0];
  }
  
  public E delMax() {
    E max = heap[0];
    heap[0] = heap[size - 1];
    heap[size - 1] = null;
    sink(0);
    return max;
  }
  
  private void swim(int x) {
    while(x/2 >= 1 && !less(x, x/2)) {
      swap(x, x/2);
      x = x / 2;
    }
  }
  
  private void sink(int x) {
    while ((2 * x + 1)<= size) {
      int c = 2 * x;
      
      if ((c + 1) <= size && less(c, c + 1))
        c++;
      
      if (less(x, c)) {
        swap(x, c);
      } else {
        break;
      }
      
      x = c;
    }
  }
  
  private boolean less(int p, int q) {
    return heap[p].compareTo(heap[q]) < 0;
  }
  
  private void swap(int p, int q) {
    E e = heap[p];
    heap[p] = heap[q];
    heap[q] = e;
  }
}
