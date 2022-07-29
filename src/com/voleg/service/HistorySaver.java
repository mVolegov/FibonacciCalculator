package com.voleg.service;

import com.voleg.service.handlers.ExceptionHandler;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class HistorySaver {

    private static final Date date = new Date();

    public static void save(String dataToSave, File filePath) {
        try (FileWriter fileWriter =
                     new FileWriter(filePath, StandardCharsets.UTF_8, true);
             BufferedWriter bufferedWriter =
                     new BufferedWriter(fileWriter)) {
            bufferedWriter.write("*********************");
            bufferedWriter.newLine();
            bufferedWriter.write(dataToSave);
            bufferedWriter.newLine();
            bufferedWriter.write(date.toString());
            bufferedWriter.newLine();
        } catch (IOException exception) {
            ExceptionHandler.handle(exception);
        }
    }
}
