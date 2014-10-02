package util

import service.FefeBlogPostService
import service.impl.FefeBlogPostServiceImpl
import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import com.google.inject.Singleton
import service.ImageSearchService
import service.impl.BingImageSearchServiceImpl

class SocFefeModule extends AbstractModule with ScalaModule {
  def configure {
    bind[FefeBlogPostService].to[FefeBlogPostServiceImpl].in[Singleton]
    bind[ImageSearchService].to[BingImageSearchServiceImpl].in[Singleton]
  }
}
