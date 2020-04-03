package com.taxifare.unittest

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.*
import org.junit.jupiter.api.Test

class TravelBookingTest {

    @Test
    fun `should generate fare from booking`() {
        val expected = "Your fare is 20"
        val source = "Earth"
        val destination = "Heaven"
        val coronaPatients = Booking(source, destination, 2)
        val calFare: FareGenerator = { distance, headCount -> "Your fare is ${distance.distance * headCount}" }
        val calDistance: DistanceCalculator = { _ -> Distance(source, destination, 10) }

        val taxi = TravelBooking(calFare, calDistance)

        val actual = taxi(coronaPatients)

        assertThat(actual, equalTo(expected))
    }

}