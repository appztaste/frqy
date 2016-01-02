package com.drm.collections;

import javax.annotation.Resource;

public class Generics2 {

  public static void main(String[] args) throws Exception {
    Class c = Class.forName("A"); // Raw type!
    //Resource a = c.getAnnotation(Resource.class);
    /*
     * Type mismatch compilation error. since you used raw type, the getAnnotation method returns
     * Annotation object.
     */
    
    Class<?> c2 = Class.forName("A"); // Parameterized type!
    Resource a2 = c2.getAnnotation(Resource.class);//returns you type T i.e. Resource. Same as input type
  }
  
  @Resource class A{}
 
}
