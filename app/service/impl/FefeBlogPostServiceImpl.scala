package service.impl

import java.time.LocalDateTime
import service.FefeBlogPostService
import models.FefeBlogPost
import java.time.format.DateTimeFormatter
import play.Logger
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.ws.WS
import org.jsoup.Jsoup
import scala.concurrent.Future
import scala.collection.JavaConversions._
import models.FefeBlogPost
import java.sql.Timestamp
import java.time.ZoneOffset
import java.time.Instant

class FefeBlogPostServiceImpl extends FefeBlogPostService {
  
  val baseUrl = "http://blog.fefe.de/"
  val yearMonthFormat = DateTimeFormatter.ofPattern("yyyyMM")
  val fefec0de = java.lang.Long.parseLong("fefec0de", 16)
  
  
  def getDefaultPosts: Future[List[models.FefeBlogPost]] = {
    postsFromUrl(baseUrl)
  }
  
  def find(end: LocalDateTime): Future[List[FefeBlogPost]] = {
    find(LocalDateTime.now(), end)
  }
  
  def find(begin: LocalDateTime, end: LocalDateTime): Future[List[FefeBlogPost]] = {
    val currentTime = begin
    val currentUrl = baseUrl + "?mon=" + currentTime.format(yearMonthFormat)
    postsFromUrl(currentUrl)
  }
  
  def postsFromUrl(url: String) = {
    WS.url(url).get().map {
      response => {
        val doc = Jsoup.parse(response.body)
        doc.select("body > h3 + ul > li").map {
          singlePost => {
            val permaLink = singlePost.select("a:first-of-type").attr("href")
            val timestamp = makeTimeStamp(permaLink.drop(4))
            singlePost.select("a:first-of-type").remove()
            val postBody = singlePost.html()
            FefeBlogPost(permaLink, postBody, timestamp)
          }
        }
      }.toList
    }
  }
    
  def makeTimeStamp(encoded: String) = {
    val encodedTimestamp = java.lang.Long.parseLong(encoded, 16)
    val z = (encodedTimestamp ^ fefec0de) * 1000
    LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(z), ZoneOffset.UTC)
  }
}
