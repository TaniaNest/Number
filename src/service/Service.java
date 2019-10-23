package service;

import model.Model;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Service {
    private  String[] twenty = { "ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одинадцать", "двенадцадь", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать" };
    private  String[] tens = {"десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто","сто" };


    public String  getNumber(Model number) {
        if ( number.getNumber() < 20 )
            return twenty[number.getNumber()];
        else if ( number.getNumber() <= 100 ) {
            int high = number.getNumber() / 10;
            int low = number.getNumber() % 10;
            String text = tens[high-1];
            if ( low != 0 )
                text = text + " " + twenty[low];
            return text;
        }
        return null;
    }
}
