ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
  .settings(
    name := "akka"
  )

enablePlugins(JavaAppPackaging)

mainClass in Compile := Some("ru.dio.server.Server")

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.19"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.19"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.9"


