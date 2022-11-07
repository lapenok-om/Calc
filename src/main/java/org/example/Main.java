package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        try {
            System.out.println(calc(s));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static String calc(String input){
        String[] arr = input.split(" ");

        if (arr.length != 3){
            throw new IllegalArgumentException("incorrect expression");
        }

        Roman roman = new Roman();
        int a, b;

        if (roman.isRoman(arr[0]) && roman.isRoman(arr[2])){

            a = roman.convertRomanToInt(arr[0]);
            b = roman.convertRomanToInt(arr[2]);

            return roman.convertIntToRoman(calcSwitch(arr[1], a, b));

        } else if (!roman.isRoman(arr[0]) && !roman.isRoman(arr[2])){

            try {
                a = Integer.parseInt(arr[0]);
                b = Integer.parseInt(arr[2]);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("should be only integers");
            }

            return String.valueOf(calcSwitch(arr[1], a, b));

        } else throw new IllegalArgumentException("Uncorrected numbers");


    }

    public static int calcSwitch(String sign, int a, int b){
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

        return result;
    }
}
