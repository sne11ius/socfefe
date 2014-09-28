
import play.api.GlobalSettings
import com.google.inject.Guice
import util.SocFefeModule

object Global extends GlobalSettings {
  
  val injector = Guice.createInjector(new SocFefeModule)
  
  override def getControllerInstance[A](controllerClass: Class[A]) = injector.getInstance(controllerClass)
  
}
