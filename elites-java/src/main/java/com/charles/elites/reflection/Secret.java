package com.charles.elites.reflection;

public class Secret {
  private String secretCode = "It's a scecret";

  private static final Long TIME = 19000L;

  private String getSecretCode() {
    return secretCode;
  }

  public static Long getTime() {
    return TIME;
  }
}
