package com.twitter.pixie.hello

import com.twitter.finagle.Service
import com.twitter.util.Await
import com.twitter.pixie.hello.thriftscala._
import com.twitter.finagle.ThriftMux
import com.twitter.util.Future
import java.net.InetSocketAddress
import com.twitter.pixie.hello.thriftscala.HelloWorldService
import java.util.concurrent.atomic.AtomicBoolean
import com.twitter.conversions.DurationOps._

object Server extends App {
  implicit val timer = new com.twitter.util.JavaTimer()
  val methodPerEndpoint: HelloWorldService.MethodPerEndpoint = 
    ThriftMux.client.build[HelloWorldService.MethodPerEndpoint](":9992")

  val done = new AtomicBoolean(false)
  def callServer(): Future[Unit] = {
    methodPerEndpoint.greetings("Ding!").flatMap { greetings => 
      println(greetings)
      Future.sleep(3.seconds)
    }
  }

  def loop() : Future[Unit] = {
    if (done.get) {
      Future.Done
    } else {
      callServer().before {
        loop()
      }
    }
  }
  Await.ready(loop)
}
