package com.drm.ds;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author drm
 *
 */
public class Graph {
  private Map<Vertex, List<Vertex>> adj;
  private List<Edge> edges;
  
  public Graph(String filename) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(filename));
    
    if(lines.size() < 1) {
      throw new RuntimeException("Invalid input file");
    }
    
    adj = new HashMap<Vertex, List<Vertex>>();
    edges = new ArrayList<Edge>();
    
    for(String line : lines) {
      String[] input = line.split(" ");
      String from = input[0];
      String to = input[1];
      
      addEdge(new Vertex(Integer.parseInt(from)), new Vertex(Integer.parseInt(to)));
    }
  }
  
  class Vertex {
    int index;
    boolean visited;
    Vertex visitedFrom;
    
    Vertex(int i) {
      index = i;
    }
    
    public String toString() {
      return ""+index;
    }
  }
  
  class Edge {
    Direction dir;//TODO should it be in Graph class?
    Vertex from;
    Vertex to;
    
    Edge(Vertex from, Vertex to) {
      this.from = from;
      this.to = to;
    }
    
    public String toString() {
      return from + " - " + to;
    }
  }
  
  enum Direction {
    DIRECTED, UNDIRECTED
  }
  
  public List<Vertex> vertices() {
    List<Vertex> vertices = new ArrayList<Vertex>();
    vertices.addAll(adj.keySet());
    return vertices;
  }
  
  public List<Edge> edges() {
    return edges;
  }
  
  public String toString() {
    return "";
  }
  
  public List<Vertex> adj(Vertex v) {
    List<Vertex> list = adj.get(v);
    if(list == null) {
      list = new ArrayList<Vertex>();
      adj.put(v, list);
    }
    
    return list;
  }
  
  public void addEdge(Vertex v, Vertex w) {
    adj(v).add(w);
    adj(w).add(v);
    edges.add(new Edge(v, w));
  }
  
  public int degree(Vertex v) {
    return adj(v).size();
  }
  
  public int maxDegree() {
    int max = 0;
    
    for(Vertex v : vertices()) {
      if(degree(v) > max) max = degree(v);
    }
    
    return max;
  }
  
  public int avgDegree() {
    return 2 * edges().size() / vertices().size();
  }
  
  public int selfLoopsNum() {
    int cnt = 0;
    
    for(Vertex v : vertices()) {
      for(Vertex w : adj(v)) {
        if(v.index == w.index) cnt++;
      }
    }
    
    return cnt / 2;
  }
  
  public boolean pathExists(int s, int d) {
    Vertex f = new Vertex(s), t = new Vertex(d), c = t;
    boolean found = false;
    
    while(c.visitedFrom != null) {
      if(c.visitedFrom == f) {
        found = true;
        break;
      }
    }
    
    return found;
  }
  
  public void dfs() {
    Vertex v = vertices().get(0);
    dfs(v);
  }
  
  public void dfs(Vertex v) {
    v.visited = true;

    for(Vertex w : adj(v)) {
      if(!w.visited) {
        w.visitedFrom = v;
        dfs(w);
      }
    }
  }
  
  public List<Vertex> findConnectedVertices(int v) {
    return null;
  }
  
  public List<Vertex> findPath(int from, int to) {
    Vertex f = new Vertex(from), t = new Vertex(to), c = t;
    List<Vertex> path = new ArrayList<Vertex>();
    
    dfs();
    
    while(c.visitedFrom != null && c.visitedFrom != f) {
      path.add(c.visitedFrom);
    }
    
    return c.visitedFrom == f ? path : null;
  }
}
