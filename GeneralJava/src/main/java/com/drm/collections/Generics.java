package com.drm.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Summary: The primary goal of generics is type safety. it's called generics since same type at
 * runtime can be used for different representations.
 * 
 * Generic typed class doesn't have to be a collection. but we have chosen to use the word
 * collection here for easy understanding.
 * 
 * Collection objects can be created either without any generic type or with a known/specific
 * generic type. 'known' here means known at compile time. They can't be created with wildcarded
 * (both bounded/unbounded) generic types.
 * 
 * If collections/objects are considered to be memory space on heap with boundaries/restricted area,
 * references act like routes to them. there can be incoming routes and outgoing routes. incoming
 * routes are permitted to add objects to the collection (or perform any action in case of any other
 * type of object). outgoing routes are to get objects from collection.
 * 
 * there can only be one incoming route - a route with known generic type. there can be one or more
 * wildcarded routes which act like outgoing route. a wildcarded route (bounded/unbounded) can't be
 * used to add objects since it's not been declared to the compiler on what type of objects are 
 * there in the collection.
 * 
 * restriction of collections with known types - they can't be inter-assigned 
 * restriction of collections with unknown(wildcard) types - we can't add objects to those and getting
 * objects from them always yield the upperbounded object (Object if none specified).
 * 
 * compiler won't protect you (generate any warnings) if you choose to use raw types - you are on
 * your own. it's like telling compiler I know what I'm doing, give me back all my rights to mess
 * with the code. so, compiler stays back and in case you screw up, you get a good old runtime
 * exception.
 * 
 * it's not possible to provide both upper and lower bounds
 * 
 * @author drm
 *
 */
class Fruit<T> {}

public class Generics {
  public static void main(String[] args) {
    
    List<String> l = new ArrayList<String>();
    l.add("hello");

    // List<Object> l2 = l;
    /*
     * compilation fail, since list of Strings are not list of Objects if this was legal, you could
     * add Objects and return them while people would be expecting Strings. e.g. l2.add(new
     * Object()); String s = l.get(0); this will create runtime error and goal of generics is to
     * prevent runtime error.
     */

    List<? extends Object> l3 = l;
    List<?> l4 = l;// assignment works in case of wildcard types
    /*
     * since we don't know the incoming type, it can be anything but while obtaining it has to be
     * Object, since anything in java is always an Object. Assignment works because the incoming
     * collection already has predefined/known types. so, it's not like you can add anything to
     * that.
     */

    Object o = l4.get(0);// works you can always get Objects
    Object o2 = l3.get(0);

    // l4.add(o);
    /*
     * doesn't compile, since you can't add known types to a generic collection of unknown types. it
     * says no suitable method found for add(Object). wildcard type is a very conservative person.
     * It's like he is saying I don't know what I have, but whatever it is I can give it to you. And
     * you(the client who is reading from the collection) says, don't worry, no matter what you give
     * to me, it's definitely going to be an Object. then the wildcard type says but remember I
     * can't allow anything in since I don't know what I should allow in.
     * 
     * The technical explanation is, since l4 can have anything inside, if adds were permitted, you
     * could add two objects of type A and B who are not related to each other (no polymorphic
     * associations) and it will break the code at runtime since the client will get inconsistent
     * output types.
     * 
     * This extra measure is taken since l4 is still parameterized type (not raw type), so compiler
     * still does strong checking to ensure typesafety and to achieve this it prevents any objects
     * to be added to the collection. you can only add null.
     */



    // l3.add(o);
    /*
     * doesn't work since the l3 reference(route) is still unknown type. it says, I know I can
     * give you - Objects, but I still don't know what I should allow in. Basically the explanation
     * is same as in case of l4.add(o). When you have upper bounds, there can be two classes
     * unrelated to each other polymorphically but lie in the class heirarchy of the upper bound
     * type. e.g. A extends Object, B extends Object. Both are of Object type, but you can't cast
     * objects of type B to A and viceversa. So entries to the collection are still not allowed, not
     * through this route. The reason I say not through this 'route', is because this upperbounded
     * collection can be used for assignments e.g. l3 = l above. (and also can be used as method
     * parameter and you can pass a List of Strings say). so there will be another reference where
     * the type is known. You can use that route to add elements.
     * 
     * This also means there can only be one incoming route for any generic typed collection and
     * many outgoing routes(wildcarded). if any other known generic typed incoming route was added
     * it would lead to incosistency in output types and hence compiler prevents it.
     * 
     * Now ? extends Object is not so helpful since everything anyways is already an Object. but you
     * can use other types as upperbound to make more sense of this feature.
     */

    // List<? extends String> l5 = new ArrayList<? extends String>();
    //List<?> l5 = new ArrayList<?>();
    /*
     * above doesn't work for similar reasons, you can't create stuff with unknown type or add
     * objects to unknown type generics. you can only assign them to existing collections with known
     * generic types. So, you can have a reference of unknown types (bounded or unbounded), but not
     * objects.
     * 
     * This might be getting clear now that with wildcards, you can specify upperbounds, lowerbounds
     * or both(?), but it still won't allow anything in as long as the cardinality of types is more
     * than one (i.e. it's possible to obtain more than one type of object).
     */

    List<? extends String> l5 = new ArrayList<String>();
    // l5.add("hello");
    /*
     * Still can't add. Wherever you see wildcard, remember you can't put/add anything in/to the
     * collection. You can only retrieve. And the type of the retrieved object is governed by the
     * upperbound (or Object if unbounded). So, you might ask what is the use of lowerbound then?
     */

    // String s = l5.get(0);
    /*
     * this compiles, but will throw runtime index out of bounds exception since we can't now add
     * stuff to the l5 collection - EVER!! because this collection we just created can no longer be
     * pointed to by any reference of known generic type. i.e. no incoming routes can be added. the
     * single route attached here (List<? extends String> l5) is an outgoing route.
     * 
     * we can definitely reassign it to an existing collection of known generic type and get stuff
     * from that through this outgoing route.
     */

    l5 = l;
    String s = l5.get(0);// this one works at runtime

    /*
     * So, question comes - can we do double brace initialization and add stuff to the newly built
     * collection
     */
    List<? extends String> l6 = new ArrayList<String>() {
      {
        add("String");
      }
    };
    s = l6.get(0);

    /*
     * due to this restriction on adding objects through them, wildcarded types are more useful as
     * method parameters. similarly parameters with Object generic type are not useful since you can
     * only pass a collection of objects, a collection of strings won't do.
     * 
     * now due to these restriction of known and unknown types as method parameters, it's best to
     * use generic methods. generic methods instead of them broadcasting what types they take in,
     * they let the client choose what types to deal in.
     */

    // l = l6;
    /*
     * fails can't assign solid/known type inbound routes to the object now. what it means, once you
     * have an unknown route attached to an object, you can't attach a known route otherwise
     * you will be able to send in objects of that type and you can attach more such routes and send
     * in objects of different type which will blow up at runtime coz there is no guarantee anymore
     * on what type of objects the collection holds.
     */

    List l7 = l6;
    /*
     * this works, since you are asking compiler to back off and let you do what you want to and
     * compiler assumes you know what you want to do, you know your stuff and you are ready to take
     * the risk of not using generics. So, when you use raw type, you are on your own. no compiler
     * checking (errors) is done - you are only given a warning that you are using a raw type (just
     * in case that's a typo and not your intention).
     * 
     * technically speaking, how the compiler backs off is by removing all generic type parameters
     * from the object being referred by l7. That means it behaves like List l7 = new ArrayList();
     */

    l7.add("drm");
    /**
     * but this also opens up to loophole that you can add anything to it, since this is a raw type
     * route, it's like a freeway route. and then you might get a runtime exception if you try and
     * convert an Integer to a String.
     */

    // l7.add(1);//your future is doomed
    // String s2 = l6.get(2);

    // l7.add(1.2);
    // String s2 = l6.get(2);

    // l7.add(new Fruit());
    // String s2 = l6.get(2);
    /*
     * compiler doesn't give you any warning, since the ArrayList is supposed to be of type String.
     * But you added a freeway route and can really mess up things. Above three additions will give
     * runtimeexception (class cast exception)
     */

    // System.out.println(l7 instanceof List<String>);//illegel
    System.out.println(l7 instanceof List<?>);
    System.out.println(l7 instanceof List);

    // List<String>[] lsa = new List<String>[10];
    /*
     * compilation fail. arrays with generic types are not allowed in java. reason: arrays are objects.
     * (left operand is called array type. right is array object.)
     * so, you can point an Object[] to the array object and then add List of anything (Integers e.g.)
     * to the array, this will blow up at runtime when you get from the array expecting a List of Strings.
     * hence the above syntax is not allowed in java.
     */

    //you can instead use the unknown type
    List<?>[] lsa = new List<?>[10];
    
    /*
     * you can still do the above sneaking in of Integer lists to the array. but since now the array
     * contains list of unknown types, you are no more expecting a certain type of elements coming out
     * of the lists in the array. that also means you should use caution when putting and getting elements.
     */
    
    Object[] o3 = lsa;
    o3[1] = new ArrayList<Integer>() {
      {
        add(1);
      }
    };
    
    /*
     * this blows up at runtime. explicit cast is needed as we were using list of unknown types in array.
     * but it throws classcast exception
     */
    String s3 = (String) lsa[1].get(0);
    
    /*
     * but since this is an array of list of unknown types, you can directly point the array elements to
     * lists of integer type.  
     */
    lsa[1] = new ArrayList<Integer>() {
      {
        add(1);
      }
    };

    /*
     * you can use array types with generic type inside a method
     * via type-casting, but this is a sort of cheating since you already know the type of the array
     * and it's not generic in true sense.
     */
    System.out.println(array(new String[]{"hello"}, new Object()));
    
    Set<?> unknownSet = new HashSet<String>();
    //addToSet(unknownSet, "abc"); // illegal
    /*
     * It makes no difference that the actual set being passed is a set of strings; what matters is
     * that the expression(reference/route) being passed as an argument is a set of an unknown type, which cannot be
     * guaranteed to be a set of strings, or of any type in particular.
     * 
     * it's because the method formal type is inferred from the generic type of the reference being
     * passed. since the reference's type is unknown, above doesn't work. it would have worked had
     * there been only the generic collection parameter(first arg), since the first arg's type is
     * yet to be inferred. This is called wildcard capture e.g. -
     */
    addToSet(unknownSet);//works, since T is not known yet
    
    /* 
     * it won't work, if the type is already inferred. 
     * 
     */
    //addToSet2(unknownSet);
    /*
     * doesn't work because you can't add known type routes as they will act like inbound routes.
     * technically speaking if it was allowed you would be able to add known type objects to the collection
     * which are not interrelated even though they inherit from Object.
     */
  }
  
  static <T> T[] array(String[] s, T t) {
    T[] t1 = (T[])s;
    return t1;
  }

  /** Add an element t to a Set s */
  static <T> void addToSet(Set<T> s, T t) {}
  
  static <T> void addToSet(Set<T> s) {}
  
  static <T> void addToSet2(Set<String> s) {}

  <T> T[] makeArray(T t) {
    //return new T[100]; // error
    /*
     * Since type variables don’t exist at run time, there is no way to determine what the actual
     * array type would be. The way to work around these kinds of limitations is to use class
     * literals as run time type tokens, as described in section 8
     */
    
    return null;
  }

  /**
   * generic method example. note that Collection<?> and Collection<Object> are not useful here
   * 
   * @param a
   * @param c
   */
  static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
    for (T o : a) {
      c.add(o); // correct
    }
  }

  /**
   * this method works on types that are children of T
   * 
   * @param dest
   * @param src
   */
  static <T> void copy(List<T> dest, List<? extends T> src) {}

}