package controllers

import play.api._
import play.api.mvc._
import service.impl.FefeBlogPostServiceImpl
import java.time.LocalDateTime
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.Play.current
import scala.concurrent.Future

object Application extends Controller {

  def index = Action.async {
    try {
      val fefeBlogPosts = new FefeBlogPostServiceImpl().find(LocalDateTime.now().plusMonths(2))
      fefeBlogPosts.map {
        posts => {
          Logger.debug("#posts: " + posts.length)
          posts.take(1).foreach {
            post => {
              Logger.debug(post.toString())
            }
          }
        }
      }
    } catch {
      case t: Throwable => t.printStackTrace()
    }
    Future.successful(Ok(views.html.index("Your new application is ready.")))
  }

}