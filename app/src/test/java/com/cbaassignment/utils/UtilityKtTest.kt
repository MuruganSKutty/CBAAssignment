package com.cbaassignment.utils

import org.junit.Assert.*
import org.junit.Test

class UtilityKtTest {
    private val validDateFormat = "1997-08-25T05:05:08Z"
    private val invalidDateFormat = "1997/08/25T05:05:08Z"
    private val correctConvertedFormat = "Aug 25, 1997 5:05 AM"
    @Test
    fun test_convertValidDateFormat_trueExpected() {
        val res = convertDate(validDateFormat)
        assertEquals(res, correctConvertedFormat)
    }

    @Test
    fun test_convertInValidDateFormat_falseExpected() {
        val res = convertDate(invalidDateFormat)
        assertEquals(res, "")
    }

    @Test
    fun test_emptyDate_falseExpected() {
        val res = convertDate("")
        assertEquals(res, "")
    }
}