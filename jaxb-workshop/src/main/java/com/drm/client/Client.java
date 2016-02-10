package com.drm.client;

import static com.drm.jaxb.ReqResBuilder.*;

public class Client {
  public static void main(String[] args) {
    try {
      System.out.println(getQuery(getQueryType(QUERY)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
