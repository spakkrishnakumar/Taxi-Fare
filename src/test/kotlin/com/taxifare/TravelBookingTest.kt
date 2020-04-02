package com.taxifare

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class TravelBookingTest {

    @Test
    fun `should generate fare from booking`() {
        val expected = "Your fare is 20"
        val coronaPatients = Booking("Earth", "Heaven", 2)
        val calFare: (Int, Int) -> String = { distance, headCount -> (distance * headCount).toString() }
        val calDistance: (Booking) -> Int = { _ -> 10 }

        val taxi = TravelBooking(calFare, calDistance)

        val actual = taxi(coronaPatients)

        assertThat(actual, equalTo(expected))
    }

}