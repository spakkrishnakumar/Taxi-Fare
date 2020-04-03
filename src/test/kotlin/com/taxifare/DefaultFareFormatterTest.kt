package com.taxifare

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.testData.sampleOutput_1
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