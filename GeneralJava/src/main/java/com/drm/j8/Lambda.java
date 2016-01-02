package com.drm.j8;

import com.drm.models.Greeter;
import com.drm.models.Speaker;


public class Lambda {
	public static void main(String[] args) throws Exception {
		Speaker s = () -> {
			System.out.println("hello world!");
		};
		
		s.speak();
		
		Greeter g = greeting -> {
			if(greeting == null || greeting.split(" ").length < 2) {
				throw new Exception("Improper greeting!");
			}
			
			System.out.println(greeting);
		};
		
		g.greet("Hola Mr!");
	}
}
