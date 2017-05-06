package com.example.me.firstapp;

public class Helpers {

    public static String leadingZeroes(int number) {
        String temp = Integer.toString(number);
        if(temp.length() < 3) {
            int iterations = 3 - temp.length();
            for(int i = 0; i < iterations; i++) {
                temp = "0" + temp;
            }
        }
        return temp;
    }

    public static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

}
