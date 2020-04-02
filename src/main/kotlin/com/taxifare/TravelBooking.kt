package com.taxifare

class TravelBooking(
    private val generateFare: FareGenerator,
    private val distance: (Booking) -> Int
) : Bookable {

    override fun invoke(booking: Booking): String = generateFare(distance(booking), booking.travel)

}

