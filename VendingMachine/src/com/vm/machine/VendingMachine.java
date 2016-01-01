package com.vm.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Vending Machine API which will expose list of products, price of each product
 * and a facility to purchase items.
 * 
 * TODO Expose interface instead of class as API
 * TODO handle multithreading
 * @author drm
 *
 */
public class VendingMachine {
  private Map<ProductType, List<Product>> catalog;
  
  public VendingMachine() {}
  
  public VendingMachine(Map<ProductType, List<Product>> catalog) {
    this.catalog = catalog;
  }
  
  /**
   * TODO reduce product count
   * @param product
   * @param input
   * @return
   */
  public Output purchaseProduct(Product product, Map<Integer, Integer> inputCoins) {
    Output o = new Output();
    
    Product p = fetchProductIfExists(product);
    int input = sum(inputCoins);
    int diff = input - product.getPrice();
    
    if(p != null && diff >= 0) {
      //set p, remove from list, return change
      o.setProduct(p);
      
      if(diff > 0) {
        o.setChange(calculateChange(diff));
      }
    } else {
      o.setChange(inputCoins);
    }
    
    return o;
  }
  
  public Output purchaseProduct(long productId, Map<Integer, Integer> inputCoins) {
    //TODO
    return null;
  }
  
  private Product fetchProductIfExists(Product product) {
    List<Product> items = catalog.get(product.getProductType());
    
    if(items.size() > 0) {
      return items.remove(0);
    } else {
      return null;
    }
  }
  
  /**
   * Min no. of coins
   * @param diff
   * @return
   */
  private Map<Integer, Integer> calculateChange(int diff) {
    Map<Integer, Integer> change = new HashMap<Integer, Integer>();
    
    //int count = 0;
    int hundreds = diff / 100;
    int left = diff % 100;
    //count += hundreds;
    
    int fifties = left / 50;
    left = left % 50;
    //count += fifties;
    
    int fourties = left / 40;
    left = left % 40;
    
    int thirties = left / 30;
    left = left % 30;
    
    int tens = left / 10;
    left = left % 10;
    
    int fives = left / 5;
    left = left % 5;
    
    int fours = left / 4;
    left = left % 4;
    
    int threes = left / 3;
    left = left % 3;
    
    int ones = left;
    
    change.put(100, hundreds);
    change.put(50, fifties);
    change.put(40, fourties);
    change.put(30, thirties);
    change.put(10, tens);
    change.put(5, fives);
    change.put(4, fours);
    change.put(3, threes);
    change.put(1, ones);
    
    return change;
  }
  
  private int sum(Map<Integer, Integer> inputCoins) {
    int sum = 0;
    
    for(Integer i : inputCoins.keySet()) {
      sum += inputCoins.get(i);
    }
    
    return sum;
  }

  public double queryPriceOfAProduct(Product product) {
    //TODO
    return 0;
  }
  
  public void addProducts(List<Product> products, ProductType productType) {
    for(Product p : products) {
      if(p.getProductType().equals(productType)) {
        List<Product> currProducts = catalog.get(productType);
        if(currProducts == null) currProducts = new ArrayList<Product>();
        currProducts.add(p);
      } else {
        throw new IllegalArgumentException("Invalid products being added to productType: " + productType);
      }
    }
  }
  
  public void addProducts(List<Product> products) {
    for(Product p : products) {
      List<Product> currProducts = catalog.get(p.getProductType());
      if(currProducts == null) currProducts = new ArrayList<Product>();
      currProducts.add(p);
    }
  }
  
  public void addProduct(Product product) {
    //TODO
  }
  
  public void removeProduct(Product product) {
    //TODO
  }
  
  public Map<ProductType, List<Product>> menu() {
    return catalog;
  }
}
