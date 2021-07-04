package ru.otus.homework.scala.util
import java.io.{File, PrintWriter}
import scala.io.Source

object IOUtils {

  def readSource(sourceUrl: String): String = {
    val source = Source.fromURL(sourceUrl)
    try {
     source.getLines().mkString(" ")
    } finally {
      source.close()
    }
  }

  def writeJson(fileName: String, data: String) = {
    val printWriter = new PrintWriter(new File(fileName))
    try {
      printWriter.println(data)
      printWriter.flush()
    } finally {
      printWriter.close()
    }

  }


}
