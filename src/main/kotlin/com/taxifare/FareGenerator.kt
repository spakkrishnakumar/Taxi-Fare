package com.taxifare

typealias FareGenerator = (Int, Int) -> String

class TaxiFareGenerator : FareGenerator {

    private val minimumDistance = 100
    private val minimumFare = 750
    private val perUnitDistanceFare = 5

    override fun invoke(distance: Int, headCount: Int): String =
        calculateFare(distance - minimumDistance, headCount).toString()

    private fun calculateFare(remainingDistance: Int, headCount: Int) =
        perHeadFare(remainingDistance) * headCount

    private fun perHeadFare(remainingDistance: Int) =
        if (remainingDistance <= 0) minimumFare else minimumFare + (remainingDistance * perUnitDistanceFare)

}