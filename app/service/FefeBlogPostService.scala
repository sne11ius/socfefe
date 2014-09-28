package service

import java.time.LocalDateTime
import models.FefeBlogPost
import models.FefeBlogPost
import scala.concurrent.Future

trait FefeBlogPostService {

  def getDefaultPosts: Future[List[FefeBlogPost]]
  
  def getSinglePost(ts: String): Future[FefeBlogPost]
  
  def find(end: LocalDateTime): Future[List[FefeBlogPost]]
  
  def find(begin: LocalDateTime, end: LocalDateTime): Future[List[FefeBlogPost]]

}
