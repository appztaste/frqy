package com.drm.contests;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class JavaDeathMatch {
  static int num = 0;
  static Banana b;
  final List<String> names = new ArrayList<String> () {{
    add("drm");
    System.out.println(names);
  }};

  public static void main(String[] args) {
    //findBestFriend();
    //printStaticInt();
    //System.out.println(getOldestPerson(new ArrayList<Person>() {{ add(new Person("drm")); }}));
    //mapCompute();
    //sumTopTen();
    //genericArray();
    //printInsideDoubleBrace();
    //listOfLists();
    //System.out.println(simpleGenericMethod(new ArrayList<String>() {{ add("drm"); }}));
    //printPersonNames();
    //filterUnderThreshold();
    
    System.out.println(b);
  }
  
  static void filterUnderThreshold() {
    System.out.println(filterUnderThreshold(new ArrayList<Integer>(){{ add(5); add(2); add(3);}}, 3));
  }
  
  static List<Integer> filterUnderThreshold(final List<Integer> values, final int threshold) {
    List<Integer> returnValues = new ArrayList<>(values);
    for(int i = 0; i < returnValues.size(); i++) {
      if(returnValues.get(i) >= threshold) {
        returnValues.remove(i);
      }
    }
    
    return returnValues;
  }
  
  
  
  static void printPersonNames() {
    Person p1 = new Person();
    Person p2 = new Student();
    
    p1.name = "drm";
    p2.name = "jules";
    
    System.out.println(p2);
  }
  
  static void listOfLists() {
    System.out.println(getFlattenedLists(new ArrayList<List<String>>() {{ add(new ArrayList<String>(){{ add("drm"); }});}}));
  }
  
  static <T> List<T> getFlattenedLists(final List<List<T>> lists) {
    List<T> flattenedList = new ArrayList<>();
    
    for(List<T> list : lists) {
      for(T el : list) {
        flattenedList.add(el);
      }
    }
    
    return flattenedList;
  }
  
  static <T> List<T> simpleGenericMethod(List<T> l) {
    return l;
  }
  
  static void printInsideDoubleBrace() {
    final List<String> names = new ArrayList<String> () {{
      add("drm");
      //System.out.println(names);
    }};
  }
  
  static void sumTopTen() {
    Map<Integer, Integer> numbers = new TreeMap<>();
    
    int top = 10;
    
    for(int i = 0; i < top; i++) {
      numbers.put(i, i);
    }
    
    System.out.println(sum(numbers.get(top), top));
  }
  
  static int sum(int i, int j) {
    return i + j;
  }
  
  static void genericArray() {
    //Basket<Banana>[] baskets = new Basket<Banana>[]{};//this doesn't
    Basket<Banana>[] baskets = (Basket<Banana>[])new Basket[]{};//this does
  }
  
  static void mapCompute() {
    Map<String, Object> collection = new HashMap<String, Object>();
    //System.out.println(collection.compute("foo", (k,v) -> (v == null ? new ArrayList<Object>() : ((List)v).add("bar"))));
    //System.out.println(collection.compute("foo", (k,v) -> (v == null ? new ArrayList<Object>() : ((List)v).add("ber"))));
    System.out.println(collection);
  }
  
  static Person getOldestPerson(Collection<Person> people) {
   if(people.isEmpty()) return null;
   
   Person oldest = null;
   
   for(Person p : people) {
     if(oldest == null || p.olderThan(oldest)) {
       oldest = p;
     }
   }
   
   return oldest;
  }
  
  static void printStaticInt() {
    System.out.println(strToInt("10"));
    System.out.println(strToInt(num + "1"));
  }
  
  static int strToInt(String snum) {
    num = Integer.parseInt(snum);
    return num;
  }
  
  static void findBestFriend() {
    Person p = new Person("drm");
    Person p2 = new Person("jules");
    p.bestfriend = p2;
    p2.bestfriend = p;
    System.out.println(bestFriend(p));
  }
  
  static Set<Person> bestFriend(Person person) {
    Set<Person> result = new HashSet<Person>();
    
    while(person.bestfriend != null && result.add(person.bestfriend)) {
      person = person.bestfriend;
    }
    
    return result;
  }

}

class Person {
  String name;
  Person bestfriend;
  
  Person() {}
  
  Person(String name) {
    this.name = name;
  }
  
  boolean olderThan(Person p) {
    return true;
  }
  
  public String toString() {
    return name;
  }
}

class Student extends Person {
  String name;
  
  public String toString() {
    return name;
  }
}

class Basket<T> { List<T> content;}

class Banana {}