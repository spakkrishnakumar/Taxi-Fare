package com.taxifare

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class TravelBookingTest {

    @Test
    @Disabled("Refactoring Distance calculator")
    fun `should generate fare from booking`() {
        val expected = "Your fare is 20"
        val coronaPatients = Booking("Earth", "Heaven", 2)
        val calFare: FareGenerator = { distance, headCount -> "Your fare is ${distance.distance * headCount}" }
        val calDistance: DistanceCalculator = { _ -> TODO("not implemented") }

        val taxi = TravelBooking(calFare, calDistance)

        val actual = taxi(coronaPatients)

        assertThat(actual, equalTo(expected))
    }

}