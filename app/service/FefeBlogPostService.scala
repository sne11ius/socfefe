package service

import java.time.LocalDateTime
import models.FefeBlogPost
import models.FefeBlogPost
import scala.concurrent.Future

trait FefeBlogPostService {

  def find(end: LocalDateTime): Future[List[FefeBlogPost]]
  
  def find(begin: LocalDateTime, end: LocalDateTime): Future[List[FefeBlogPost]]

}
