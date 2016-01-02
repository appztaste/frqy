package com.drm.hr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    try {
      int n = s.nextInt();
      int q = s.nextInt();
      int lastans = 0;
      List[] seqs = new List[n];
      
      for(int i = 0; i < q; i++) {
        int input = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int seq = (x ^ lastans) % n;
        
        List list = seqs[seq];
        if(list == null) {
          list = new ArrayList();
          seqs[seq] = list;
        }
        
        if(input == 1) {
          list.add(y);
        } else if(input == 2) {
          int size = list.size();
          lastans = (int)list.get(y % size);
          System.out.println(lastans);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      s.close();
    }
    
  }

}
