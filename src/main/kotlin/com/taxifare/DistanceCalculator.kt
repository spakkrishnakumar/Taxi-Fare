package com.taxifare

typealias DistanceCalculator = (Booking) -> Int

class GroundDistanceCalculator(
    private val distanceCal: (String, String) -> Int
) : DistanceCalculator {

    override fun invoke(booking: Booking): Int = distanceCal(booking.source, booking.destination)
}