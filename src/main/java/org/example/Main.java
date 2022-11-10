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

        while (true){
            System.out.println("Введите выражение (exit - для выхода)");
            String s = scn.nextLine();
            if(s.equals("exit")){
                break;
            }
            try {
                System.out.println(calc(s));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        scn.close();
    }

    public static String calc(String input){
        String[] arr = input.split(" ");

        if (arr.length != 3){
            throw new IllegalArgumentException("incorrect expression");
        }

        List<Character> romans = Arrays.asList('I', 'V', 'X');

        //если оба числа римские
        if (romans.contains(arr[0].charAt(0)) && romans.contains(arr[2].charAt(0))){

           Calculator calculator = new CalculatorRoman();
            return calculator.calc(arr[0], arr[2], arr[1]);

        //если оба числа арабские
        } else if (!romans.contains(arr[0].charAt(0)) && !romans.contains(arr[2].charAt(0))){

            Calculator calculator = new Calculator();
            return calculator.calc(arr[0], arr[2], arr[1]);

        } else throw new IllegalArgumentException("Uncorrected numbers");

    }
}
