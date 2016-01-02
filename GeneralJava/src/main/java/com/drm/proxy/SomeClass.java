package com.drm.proxy;

/**
 * A demonstration class.
 * 
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.2 $
 */
public interface SomeClass {
  /**
   * Print out the user name.
   */
  public abstract void someMethod();

  /**
   * Print out the string given to us.
   * 
   * @param text
   *          The string to print.
   */
  public abstract void someOtherMethod(final String text);
}
