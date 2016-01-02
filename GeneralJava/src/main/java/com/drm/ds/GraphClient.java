package com.drm.ds;

import java.util.Scanner;

public class GraphClient {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      System.out.println("Loading graph from src/com/drm/ds/graph.txt");
      Graph g = new Graph("src/main/java/com/drm/ds/graph.txt");
      
      usage();
      int choice = -1;
      
      while(choice != 0) {
        choice = sc.nextInt();

        switch (choice) {
          case 1:
            System.out.println("Which vertex: ");
            int v = sc.nextInt();
            System.out.println(g.findConnectedVertices(v));
            break;
          case 2:
            System.out.println("Enter vertex from and to separated by space: ");
            int from = sc.nextInt();
            int to = sc.nextInt();
            System.out.println(g.findPath(from, to));
            break;
          case 3:
            System.out.println(g.edges());
            break;
          case 9:
            usage();
            break;
          case 0:
            System.out.println("Quitting");
            break;
          default:
            System.out.println("Invalid choice");
            break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sc.close();
    }
  }
  
  static void usage() {
    System.out.println("1. Find all vertices connected to a source vertex");
    System.out.println("2. Find a path between two vertices");
    System.out.println("3. Print edges");
    System.out.println("9. Usage");
    System.out.println("0. Quit");
  }
}
