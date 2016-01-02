package com.drm.rmi;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Serialization {

  public static void main(String[] args) {
    Serialization s = new Serialization();
    try {
      s.testSerialization();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void testSerialization() throws IOException, ClassNotFoundException {
    Employee e = new Employee("drm", 1);
    System.out.println(e);
    //write(e);
    read();
  }
  
  public void write(Employee e) throws IOException {
    FileOutputStream fos = new FileOutputStream("./employee.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(e);
    oos.close();
  }
  
  public void read() throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream("./employee.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    System.out.println((Employee)ois.readObject());
    ois.close();
  }
}


class Employee implements Serializable {
  
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  int id;
  String name;
  
  

  //Date joined;
  Address address;

  public Employee(String name, int id) {
    this.name = name;
    this.id = id;
    //this.joined = Calendar.getInstance().getTime();
    this.address = new Address("ggn", "maruti", 1548, 122002);
  }
  
  public void m() {
    
  }

  public String toString() {
    return "name: " + this.name + ", [id]: " + 
          this.id + ", address: " + this.address;
    //+ ", joined: " + this.joined;
  }
}

class Address implements Serializable {
  String city;
  String society;
  int houseNum;
  int pincode;
  
  Address(String city, String appt, int houseNum, int pincode) {
    this.city = city;
    this.society = appt;
    this.houseNum = houseNum;
    this.pincode = pincode;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Address [city=").append(city).append(", appt=").append(society)
        .append(", houseNum=").append(houseNum).append(", pincode=").append(pincode).append("]");
    return builder.toString();
  }
  
  
  
  
}
