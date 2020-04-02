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
        val taxiFareCal: (Int, Int) -> String = { _, _ -> TODO("not implemented") }
        val distanceCal: (Booking) -> Int = { _ -> TODO("not implemented") }

        val ula = TravelBooking(taxiFareCal, distanceCal)

        val actual = ula(booking(input))

        assertThat(actual, equalTo(expected))
    }

    private fun booking(input: String): Booking = input
        .split(",")
        .map { it.split("=") }
        .map { it.drop(1) }
        .flatten()
        .toBooking()

    private fun List<String>.toBooking(): Booking = Booking(get(0).trim(), get(1).trim(), get(2).trim().toInt())
}