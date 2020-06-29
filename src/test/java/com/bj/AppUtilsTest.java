package com.bj;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AppUtilsTest {

    @Test
    public void testValidStringAndFormatWithDash() {
        assertThat(AppUtils.formatEuroMillionResult("011012212605 11"), is("01-10-12-21-26-05-11"));
    }


    @Test
    public void testCountDigitForOneString() {
        MillionObject findMyMillionObj = new MillionObject();
        AppUtils.countDigitOccurrence(findMyMillionObj, "05-15-20-36-47-08-12");
        assertThat(findMyMillionObj.getFirstDigitOccurrenceInfoMap().values(), contains(1));
        assertThat(findMyMillionObj.getFirstDigitOccurrenceInfoMap().keySet(), contains("05"));

        assertThat(findMyMillionObj.getSecondDigitOccurrenceInfoMap().values(), contains(1));
        assertThat(findMyMillionObj.getSecondDigitOccurrenceInfoMap().keySet(), contains("15"));


        assertThat(findMyMillionObj.getThirdDigitOccurrenceInfoMap().values(), contains(1));
        assertThat(findMyMillionObj.getThirdDigitOccurrenceInfoMap().keySet(), contains("20"));


        assertThat(findMyMillionObj.getFourthDigitOccurrenceInfoMap().values(), contains(1));
        assertThat(findMyMillionObj.getFourthDigitOccurrenceInfoMap().keySet(), contains("36"));


        assertThat(findMyMillionObj.getFifthDigitOccurrenceInfoMap().values(), contains(1));
        assertThat(findMyMillionObj.getFifthDigitOccurrenceInfoMap().keySet(), contains("47"));

        assertThat(findMyMillionObj.getFirstLuckyBallOccurrenceInfoMap().values(), contains(1));
        assertThat(findMyMillionObj.getFirstLuckyBallOccurrenceInfoMap().keySet(), contains("08"));

        assertThat(findMyMillionObj.getSecondLuckyBallOccurrenceInfoMap().values(), contains(1));
        assertThat(findMyMillionObj.getSecondLuckyBallOccurrenceInfoMap().keySet(), contains("12"));

    }

    @Test
    public void testCountDigitForMultipleString() {
        MillionObject findMyMillionObj = new MillionObject();
        AppUtils.countDigitOccurrence(findMyMillionObj, "05-15-20-36-47-08-12");
        AppUtils.countDigitOccurrence(findMyMillionObj, "05-08-12-37-43-06-11");

        assertThat(findMyMillionObj.getFirstDigitOccurrenceInfoMap().values(), contains(2));
        assertThat(findMyMillionObj.getFirstDigitOccurrenceInfoMap().keySet(), contains("05"));

        assertThat(findMyMillionObj.getSecondDigitOccurrenceInfoMap().values(), containsInAnyOrder(1, 1));
        assertThat(findMyMillionObj.getSecondDigitOccurrenceInfoMap().keySet(), containsInAnyOrder("15", "08"));


        assertThat(findMyMillionObj.getThirdDigitOccurrenceInfoMap().values(), containsInAnyOrder(1, 1));
        assertThat(findMyMillionObj.getThirdDigitOccurrenceInfoMap().keySet(), containsInAnyOrder("20", "12"));


        assertThat(findMyMillionObj.getFourthDigitOccurrenceInfoMap().values(), containsInAnyOrder(1, 1));
        assertThat(findMyMillionObj.getFourthDigitOccurrenceInfoMap().keySet(), containsInAnyOrder("36", "37"));


        assertThat(findMyMillionObj.getFifthDigitOccurrenceInfoMap().values(), containsInAnyOrder(1, 1));
        assertThat(findMyMillionObj.getFifthDigitOccurrenceInfoMap().keySet(), containsInAnyOrder("47", "43"));

        assertThat(findMyMillionObj.getFirstLuckyBallOccurrenceInfoMap().values(), containsInAnyOrder(1, 1));
        assertThat(findMyMillionObj.getFirstLuckyBallOccurrenceInfoMap().keySet(), containsInAnyOrder("08", "06"));

        assertThat(findMyMillionObj.getSecondLuckyBallOccurrenceInfoMap().values(), containsInAnyOrder(1, 1));
        assertThat(findMyMillionObj.getSecondLuckyBallOccurrenceInfoMap().keySet(), containsInAnyOrder("12", "11"));

    }


}