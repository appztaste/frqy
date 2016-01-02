package com.drm.sort;

public class Sort {
  static void swap(int[] a, int i, int j) {
    a[i] = a[i] - a[j];
    a[j] = a[j] + a[i];
    a[i] = a[j] - a[i];
  }
}
