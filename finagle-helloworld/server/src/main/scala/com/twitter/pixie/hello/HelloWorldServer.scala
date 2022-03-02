package com.twitter.pixie.hello

import com.twitter.pixie.hello.thriftscala.HelloWorldService
import com.twitter.finagle.Service
import com.twitter.finagle.ThriftMux
import java.net.InetSocketAddress
import com.twitter.util.Future


class HelloWorldServerImpl extends HelloWorldService.MethodPerEndpoint {
  def greetings(name: String): Future[String] = {
    Future.value(s"Hello $name")
  }
}
