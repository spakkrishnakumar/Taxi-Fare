package com.taxifare

typealias Invokable = () -> Unit

abstract class Application : Invokable {
    abstract fun book(): Booking
    abstract fun generate(booking: Booking): String
    override fun invoke() {
        generate(book())
    }
}

class InvokableApplication(
    val getBooking: () -> Booking,
    val getFare: (Booking) -> String
) : Application() {

    override fun book(): Booking = getBooking()

    override fun generate(booking: Booking): String = getFare(booking)

}