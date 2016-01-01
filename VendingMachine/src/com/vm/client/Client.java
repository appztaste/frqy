package com.vm.client;

import com.vm.machine.Category;
import com.vm.machine.ProductType;
import com.vm.machine.VendingMachine;

public class Client {
  public static void main(String[] args) {
    VendingMachine vm = new VendingMachine();
    
    ProductType pt = new ProductType("Lays", Category.CHIPS);
    
  }
}
