package com.example.demo.utils;

public class Calculator {
    public static double calcul(int price, int countDays) {
        double percent = 0;
        if (countDays > 2 && countDays < 10)
            percent = 0.05;
        if(countDays > 9 && countDays < 20)
            percent = 0.15;
        if(countDays > 19)
            percent = 0.3;
        return price - (price * percent);
    }
}
