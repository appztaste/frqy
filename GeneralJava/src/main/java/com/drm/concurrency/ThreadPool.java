package com.drm.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author drm
 *
 */
final public class ThreadPool extends Thread {
  final BlockingQueue<Task> tasks;
  final int activeThreadCount;
  
  public ThreadPool(int size) {
    tasks = new ArrayBlockingQueue<Task>(size);
    activeThreadCount = size;
  }
  
  public void run() {
    System.out.println(Thread.currentThread().getName() + " starting active threads");
    for(int i = 0; i < activeThreadCount; i++) {
      new Thread(new Worker(tasks)).start();
    }
    System.out.println(Thread.currentThread().getName() + " threads started");
  }
  
  public void execute(Task task) {
    tasks.add(task);
    System.out.println(Thread.currentThread().getName() + " tasks added, size: " + tasks.size());
  }
  
  public void execute(List<Task> tasks) {
    tasks.addAll(tasks);
    System.out.println(Thread.currentThread().getName() + " tasks added, size: " + tasks.size());
  }
  
  public static void main(String[] args) {
    ThreadPool pool = new ThreadPool(2);
    pool.start();
    
    List<Task> tasks = new ArrayList<Task>();
    tasks.add(new Task("t1", 2000));
    tasks.add(new Task("t2", 3000));
    tasks.add(new Task("t3", 1500));
    tasks.add(new Task("t4", 500));
    tasks.add(new Task("t5", 2500));
    tasks.add(new Task("t6", 1000));
    tasks.add(new Task("t7", 1300));
    tasks.add(new Task("t8", 2800));
    tasks.add(new Task("t9", 3300));
    tasks.add(new Task("t10", 800));
    
    pool.execute(tasks);//there are 5 active threads in the pool and ten tasks each taking diff time to complete
  }
}

class Worker implements Runnable {
  
  final BlockingQueue<Task> tasks;
  
  public Worker(BlockingQueue<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " started");
    Task task;
    while(true) {
      task = tasks.poll();
      if(task != null) {
        System.out.println(Thread.currentThread().getName() + " Running task " + task.name);
        task.run();
      } else {
        System.out.println(Thread.currentThread().getName() + " Waiting for a task to arrive");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }
  
}

class Task implements Runnable {
  final String name;
  final long timeInMillis;//time taken by a task
  
  public Task(String name, long timeInMillis) {
    this.name = name;
    this.timeInMillis = timeInMillis;
  }

  @Override
  public void run() {
    System.out.println(">> " + Thread.currentThread().getName() + name);
    
    try {
      Thread.sleep(timeInMillis);//each task takes timeInMillis milli sec to complete
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println("<< " + Thread.currentThread().getName() + name);
  }
  
}

