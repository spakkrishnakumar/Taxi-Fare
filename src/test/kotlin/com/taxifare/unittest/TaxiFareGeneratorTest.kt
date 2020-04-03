package com.taxifare.unittest

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.Distance
import com.taxifare.FareFormatter
import com.taxifare.TaxiFareGenerator
import org.junit.jupiter.api.Test

class TaxiFareGeneratorTest {

    @Test
    fun `should calculate taxi fare using distance and headcount`() {
        val expected = "Your fare is 2500"
        val distance = Distance("SomeWhere", "NoWhere", 200)
        val headCount = 2
        val formatter: FareFormatter = { fare -> "Your fare is ${fare.fare}" }
        val fareGenerator = TaxiFareGenerator(formatter)

        val actual = fareGenerator(distance, headCount)

        assertThat(actual, equalTo(expected))
    }
}