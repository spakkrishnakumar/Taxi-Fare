package com.taxifare.unittest

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.taxifare.Distance
import com.taxifare.FileDistanceRepository
import org.junit.jupiter.api.Test
import kotlin.text.Charsets.UTF_8

class FileDistanceRepositoryTest {

    @Test
    fun `fetch distance between source and destination from a file db`() {
        val fileName = "SampleDB.txt"
        val source = "PUNE"
        val destination = "MUMBAI"
        val expected = extractData(fileName).findDistance(source, destination)
        val repository = FileDistanceRepository(fileName)

        val actual = repository(source, destination)

        assertThat(actual, equalTo(expected))
    }

    private fun List<Distance>.findDistance(source: String, destination: String) =
        find { it.from == source && it.to == destination }
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

