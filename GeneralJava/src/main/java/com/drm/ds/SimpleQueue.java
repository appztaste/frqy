package com.drm.ds;

import java.util.LinkedList;

/**
 * Created by drm on 09-03-2016.
 */
public class SimpleQueue<T> implements Queue<T> {
    private final LinkedList<T> queue;

    public SimpleQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void add(T t) {
        queue.addLast(t);
    }

    @Override
    public T remove() {
        T t = queue.removeFirst();
        return t;
    }

    @Override
    public T poll() {
        return queue.getFirst();
    }

    @Override
    public void offer(T t) {

    }

    @Override
    public T max() {
        return null;
    }

    @Override
    public T min() {
        return null;
    }
}
