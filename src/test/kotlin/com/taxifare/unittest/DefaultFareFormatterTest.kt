package com.taxifare.unittest

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.DefaultFareFormatter
import com.taxifare.Distance
import com.taxifare.Fare
import com.taxifare.testdata.sampleOutput_1
import org.junit.jupiter.api.Test

class DefaultFareFormatterTest {

    @Test
    fun `should output fare in expected format`() {
        val expected = sampleOutput_1
        val formatter = DefaultFareFormatter()
        val fare = Fare(Distance("PUNE", "NASIK", 200), 2, 2500)

        val actual = formatter(fare)

        assertThat(actual, equalTo(expected))
    }

}