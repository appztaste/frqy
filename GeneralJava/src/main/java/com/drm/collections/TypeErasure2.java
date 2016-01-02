package com.drm.collections;

import java.sql.SQLException;

public class TypeErasure2<T extends Exception>
{
  public static void main(String[] args)
  {
    //new TypeErasure2().pleaseThrow(new SQLException());
  }
  
  private void pleaseThrow(Exception e)
    throws Exception
  {
    throw e;
  }
}
