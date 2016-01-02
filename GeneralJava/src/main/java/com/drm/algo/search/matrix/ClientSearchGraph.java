package com.drm.algo.search.matrix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ClientSearchGraph {
	public static void main(String[] args) {
		ClientSearchGraph finder = new ClientSearchGraph();
		//finder.find(QuickFind.class);
		//finder.find(QuickInsert.class);
		finder.find(QuickInsertWeighted.class);
	}
	
	public void find(Class<?> clazz) {
	  Scanner scanner = new Scanner(System.in);
      
      try {
        System.out.println("Enter max number to be added: ");
        int max = scanner.nextInt();
        SearchGraph finder = createFinder(clazz, max);
        
        System.out.println("Enter no. of entries to be added: ");
        int entries = scanner.nextInt();
        
        System.out.println("Enter node1 and node2 separated by space now: ");
        while (entries > 0) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            
            if(node1 >= max || node2 >= max) {
                System.out.println("Enter numbers less than max permitted");
            } else {
                finder.connect(node1, node2);
                entries--;  
            }
        }
        
        System.out.println("All entries have been added");
        System.out.println("Enter number of questions to be asked: ");
        
        int questions = scanner.nextInt();
        
        System.out.println("Enter questions now: ");
        
        while(questions > 0) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            
            System.out.println("are " + node1 + " and " + node2 + " connected? " + finder.isConnected(node1, node2));
            questions--;
        }
        
        System.out.println("All questions have been aswered");
        
        finder.printArray();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        scanner.close();
      }
      
	}
	
	private SearchGraph createFinder(Class<?> clazz, int max) throws InstantiationException, 
	  IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, 
	  IllegalArgumentException, InvocationTargetException {
	  
	  Constructor<?> cons = clazz.getConstructors()[0];
	  return (SearchGraph)cons.newInstance(max);
	}
}
