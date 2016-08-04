package com.charles.elites.quest;

public class PasswordValidation {
    public static Boolean strongPassword(String password) {
        if(password.length() < 12)
            return false;
        if(password.equals(password.toLowerCase()) || password.equals(password.toUpperCase()) || !password.matches(".*[0-9].*"))
            return false;
        String[] temp = password.toLowerCase().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        System.out.println(String.join(",", temp));
        if(temp.length < 2)
            return false;
        if(temp.length <= 3) {
            int count = 0;
            for(String s : temp) {
                if(Character.isLetter(s.charAt(0)))
                    count++;
            }
            if(count < 2)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(strongPassword("123213Strong1Password")); // Strong password
//        System.out.println(strongPassword("strong1password")); // Weak password
        System.out.println(strongPassword("Strong11287622"));
        System.out.println(strongPassword("SSaaas0123ll"));
    }
}