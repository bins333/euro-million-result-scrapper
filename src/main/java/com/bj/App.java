package com.bj;


import java.util.ArrayList;

/**
 * Euro Million App to fetch results from google
 */
public class App {

    static boolean isGoogleLookUp = false;

    static ArrayList<String> euroMillionResults;


    public static void main(String[] args) {


        euroMillionResults = isGoogleLookUp ? GoogleLookup.fetchEuroMillionResults() : AppUtils.readEuroMillionResultFromFile();

        for (String val : euroMillionResults) {
            System.out.println(val);
        }

        if(isGoogleLookUp){
            AppUtils.writeEuroMillionResultToFile(euroMillionResults);
        }
    }


}
