package com.voleg.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperationsImpl {

    private boolean isToSave;
    private File historyFile;

    private String outputResult;
    private final List<Long> digitsList = new ArrayList<>();

    private long x;
    private long y;
    private double power;

    public String countSum() {
        setAndSaveResult(x + " + " + y + " = " + (x + y));

        return outputResult;
    }

    public String countSub() {
        setAndSaveResult(x + " - " + y + " = " + (x - y));

        return outputResult;
    }

    public String countMult() {
        setAndSaveResult(x + " * " + y + " = " + (x * y));

        return outputResult;
    }

    public String countDiv() {
        setAndSaveResult(x + " / " + y + " = " + (x / y));

        return outputResult;
    }

    public String countPow() {
        setAndSaveResult("Число " + x + " в степени " + power +
                " равно: " + Math.pow(x, power) + "\n" +
                "Число " + y + " в степени " + power +
                " равно: " + Math.pow(y, power));

        return outputResult;
    }

    public String compare() {
        String ans = "";

        if (x == y) {
            ans = x + " = " + y;
        }

        if (x < y) {
            ans = x + " < " + y;
        }

        if (x > y) {
            ans = x + " > " + y;
        }

        setAndSaveResult(ans);

        return outputResult;
    }

    public String save(long digitToSave) {
        digitsList.add(digitToSave);

        setAndSaveResult(digitsList.toString());

        return outputResult;
    }

    public String clear() {
        digitsList.clear();

        setAndSaveResult("Произошла очистка");

        return "Пока не было записей";
    }

    public String sort() {
        Collections.sort(digitsList);

        if (!digitsList.isEmpty()) {
            setAndSaveResult(digitsList.toString());
        } else {
            outputResult = "Пока не было записей";
        }

        return outputResult;
    }

    public static long getFibNumberByIndex(long index) {
        long first = 0;
        long second = 1;
        long number = index;

        for (int i = 1; i < index; i++) {
            number = first + second;
            first = second;
            second = number;
        }

        return number;
    }

    private  void setAndSaveResult(String result) {
        outputResult = result;

        if (isToSave) {
            HistorySaver.save(outputResult, historyFile);
        }
    }

    public void setToSave(boolean toSave) {
        isToSave = toSave;
    }

    public void setHistoryFile(File filePath) {
        historyFile = filePath;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(long y) {
        this.y = y;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
