package ru.otus.homework.scala.util

import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization
import ru.otus.homework.scala.model.{Country, CountryCustomSerializer}

object JsonUtils {
  implicit val formats: Formats = DefaultFormats + new CountryCustomSerializer

  def readCountries(json: String): List[Country] = parse(json).extract[List[Country]]

  def writeCountries(countries: List[Country]): String = Serialization.write(countries)
}
