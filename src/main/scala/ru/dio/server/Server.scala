package ru.dio.server

import akka.actor.typed.ActorSystem
import akka.actor.typed.javadsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._

import scala.concurrent.Future

object Server extends App {

  val content =
    """
      |<html>
      | <body>
      |   AKKA HTTP
      | </body>
      |</html>
      |""".stripMargin

  val route = get {
    complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, content))
  }

  implicit val system = ActorSystem(Behaviors.empty,"Server")

  val host = "0.0.0.0"
  val port = sys.env.getOrElse("PORT", "8080").toInt

  private val httpFuture: Future[Http.ServerBinding] = Http().newServerAt(host, port).bind(route)
}
