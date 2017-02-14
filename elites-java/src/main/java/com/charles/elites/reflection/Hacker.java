package com.charles.elites.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Hacker {

  private static final Object[] EMPTY = {};

  public void reflect() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Secret instance = new Secret();
    Class<?> secretClass = instance.getClass();

    // Print all the method names & execution result
    Method methods[] = secretClass.getDeclaredMethods();
    System.out.println("Access all the methods");
    for (Method method : methods) {
      System.out.println("Method Name: " + method.getName());
      System.out.println("Return type: " + method.getReturnType());
      method.setAccessible(true);

      System.out.println(method.invoke(instance, EMPTY) + "\n");
    }

    // Print all the field names & values
    Field fields[] = secretClass.getDeclaredFields();
    System.out.println("Access all the fields");
    for (Field field : fields) {
      System.out.println("Field Name: " + field.getName());
      field.setAccessible(true);

      System.out.println(field.get(instance) + "\n");
    }
  }
}
