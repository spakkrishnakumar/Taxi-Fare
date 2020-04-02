package com.taxifare

typealias FareGenerator = (Distance, Int) -> String

class TaxiFareGenerator(
    private val outputFormatter: (Fare) -> String,
    private val minimumDistance: Int = 100,
    private val minimumFare: Int = 750,
    private val perUnitDistanceFare: Int = 5
) : FareGenerator {

    override fun invoke(distance: Distance, headCount: Int): String =
        Fare(
            distance,
            headCount,
            calculateFare(distance.distance - minimumDistance, headCount)
        ).let(outputFormatter)

    private fun calculateFare(remainingDistance: Int, headCount: Int) =
        perHeadFare(remainingDistance) * headCount

    private fun perHeadFare(remainingDistance: Int) =
        if (remainingDistance <= 0) minimumFare else minimumFare + (remainingDistance * perUnitDistanceFare)

}