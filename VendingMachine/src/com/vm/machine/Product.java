package com.vm.machine;

/**
 * Product class. When a new product is added, make sure it belongs to a productType,
 * has a name, id and price. price can be changed after creation. Name, Id and 
 * product type remains same.
 * 
 * @author drm
 *
 */
public class Product {
  private int price;
  private String name;
  private long productId;
  private ProductType productType;
  
  public Product(String name, long productId, int price, ProductType productType) {
    this.name = name;
    this.price = price;
    this.productId = productId;
    this.productType = productType;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (productId ^ (productId >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (productId != other.productId)
      return false;
    return true;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public long getProductId() {
    return productId;
  }

  public ProductType getProductType() {
    return productType;
  }

}
