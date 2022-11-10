package org.example;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    public Calculator() {
    }

    String calc (String x, String y, String sign){
        int a,b;

        try {
            a = Integer.parseInt(x);
            b = Integer.parseInt(y);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("should be only integers");
        }

        int result = 0;
        List<String> signs = Arrays.asList("+", "-", "*", "/");

        if (!signs.contains(sign)){
            throw new IllegalArgumentException("incorrect sign");
        }

        if (a > 10 || b > 10) {
            throw new IllegalArgumentException("the number cannot be more than 10");
        }

        switch (sign){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }

        return String.valueOf(result);
    }
}
