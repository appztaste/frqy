package com.drm.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

final public class ThreadPool extends Thread {
  final BlockingQueue<Worker> workers;
  
  ThreadPool(int size) {
    workers = new ArrayBlockingQueue<Worker>(size);
  }
  
  public void run() {
    Worker worker;
    while((worker = workers.poll()) != null) {
      worker.run();
    }
  }
}

class Worker implements Runnable {

  @Override
  public void run() {
    
  }
  
}

