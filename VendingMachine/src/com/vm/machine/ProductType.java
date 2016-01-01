package com.vm.machine;

/**
 * A product type can be assigned to a diff category after creation.
 * But name can't be changed after creation.
 * @author drm
 *
 */
public class ProductType {
  private String name;
  private Category category;
  
  public ProductType(String name, Category category) {
    this.name = name;
    this.category = category;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    ProductType other = (ProductType) obj;
    if (category != other.category)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ProductType [name=").append(name).append(", category=").append(category)
        .append("]");
    return builder.toString();
  }

  public String getName() {
    return name;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
  
  
}
