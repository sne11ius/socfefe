name := """socfefe"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "net.codingwell" %% "scala-guice" % "4.0.0-beta4",
  "org.jsoup" % "jsoup" % "1.7.3",
  cache,
  ws
)

includeFilter in (Assets, LessKeys.less) := "*.less"

excludeFilter in (Assets, LessKeys.less) := "_*.less"
 
LessKeys.compress in Assets := true
