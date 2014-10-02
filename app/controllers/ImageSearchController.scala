package controllers

import play.api._
import play.api.mvc._
import javax.inject.Inject
import service.ImageSearchService

class ImageSearchController @Inject() (val imageSearchService: ImageSearchService) extends Controller {

  def findImage(keyword: String) = Action {
    Redirect(imageSearchService.firstImageSource(keyword))
  }
  
}
