package com.twitter.pixie.hello

import com.twitter.finagle.Http
import com.twitter.finagle.Service
import com.twitter.finagle.http
import com.twitter.util.Await
import com.twitter.util.Future
import com.twitter.pixie.hello.thriftscala._
import com.twitter.finagle.ThriftMux
import com.twitter.util.Future
import java.net.InetSocketAddress

object Server extends App {
  val thriftmuxService = ThriftMux.server.serveIface(new InetSocketAddress(9992),
    new HelloWorldServerImpl())

  Await.ready(thriftmuxService)
}
