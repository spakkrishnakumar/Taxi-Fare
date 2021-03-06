package com.taxifare.unittest

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.Booking
import com.taxifare.DistanceRepository
import com.taxifare.GroundDistanceCalculator
import org.junit.jupiter.api.Test

class GroundDistanceCalculatorTest {

    @Test
    fun `should calculate ground distance between source and destination`() {
        val expected = 10
        val booking = Booking("My House", "My GirlFriend's House", 1)
        val distanceCal: DistanceRepository = { _, _ -> 10 }
        val cal = GroundDistanceCalculator(distanceCal)

        val actual = cal(booking).distance

        assertThat(actual, equalTo(expected))
    }

}