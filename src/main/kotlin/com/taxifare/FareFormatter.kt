package com.taxifare

typealias FareFormatter = (Fare) -> String

class DefaultFareFormatter : FareFormatter {

    override fun invoke(fare: Fare): String = """
        |Taxi Ticket
        |-----------
        |Source: ${fare.distance.from}
        |Destination: ${fare.distance.to}
        |Kms: ${fare.distance.distance}
        |No. of travellers = ${fare.headCount}
        |Total = ${fare.fare} INR""".trimMargin()
}