package service;

import model.Model;


public class Service {

    private String text;

    private int index;
    private int units;
    private int decimal;
    private int hundreds;

    private String[][] simpleText = {{"", "од", "дв", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "},
            {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "}};

    private String[] text10to19 = {"десять", "одинадцать ", "двенадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
            "шеснадцать ", "семьнадцать ", "восемьнадцать ", "девятнадцать "};

    private String[][] textMillion = {{"", "", ""},
            {"миллионов ", "тысячь ", ""},
            {"миллион ", "тысяча ", ""},
            {"миллиона ", "тысячи ", ""},
            {"миллионов ", "тысячь ", ""}};


    public String getNumber(Model number) {
        if (number.getNumber() == 0) {
            return text = "ноль ";
        }
        int million = number.getNumber() / 1000000;
        int thousand = (number.getNumber() - (million * 1000000)) / 1000;
        int toThousand = number.getNumber() % 1000;

        text = getWordOfNum(million, 0) + getWordOfNum(thousand, 1) + getWordOfNum(toThousand, 2);
        return text;

    }


    private String getWordOfNum(int num, int id) {
        hundreds = num / 100;
        decimal = (num - (hundreds * 100)) / 10;
        units = num % 10;

        getToThousand();
        getGender(id);
        index = 0;
        if (num != 0) {
            getIndex();
        }
        text = text + textMillion[index][id];
        return text;
    }

    private int getIndex() {
        if (units == 0 || decimal == 1) {
            return index = 1;
        } else if (units == 1) {
            return index = 2;
        } else if (units > 1 && units < 5) {
            return index = 3;
        } else {
            return index = 4;
        }
    }

    private String getToThousand() {
        if (decimal == 1) {
            return text = simpleText[2][hundreds] + text10to19[units];
        } else {
            return text = simpleText[2][hundreds] + simpleText[1][decimal] + simpleText[0][units];
        }
    }

    private String getGender(int index) {
        if (index == 1) {
            if (units == 1 && decimal != 1) {
                return text = text + "на ";
            } else if (units == 2 && decimal != 1) {
                return text = text + "е ";
            }
            if (units != 0 && decimal != 1) {
                return text = text + " ";
            }
        } else {
            if (units == 1 && decimal != 1) {
                return text = text + "ин ";
            }
            if (units == 2 && decimal != 1) {
                return text = text + "а ";
            } else if (units != 0 && decimal != 1) {
                return text = text + " ";
            }
        }
        return "";
    }


}

