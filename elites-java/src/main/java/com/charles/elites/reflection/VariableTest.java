package com.charles.elites.reflection;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by kwang3 on 2/13/17.
 */
public class VariableTest {

  @Test
  public void testVariableHacker() throws Exception {

      Long newValue = 666L;
      VariableHacker.setFinalStatic(Secret.class.getDeclaredField("TIME"), newValue);
//      VariableHacker.setFinaRlStatic();
      System.out.println(Secret.getTime());
      assertEquals(newValue, Secret.getTime());
  }
}
