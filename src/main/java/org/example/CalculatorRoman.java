package org.example;

import java.util.HashMap;
import java.util.Map;

public class CalculatorRoman extends Calculator{
    Map<Character,Integer> map = new HashMap<>();

    public CalculatorRoman() {
        map.put('I', 1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }

    @Override
    String calc(String x, String y, String sign) {
        int a = convertRomanToInt(x);
        int b = convertRomanToInt(y);

        String s = super.calc(String.valueOf(a),String.valueOf(b),sign);
        return convertIntToRoman(s);
    }

    int convertRomanToInt (String s){
        int result = 0;

        if(s.length() == 1) return map.get(s.charAt(0));

        for( int i = 0; i < s.length()-1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result + map.get(s.charAt(s.length()-1));
    }

    String convertIntToRoman (String st){
        int x = Integer.parseInt(st);

        if (x < 1){
            throw new ArithmeticException("the value of the expression is less than one");
        }

        StringBuilder s = new StringBuilder();

        if (x == 100) {
            return "C";
        }
        while (x >= 90) {
            s.append("XC");
            x -= 90;
        }
        while (x >= 50) {
            s.append("L");
            x -= 50;
        }
        while (x >= 40) {
            s.append("XL");
            x -= 40;
        }
        while (x >= 10) {
            s.append("X");
            x -= 10;
        }
        while (x >= 9) {
            s.append("IX");
            x -= 9;
        }
        while (x >= 5) {
            s.append("V");
            x -= 5;
        }
        while (x >= 4) {
            s.append("IV");
            x -= 4;
        }
        while (x >= 1) {
            s.append("I");
            x -= 1;
        }
        return s.toString();

    }
}
