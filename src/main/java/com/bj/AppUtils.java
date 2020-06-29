package com.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeMap;

public class AppUtils {

    public static String formatEuroMillionResult(String input) {

        StringBuilder result = new StringBuilder(input);

        return new StringBuffer()
                .append(result.substring(0, 2))
                .append(AppConstants.STRING_DASH)
                .append(result.substring(2, 4))
                .append(AppConstants.STRING_DASH)
                .append(result.substring(4, 6))
                .append(AppConstants.STRING_DASH)
                .append(result.substring(6, 8))
                .append(AppConstants.STRING_DASH)
                .append(result.substring(8, 10))
                .append(AppConstants.STRING_DASH)
                .append(result.substring(10, 12))
                .append(AppConstants.STRING_DASH)
                .append(result.substring(13, 15))
                .toString();

    }


    public static void writeEuroMillionResultToFile(ArrayList<String> resultList) {
        System.out.println("Write results to File");
        Path path = Paths.get("./euro-million-results.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String result : resultList) {
                writer.write(result);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList readEuroMillionResultFromFile() {
        System.out.println("Fetch results from File");
        ArrayList<String> myResults = new ArrayList<>();
        Path path = Paths.get("./euro-million-results.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                myResults.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return myResults;
    }


    public static MillionObject countDigitOccurrence(MillionObject millionObject, String val) {
        //05-15-20-36-47-08-12
        populateOccurrenceInfoMap(millionObject.getFirstDigitOccurrenceInfoMap(), val.substring(0, 2));
        populateOccurrenceInfoMap(millionObject.getSecondDigitOccurrenceInfoMap(), val.substring(3, 5));
        populateOccurrenceInfoMap(millionObject.getThirdDigitOccurrenceInfoMap(), val.substring(6, 8));
        populateOccurrenceInfoMap(millionObject.getFourthDigitOccurrenceInfoMap(), val.substring(9, 11));
        populateOccurrenceInfoMap(millionObject.getFifthDigitOccurrenceInfoMap(), val.substring(12, 14));
        populateOccurrenceInfoMap(millionObject.getFirstLuckyBallOccurrenceInfoMap(), val.substring(15, 17));
        populateOccurrenceInfoMap(millionObject.getSecondLuckyBallOccurrenceInfoMap(), val.substring(18, 20));


        return millionObject;

    }

    private static void populateOccurrenceInfoMap(TreeMap<String, Integer> occurrenceInfoMap, String pickedNumber) {

        if (occurrenceInfoMap.containsKey(pickedNumber)) {

            occurrenceInfoMap.put(pickedNumber, occurrenceInfoMap.get(pickedNumber) + 1);

        } else {
            occurrenceInfoMap.put(pickedNumber, 1);
        }
    }


    public static void printEuroMillionResultData(ArrayList<String> resultData) {
        for (String val : resultData) {
            System.out.println(val);
        }
    }

}
