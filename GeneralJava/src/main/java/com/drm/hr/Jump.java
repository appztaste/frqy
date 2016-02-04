package com.drm.hr;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Jump {
  static int[] track;
  static int[] lookup;
  static int n, m;
  static int tc;
  
  private static boolean reachable() {
    if(track[0] != 0) return false;
    
    boolean reachable = true;
    if(m == 0) {
      for(int i = 0; i < n; i++) {
        reachable = reachable && track[i] == 0;
      }
      
      return reachable;
    }
    
    prepare();
    
    reachable = false;
    for(int i = 1; i <= m && !reachable; i++) {
      reachable = reachable || (lookup[n - i] == 0);
    }
    
    return reachable;
  }
  
  static boolean fill(int i) {
    boolean res = false;
    if(inRange(i) && lookup[i] == -1 && track[i] == 0) {
        lookup[i] = 0;
        fill(i - 1);
        fill(i + 1);
        fill(i + m);
        res = true;
    }
    
    return res;
  }
  
  static void prepare() {
    fillLookup();

    boolean res = true;
    for(int i = 0; i < n; i += m) {
      res = res && fill(i);
    }
  }
  
  static boolean inRange(int i) {
    return i >= 0 && i < n;
  }
  
  private static void fillLookup() {
    lookup = new int[n];
    for(int i = 0; i < n; i++) {
      lookup[i] = -1;
    }
  }

  public static void main(String[] args) {
    try {
      readInput("src/main/resources/input.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    //readInput(System.in);
    //manualInput();
  }
  
  
  private static void manualInput() {
    n = 33; 
    m = 18;
    track = getIntArrayFromStr("0 0 1 0 0 1 0 1 0 1");
    System.out.println(reachable() ? "YES" : "NO");
  }

  static void readInput(InputStream in) {
    Scanner sc = new Scanner(in);
    try {
      tc = sc.nextInt();
      
      for(int i = 0; i < tc; i++) {
        n = sc.nextInt();
        m = sc.nextInt();
        track = new int[n];

        for(int j = 0; j < n; j++) {
          track[j] = sc.nextInt();
        }
        System.out.println(reachable() ? "YES" : "NO");
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } finally {
      sc.close();
    }
  }
  
  static void readInput(String file) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(file));
    tc = Integer.parseInt(lines.get(0));
    
    for(int i = 1; i < lines.size(); i++) {
      String[] ints = lines.get(i).split(" ");
      n = Integer.parseInt(ints[0]);
      m = Integer.parseInt(ints[1]);
      
      track = getIntArrayFromStr(lines.get(++i));
      try {
        System.out.println(reachable() ? "YES" : "NO");
      } catch (Exception e) {
        System.out.println("exception for line: " + i);
        e.printStackTrace();
      }
    }
    
  }

  private static int[] getIntArrayFromStr(String string) {
    int[] arr = null;
    
    String[] ints = string.split(" ");
    arr = new int[ints.length];
    
    for(int i = 0; i < ints.length; i++) {
      arr[i] = Integer.parseInt(ints[i]);
    }
    
    return arr;
  }
}
