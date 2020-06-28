package com.bj;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleLookup {


    public static ArrayList<String> fetchEuroMillionResults() {

        System.out.println("Fetch results from Google");

        Document doc;
        ArrayList<String> myResults = new ArrayList<>();

        {
            try {
                for (String date : EuroMillionDrawDateUtils.getDrawDates()) {
                    doc = Jsoup.connect("https://www.google.com/search?q=euro%20million%20result%20" + date).get();
                    String millionaireNumber = doc.select("div.MDTDab").first().text();
                    myResults.add(AppUtils.formatEuroMillionResult(millionaireNumber));
                   // System.out.println("Euro Result for Date: " + date + " is " + AppUtils.formatEuroMillionResult(millionaireNumber));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return myResults;
    }

}

