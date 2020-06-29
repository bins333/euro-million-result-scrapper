package com.bj;

import lombok.Getter;
import lombok.Setter;

import java.util.TreeMap;

@Getter
@Setter
public class MillionObject {

    private TreeMap<String, Integer> firstDigitOccurrenceInfoMap = new TreeMap<>();

    private TreeMap<String, Integer> secondDigitOccurrenceInfoMap = new TreeMap<>();

    private TreeMap<String, Integer> thirdDigitOccurrenceInfoMap = new TreeMap<>();

    private TreeMap<String, Integer> fourthDigitOccurrenceInfoMap = new TreeMap<>();

    private TreeMap<String, Integer> fifthDigitOccurrenceInfoMap = new TreeMap<>();

    private TreeMap<String, Integer> firstLuckyBallOccurrenceInfoMap = new TreeMap<>();

    private TreeMap<String, Integer> secondLuckyBallOccurrenceInfoMap = new TreeMap<>();


}
