package com.taxifare

typealias DistanceCalculator = (Booking) -> Distance

class GroundDistanceCalculator(
    private val distanceCal: (String, String) -> Int
) : DistanceCalculator {

    override fun invoke(booking: Booking): Distance = booking.run {
        Distance(source, destination, distanceBetween(source, destination))
    }

    private fun distanceBetween(source: String, destination: String) = distanceCal(source, destination)
}