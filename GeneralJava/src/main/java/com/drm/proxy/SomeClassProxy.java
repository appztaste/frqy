package com.drm.proxy;

/**
 * A simple proxy to SomeClass.
 * 
 * @author <a href=mailto:kraythe@arcor.de>Robert Simmons jr. (kraythe)</a>
 * @version $Revision: 1.2 $
 */
public class SomeClassProxy implements SomeClass {
  /** The impl object for this proxy. */
  private final SomeClassImpl impl;

  /**
   * Creates a new SomeClassProxy object.
   * 
   * @param impl
   *          The implementation object for this proxy.
   */
  public SomeClassProxy(final SomeClassImpl impl) {
    this.impl = impl;
  }

  /**
   * @see oreilly.hcj.proxies.SomeClass#someMethod()
   */
  public void someMethod() {
    this.impl.someMethod();
  }

  /**
   * @see oreilly.hcj.proxies.SomeClass#someOtherMethod(java.lang.String)
   */
  public void someOtherMethod(String text) {
    this.impl.someOtherMethod(text);
  }
}