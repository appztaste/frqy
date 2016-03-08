package com.drm.algo;

import com.drm.ds.Queue;
import com.drm.ds.SimpleQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by drm on 08-03-2016.
 * you are positioned at 0 on a horizontal axis ranging from -inf to +inf.
 * at ith step, you can jump by i positions forward or backward.
 * given a number, print out the shortest path to reach there.
 */
public class ReachabilityWithIncrementalJump {
    static Node result;
    static int dest;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dest = sc.nextInt();

        try {
            process();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    static void process() {
        Node origin = new Node(0, 1, null);
        Queue<Node> queue = new SimpleQueue<>();
        queue.add(origin);
        boolean res = findMatch(queue);

        if(res) {
            printPath(result);
        }
    }

    static boolean findMatch(Queue<Node> queue) {
        boolean res = false;
        Node node = queue.remove();

        if(node.data == dest) {
            res = true;
            result = node;
        } else if(!beyondLimit(node)){
            Node left = new Node(node.data - node.step, node.step + 1, node);
            Node right = new Node(node.data + node.step, node.step + 1, node);

            result = left.data == dest ? left : right.data == dest ? right : null;

            if(result != null) {
                return true;
            } else {
                queue.add(left);
                queue.add(right);
            }
        } else {
          return false;
        }

        return res || findMatch(queue);
    }

    static boolean beyondLimit(Node node) {
        return node.data < Integer.MIN_VALUE + node.step ||
                node.data > Integer.MAX_VALUE - node.step ||
                node.step == Integer.MAX_VALUE;
    }

    static void printPath(Node node) {
        Stack<Integer> stack = new Stack<>();
        while(node != null) {
            stack.push(node.data);
            node = node.parent;
        }

        while(!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    static class Node {
        final int data;
        final int step;//increment to reach next coordinate
        final Node parent;

        Node(int data, int step, Node parent) {
            this.data = data;
            this.step = step;
            this.parent = parent;
        }

        public String toString() {
            return Integer.toString(data);
        }
    }
}
