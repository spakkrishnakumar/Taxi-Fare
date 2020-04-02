package com.taxifare

typealias FareFormatter = (Fare) -> String

class DefaultFareFormatter : FareFormatter {

    override fun invoke(fare: Fare): String = fare.run {
        """
        |Taxi Ticket
        |-----------
        |Source: ${distance.from}
        |Destination: ${distance.to}
        |Kms: ${distance.distance}
        |No. of travellers = $headCount
        |Total = $fare INR""".trimMargin()
    }

}