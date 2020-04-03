package com.taxifare.crt

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.*
import com.taxifare.testdata.sampleOutput_1
import com.taxifare.testdata.sampleOutput_2
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import sampleInput_1
import sampleInput_2

class TaxiFareTest {

    @ParameterizedTest
    @MethodSource("sampleInputAndOutput")
    fun `generate taxi fare for a booking`(input: String, output: String) {

        val taxiFareCal: FareGenerator = TaxiFareGenerator(DefaultFareFormatter())
        val groundDistanceRepo: DistanceRepository = FileDistanceRepository("sampleDB.txt")
        val distanceCal: DistanceCalculator = GroundDistanceCalculator(groundDistanceRepo)

        val ula = TravelBooking(taxiFareCal, distanceCal)

        val actual = ula(booking(input))

        assertThat(actual, equalTo(output))
    }

    private fun booking(input: String): Booking = input
        .split(",")
        .map { it.split("=") }
        .map { it.drop(1) }
        .flatten()
        .toBooking()

    private fun List<String>.toBooking(): Booking = Booking(get(0).trim(), get(1).trim(), get(2).trim().toInt())

    companion object {
        @JvmStatic
        fun sampleInputAndOutput() = listOf(
            Arguments.of(sampleInput_1, sampleOutput_1),
            Arguments.of(sampleInput_2, sampleOutput_2)
        )
    }

}
