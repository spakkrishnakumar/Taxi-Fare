package com.taxifare

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class GroundDistanceCalculatorTest {

    @Test
    fun `should calculate ground distance between source and destination`() {
        val expected = 10
        val booking = Booking("My House", "My GirlFriend's House", 1)
        val distanceCal: (String, String) -> Int = { _, _ -> 10 }
        val cal = GroundDistanceCalculator(distanceCal)

        val actual = cal(booking)

        assertThat(actual, equalTo(expected))
    }

}