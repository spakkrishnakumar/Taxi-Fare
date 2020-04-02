package com.taxifare

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import sampleInput_1

class TaxiFareTest {

    @Test
    @Disabled("Customer Requirement Failing Test")
    internal fun `generate taxi fare for a booking`() {
        val input = sampleInput_1
        val expected = sampleOutput_1

        val actual = ""
        assertThat(actual, equalTo(expected))
    }
}