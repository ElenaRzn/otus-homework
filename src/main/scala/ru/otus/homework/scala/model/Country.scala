package ru.otus.homework.scala.model

import org.json4s.CustomSerializer
import org.json4s.JsonAST.JObject
import org.json4s.JsonDSL._

case class Country(name: String, region: Option[String], capital: Option[String], area: Int)

case class CountryCustomSerializer() extends CustomSerializer[Country](implicit format => ( {
  case jsonObj: JObject =>
    val officialName = (jsonObj \ "name" \ "official").extract[String]
    val region = (jsonObj \ "region").extract[Option[String]]
    val capital = (jsonObj \ "capital").extract[List[String]].headOption
    val area = (jsonObj \ "area").extract[Int]

    Country(officialName,region, capital, area)
}, {
  case country: Country =>
    ("name" -> country.name) ~
      ("capital" -> country.capital)  ~
      ("area" -> country.area)
}
))