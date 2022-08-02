package com.voleg.service;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperationsImpl {

    private boolean isToSave;
    private File historyFile;

    private String outputResult;
    private final List<BigInteger> digitsList = new ArrayList<>();

    private BigInteger x;
    private BigInteger y;
    private double power;

    public String countSum() {
        setAndSaveResult(x + " + " + y + " = " + (x.add(y)));

        return outputResult;
    }

    public String countSub() {
        setAndSaveResult(x + " - " + y + " = " + (x.subtract(y)));

        return outputResult;
    }

    public String countMult() {
        setAndSaveResult(x + " * " + y + " = " + (x.multiply(y)));

        return outputResult;
    }

    public String countDiv() {
        setAndSaveResult(x + " / " + y + " = " + (x.divide(y)));

        return outputResult;
    }

    public String countPow() {
        setAndSaveResult("Число " + x + " в степени " + power +
                " равно: " + Math.pow(x.longValue(), power) + "\n" +
                "Число " + y + " в степени " + power +
                " равно: " + Math.pow(y.longValue(), power));

        return outputResult;
    }

    public String compare() {
        String ans = "";

        if (x.compareTo(y) == 0) {
            ans = x + " = " + y;
        }

        if (x.compareTo(y) < 0) {
            ans = x + " < " + y;
        }

        if (x.compareTo(y) > 0) {
            ans = x + " > " + y;
        }

        setAndSaveResult(ans);

        return outputResult;
    }

    public String save(BigInteger digitToSave) {
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

    public static BigInteger getFibNumberByIndex(int index) {
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        BigInteger number = BigInteger.valueOf(index);

        for (int i = 1; i < index; i++) {
            number = first.add(second);
            first = second;
            second = number;
        }

        return number;
    }

    private void setAndSaveResult(String result) {
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

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }

    public void setX(BigInteger x) {
        this.x = x;
    }

    public void setY(BigInteger y) {
        this.y = y;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
