package com.drm.ds;

/**
 * TODO
 * add two implementations using array and linked list
 * @author drm
 *
 */
public interface Stack<T> {
  void push(T t);
  T pop();
  T peek();
  T max();
  T min();
}
