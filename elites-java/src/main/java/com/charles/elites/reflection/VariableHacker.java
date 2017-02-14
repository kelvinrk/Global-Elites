package com.charles.elites.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


/**
 * Created by kwang3 on 2/13/17.
 */
public class VariableHacker {

  /**
   * Assign static final variable with a new value
   * @param field
   * @param newValue
   * @throws Exception
   */
  public static void setFinalStatic(Field field, Object newValue) throws Exception {
    field.setAccessible(true);

    // remove final modifier from field
    Field modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

    field.set(null, newValue);
  }

}
