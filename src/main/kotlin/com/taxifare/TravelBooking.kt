package com.taxifare

class TravelBooking(
    private val generateFare: (Int, Int) -> String,
    private val distance: (Booking) -> Int
) : Bookable {

    override fun invoke(booking: Booking): String {
        return generateFare(distance(booking), booking.travel)
    }

}

