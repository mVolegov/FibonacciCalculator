package com.voleg.service.handlers;

import com.voleg.service.OperationsImpl;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class InputHandler {

    public static BigInteger fibDigitInputHandler(TextField textField) throws IllegalArgumentException {
        if (textField.getText().equals("") || textField.getText().equals("-")) {
            return BigInteger.ZERO;
        }

        int digitOne = Integer.parseInt(textField.getText());

        if (digitOne < 0) {
            throw new IllegalArgumentException("Отрицательные индексы не поддерживаются");
        }

        return OperationsImpl.getFibNumberByIndex(digitOne);
    }

    public static double powerDigitInputHandler(TextField textField) throws IllegalArgumentException {
        if (textField.getText().equals("") || textField.getText().equals("-")) {
            return 0;
        }

        return Double.parseDouble(textField.getText());
    }
}
