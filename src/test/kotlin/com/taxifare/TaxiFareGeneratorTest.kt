package com.taxifare

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class TaxiFareGeneratorTest {

    @Test
    fun `should calculate taxi fare using distance and headcount`() {
        val expected = "2500"
        val distance = 200
        val headCount = 2
        val fareGenerator = TaxiFareGenerator()

        val actual = fareGenerator(distance, headCount)

        assertThat(actual, equalTo(expected))
    }
}