
import play.api.GlobalSettings
import com.google.inject.Guice
import util.SocFefeModule

object Global extends GlobalSettings {
  
  /**
   * The Guice dependencies injector.
   */
  val injector = Guice.createInjector(new SocFefeModule)
  
   /**
   * Loads the controller classes with the Guice injector,
   * in order to be able to inject dependencies directly into the controller.
   *
   * @param controllerClass The controller class to instantiate.
   * @return The instance of the controller class.
   * @throws Exception if the controller couldn't be instantiated.
   */
  override def getControllerInstance[A](controllerClass: Class[A]) = injector.getInstance(controllerClass)
  
}
