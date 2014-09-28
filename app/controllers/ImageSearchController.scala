package controllers

import play.api._
import play.api.mvc._
import javax.inject.Inject
import service.GoogleImageSearchService

class ImageSearchController @Inject() (val googleImageSearchService: GoogleImageSearchService) extends Controller {

  def findImage(keyword: String) = Action {
    Redirect(googleImageSearchService.firstImageSource(keyword))
  }
  
}
