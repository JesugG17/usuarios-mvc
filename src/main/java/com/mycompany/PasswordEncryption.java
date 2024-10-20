package com.mycompany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {

  private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public static String encryptPassword(String plainPassword) {
    return passwordEncoder.encode(plainPassword);
  }

  public static boolean isPasswordMatch(
      String plainPassword,
      String hashedPassword) {
    return passwordEncoder.matches(plainPassword, hashedPassword);
  }
}
