package controllers

import play.api._
import play.api.mvc._
import service.impl.FefeBlogPostServiceImpl
import java.time.LocalDateTime
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.Play.current
import scala.concurrent.Future
import service.FefeBlogPostService
import javax.inject.Inject

class Application @Inject() (val fefeBlogPostService: FefeBlogPostService) extends Controller {

  def index(ts: Option[String]) = Action.async {
    ts match {
      case Some(ts) => {
        fefeBlogPostService.getSinglePost(ts) map {
          post => Ok(views.html.index(List(post)))
        }
      }
      case None => {
        fefeBlogPostService.getDefaultPosts map {
          posts => {
            Ok(views.html.index(posts))
          }
        }
      }
    }
  }

}
