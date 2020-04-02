package com.taxifare

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class TaxiFareGeneratorTest {

    @Test
    @Disabled("Formatting the needs to be implemented")
    fun `should calculate taxi fare using distance and headcount`() {
        val expected = sampleOutput_1
        val distance = Distance("PUNE", "NASIK", 200)
        val headCount = 2
        val fareGenerator = TaxiFareGenerator()

        val actual = fareGenerator(distance, headCount)

        assertThat(actual, equalTo(expected))
    }
}