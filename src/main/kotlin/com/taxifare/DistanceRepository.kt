package com.taxifare

import kotlin.text.Charsets.UTF_8

typealias DistanceRepository = (String, String) -> Int

class FileDistanceRepository(
    fileName: String
) : DistanceRepository {

    private val dataSource = extractData(fileName)

    override fun invoke(source: String, destination: String): Int =
        dataSource.find { it.from == source && it.to == destination }
            ?.distance
            ?: throw RuntimeException("Invalid Data in DataSource")

    private fun extractData(fileName: String): List<Distance> =
        javaClass.getResource("/$fileName")
            .readText(UTF_8)
            .split("\n")
            .drop(1)
            .map { it.toDistance() }

    private fun String.toDistance(): Distance =
        split(",").let { Distance(it[0], it[1], it[2].toInt()) }

}