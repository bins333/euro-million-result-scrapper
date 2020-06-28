package com.bj;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class AppUtilsTest {

    @Test
    public void testValidStringAndFormatWithDash(){
        assertThat(AppUtils.formatEuroMillionResult("011012212605 11"),is("01-10-12-21-26-05-11"));
    }

}