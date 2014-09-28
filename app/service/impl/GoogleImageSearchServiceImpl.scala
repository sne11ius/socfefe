package service.impl

import service.GoogleImageSearchService
import org.jsoup.Jsoup
import play.Logger
import java.net.URLEncoder
import play.api.libs.json.Json

class GoogleImageSearchServiceImpl extends GoogleImageSearchService {
  
  def firstImageSource(searchText: String): String = {
    // yep, we use bing :D
    try {
      val url = "http://www.bing.com/images/search?q=" + URLEncoder.encode(searchText.replace(".", " "), "UTF-8")
      val doc = Jsoup.connect(url).get()
      val data = doc.select(".dg_u a").get(0).attr("m")
      """imgurl\:\"((\\"|[^"])*)\"""".r.findFirstIn(data).get.toString().replace("imgurl:", "").replace("\"", "")
    } catch {
      case t: Throwable => {
        Logger.error(t.getMessage(), t)
        "http://rahatelectronics.com.pk/wp-content/themes/rahatelectronics/images/image_not_found.jpg"
      }
    }
  }
  
}
