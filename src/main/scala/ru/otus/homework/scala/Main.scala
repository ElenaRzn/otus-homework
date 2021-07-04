package ru.otus.homework.scala

import ru.otus.homework.scala.model.Country
import ru.otus.homework.scala.util.{IOUtils, JsonUtils}


object Main extends App {
  implicit val countryOrdering: Ordering[Country] = Ordering.by(_.area)
  implicit val reversedCountryOrdering: Ordering[Country] = countryOrdering.reverse

  val outputFile = args(0)

  IOUtils.writeJson(outputFile, JsonUtils.writeCountries(
    JsonUtils.readCountries(
      IOUtils.readSource("https://raw.githubusercontent.com/mledoze/countries/master/countries.json")
    ).filter(_.region.exists(_== "Africa"))
      .sorted(reversedCountryOrdering)
      .take(10)
  ))






}
