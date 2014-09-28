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

  def index = Action.async {
    fefeBlogPostService.getDefaultPosts map {
      posts => {
        Logger.debug("#posts: " + posts.length)
        posts.foreach {
          post => {
            Logger.debug(post.toString())
          }
        }
      }
    }
    Future.successful(Ok(views.html.index("Your new application is ready.")))
  }
}
