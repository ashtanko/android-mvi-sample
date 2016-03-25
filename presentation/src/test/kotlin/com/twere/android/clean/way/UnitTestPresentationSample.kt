package com.twere.android.clean.way

import org.junit.Assert
import org.junit.Test

class UnitTestPresentationSample {

    @Test
    fun firstTest() {
        var a: Int = 2 + 2
        Assert.assertTrue(a == 4)
    }

    @Test
    fun secondTest() {
        Assert.assertEquals(4, 2 + 2)
    }
}