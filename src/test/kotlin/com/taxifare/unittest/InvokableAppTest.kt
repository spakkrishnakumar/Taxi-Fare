package com.taxifare.unittest

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.Booking
import com.taxifare.InvokableApplication
import org.junit.jupiter.api.Test
import java.util.*

class InvokableAppTest {

    private val console = LinkedList<Booking>()
    private val spyLogger: (Booking) -> String = {
        console.push(it)
        "Your fare is ${10 * it.travel}"
    }

    @Test
    fun `can invoke app and accept input and produce output`() {
        val expected = Booking("Pune", "Nasik", 2)
        val getBooking = { expected }
        val getFare: (Booking) -> String = { booking -> spyLogger(booking) }
        val app = InvokableApplication(getBooking, getFare)

        app()

        assertThat(console.pop(), equalTo(expected))
    }

}