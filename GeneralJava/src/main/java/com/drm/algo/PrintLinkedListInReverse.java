package com.drm.algo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class PrintLinkedListInReverse {
  public static void main(String[] args) {
    //testCustomStack();
    //usingJavaApi();
    //usingCustomApi();
    usingRecursion();
  }
  
  static void usingRecursion() {
    printListInReverseRecursively(buildLinkedList());
  }
  
  static void usingJavaApi() {
    printListInReverse(buildLinkedList());
  }
  
  static <T> void printListInReverseRecursively(LinkedList<T> list) {
    Iterator<T> it = list.iterator();
    if(it.hasNext()) {printRecursively(it, it.next());}
  }
  
  /**
   * doesn't work
   * @param it
   * @param t
   */
  @Deprecated
  static <T> void printRecursively(Iterator<T> it, T t) {
    if(!it.hasNext()) {
      return;
    } else {
      printRecursively(it, it.next());
      System.out.println(t);
      return;
    }
  }
  
  static <T> void printListInReverse(LinkedList<T> list) {
    Stack<T> stack = new Stack<T>();
    for(T t : list) {
      System.out.println("pushed to stack: " + stack.push(t));
    }
    
    while(!stack.isEmpty()) {
      System.out.println("popped from stack: " + stack.pop());
    }
  }
  
  static void usingCustomApi() {
    MyLinkedList<String> list;
    try {
      list = buildLinkedList(MyLinkedList.class);
      list.printList();
      list.printListInReverse();
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
        | InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  static LinkedList<String> buildLinkedList() {
    LinkedList<String> list = new LinkedList<String>();
    list.add("node1");
    list.add("node2");
    list.add("node3");
    list.addFirst("node4");
    
    return list;
  }

  //a generic way of doing it
  static <E> E buildLinkedList(Class<?> clazz) throws IllegalAccessException,
      IllegalArgumentException, InvocationTargetException, InstantiationException {
    E e = (E)clazz.newInstance();
    Method[] methods = clazz.getDeclaredMethods();
    Method add = null, addToStart = null;
    
    for(Method m : methods) {
      if( add == null || addToStart == null) {
        if(m.getName().equalsIgnoreCase("add")) {
          add = m;
        } else if(m.getName().equalsIgnoreCase("addToStart")) {
          addToStart = m;
        }
      } else {
        break;
      }
    }
    
    add.invoke(e, "node1");
    add.invoke(e, "node2");
    add.invoke(e, "node3");
    addToStart.invoke(e, "node4");
    
    return e;
  }
  
  static void testCustomStack() {
    ArrayBackedStack<String> stack = new ArrayBackedStack<String>(3);
    stack.size();
    stack.pop();
    stack.push("hello"); stack.push("my"); stack.push("name"); stack.push("is"); stack.push("dibya");
    stack.size();
    stack.peek();
    stack.pop(); stack.pop(); stack.pop(); stack.pop(); stack.pop();
    stack.size();
    stack.peek();
    stack.size();
  }
  
}


class MyLinkedList<T> {
  Node<T> head;
  int size;
  
  /*MyLinkedList(T t) {
    Node<T> curr = new Node<T>(t);
    this.head = curr;
    System.out.println("created new linked list with head element: " + head);
  }*/
  
  void add(T t) {
    //? add where
    addToEnd(t);
  }
  
  void addToEnd(T t) {
    if (head == null) {
      head = new Node<T>(t);
    } else {
      Node<T> curr = head;
      while ( curr.next != null) {
        curr = curr.next;
      }
      
      curr.next = new Node<T>(t);
      size++;
      System.out.println("added " + t + " to end of linked list");
    }
  }
  
  void addToStart(T t) {
    if (head == null) {
      head = new Node<T>(t);
    } else {
      Node<T> curr = new Node<T>(t);
      curr.next = head;
      this.head = curr;
      size++;
      System.out.println("added " + t + " to start of linked list");
    }
  }
  
  void addTo(int pos, T t) {
    //TODO
  }
  
  int size() {
    return this.size;
  }
  
  void printList() {
    System.out.println(">>printList");
    Node<T> curr = head;
    while ( curr != null) {
      System.out.println(curr);
      curr = curr.next;
    }
    System.out.println("<<");
  }
  
  void printListInReverse() {
    System.out.println(">>printListInReverse");
    ArrayBackedStack<Node<T>> stack = new ArrayBackedStack<>(100); 
    Node<T> curr = head;
    while ( curr != null) {
      stack.push(curr);
      curr = curr.next;
    }
    
    while(stack.peek() != null) {
      System.out.println(stack.pop());
    }
    System.out.println("<<");
  }
  
  class Node<T> {
    Node<T> next;
    T val;
    
    Node(T val) {
      this.val = val;
    }
    
    public String toString() {
      return val.toString();
    }
  }
}



class ArrayBackedStack<T> {
  final T[] t;
  final int size;
  private int curr = -1;
  
  @SuppressWarnings("unchecked")
  ArrayBackedStack(int size) {
    t = (T[])new Object[size];
    this.size = size;
  }
  
  void push(T in) {
    if(curr >= size - 1) {
      System.out.println("stack is full!!");
    } else {
      t[++curr] = in;
      System.out.println("pushed " + in + " to stack");
    }
  }
  
  T pop() {
    if(curr == -1) {
      System.out.println("stack is empty!!");
      return null;
    } else {
      T ret = t[curr];
      t[curr--] = null;
      System.out.println("popped " + ret + " from stack");
      return ret;
    }
  }
  
  int size() {
    System.out.println("size: " + size);
    return size;
  }
  
  T peek() {
    T peeked = curr >= 0 ? t[curr] : null;
    System.out.println("peeking at the stack: " + peeked);
    return peeked;
  }
}

//TODO
class ArrayBackedBlockingStack<T> {
  
}