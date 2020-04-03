package com.taxifare.crt

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.*
import com.taxifare.testdata.sampleOutput_1
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import sampleInput_1

class TaxiFareTest {

    @ParameterizedTest
    @ValueSource(strings = [sampleInput_1])
    fun `generate taxi fare for a booking`(input: String) {
        val expected = sampleOutput_1

        val taxiFareCal: FareGenerator = TaxiFareGenerator(DefaultFareFormatter())
        val groundDistanceRepo: DistanceRepository = FileDistanceRepository("sampleDB.txt")
        val distanceCal: DistanceCalculator = GroundDistanceCalculator(groundDistanceRepo)

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
