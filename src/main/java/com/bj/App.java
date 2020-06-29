package com.bj;


import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Euro Million App to fetch results from google
 */
public class App {

    private static boolean isGoogleLookUp = false;

    private static ArrayList<String> euroMillionResults;

    private static MillionObject myMillionObject = new MillionObject();


    public static void main(String[] args) {


        euroMillionResults = isGoogleLookUp ? GoogleLookup.fetchEuroMillionResults() : AppUtils.readEuroMillionResultFromFile();

        //AppUtils.printEuroMillionResultData(euroMillionResults);

        if (isGoogleLookUp) {
            AppUtils.writeEuroMillionResultToFile(euroMillionResults);
        }

        for (String millionMark : euroMillionResults) {

            AppUtils.countDigitOccurrence(myMillionObject, millionMark);

        }


        printOccuranceDetails("FIRST PICK", myMillionObject.getFirstDigitOccurrenceInfoMap());
        printOccuranceDetails("SECOND PICK", myMillionObject.getSecondDigitOccurrenceInfoMap());
        printOccuranceDetails("THIRD PICK", myMillionObject.getThirdDigitOccurrenceInfoMap());
        printOccuranceDetails("FOURTH PICK", myMillionObject.getFourthDigitOccurrenceInfoMap());
        printOccuranceDetails("FIFTH PICK", myMillionObject.getFifthDigitOccurrenceInfoMap());
        printOccuranceDetails("FIRST LUCKY BALL", myMillionObject.getFirstLuckyBallOccurrenceInfoMap());
        printOccuranceDetails("SECOND LUCKY BALL", myMillionObject.getSecondLuckyBallOccurrenceInfoMap());

    }

    private static void printOccuranceDetails(String occurrenceIndex, TreeMap<String, Integer> occurrenceInfoMap) {
        System.out.println("*** " + occurrenceIndex + " ***");
        occurrenceInfoMap.forEach((key, value)
                -> System.out.println("[Digit] : " + key + " [Occurrence] : " + value));
    }


}
