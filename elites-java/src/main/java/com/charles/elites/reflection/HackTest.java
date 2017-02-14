package com.charles.elites.reflection;

import java.lang.reflect.InvocationTargetException;


public class HackTest {

  public static void main(String[] args) {
    testHackPrivateMember();
  }

  public static void testHackPrivateMember() {
    Hacker hacker = new Hacker();
    try {
      hacker.reflect();
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
