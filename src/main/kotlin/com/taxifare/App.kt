package com.taxifare

fun main() {

    val taxiFareCal: FareGenerator = TaxiFareGenerator(DefaultFareFormatter())
    val groundDistanceRepo: DistanceRepository = FileDistanceRepository("sampleDB.txt")
    val distanceCal: DistanceCalculator = GroundDistanceCalculator(groundDistanceRepo)
    val taxiBooking = TravelBooking(taxiFareCal, distanceCal)

    val app = ConsoleApp(taxiBooking)

    app()
}

class ConsoleApp(
    private val bookingService: Bookable
) : Application() {

    override fun book(): Booking {
        println("Enter Booking Info: ")
        print("Enter From: ")
        val from = readLine().orEmpty()
        print("Enter To: ")
        val to = readLine().orEmpty()
        print("Enter No of travellers: ")
        val headCount = readLine()?.toInt() ?: 0
        return Booking(from, to, headCount)
    }

    override fun generate(booking: Booking): String = bookingService(booking).also(::printFare)

    private fun printFare(fare: String) {
        println("\nYour Fare is: ")
        println(fare)
    }

}


