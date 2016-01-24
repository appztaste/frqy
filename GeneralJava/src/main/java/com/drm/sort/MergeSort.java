package com.drm.sort;

public class MergeSort {
  static int[] a = new int[] {-1, -5, 3, Integer.MAX_VALUE, 7, 12, 9, Integer.MIN_VALUE};
  static int[] merged = new int[a.length];

  public static void main(String[] args) {
    int lo = 0, hi = a.length;
    sort(a, lo, hi);
  }

  public static void sort(int[] a, int lo, int hi) {
    if (lo < hi) {
      int mid = (lo + hi) >> 1;
      sort(a, lo, mid);
      sort(a, mid + 1, hi);
      merge(a, lo, mid, hi);
    }
  }

  public static void merge(int[] a, int lo, int mid, int hi) {
    int l = 0, r = mid + 1, i = 0;

    while (l <= mid && r <= hi) {
      if (a[l] < a[r]) {
        merged[i] = a[l];
        l++;
      } else if (a[r] < a[l]) {
        merged[i] = a[r];
        r++;
      } else {
        merged[i] = a[l];
        merged[i + 1] = a[r];
        l++;
        r++;
      }
      i++;
    }

    while (l <= mid) {
      merged[i] = a[l];
      i++;
      l++;
    }

    while (r <= hi) {
      merged[i] = a[r];
      i++;
      r++;
    }

  }
}
