package com.taxifare

typealias FareGenerator = (Distance, Int) -> String

class TaxiFareGenerator : FareGenerator {

    private val minimumDistance = 100
    private val minimumFare = 750
    private val perUnitDistanceFare = 5

    override fun invoke(distance: Distance, headCount: Int): String =
        TODO("Need to implement")
    /*Fare(
        distance,
        headCount,
        calculateFare(distance.distance - minimumDistance, headCount)
    ).prettify()*/

    private fun calculateFare(remainingDistance: Int, headCount: Int) =
        perHeadFare(remainingDistance) * headCount

    private fun perHeadFare(remainingDistance: Int) =
        if (remainingDistance <= 0) minimumFare else minimumFare + (remainingDistance * perUnitDistanceFare)

    private fun Fare.prettify() = """
        |Taxi Ticket
        |-----------
        |Source: ${distance.from}
        |Destination: ${distance.to}
        |Kms: ${distance.distance}
        |No. of travellers = $headCount
        |Total = $fare INR""".trimMargin()

}