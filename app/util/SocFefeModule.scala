package util

import service.FefeBlogPostService
import service.impl.FefeBlogPostServiceImpl
import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import com.google.inject.Singleton

class SocFefeModule extends AbstractModule with ScalaModule {
  def configure {
    bind[FefeBlogPostService].to[FefeBlogPostServiceImpl].in[Singleton]
  }
}
