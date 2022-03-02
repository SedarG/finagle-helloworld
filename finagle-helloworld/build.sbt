ThisBuild / version := "0.0.1"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "com.twitter"


val scalaTest = "org.scalatest" %% "scalatest" % "3.2.7"
val finagleHttp = "com.twitter" %% "finagle-http" % "22.2.0"
val finagleCore = "com.twitter" %% "finagle-core" % "22.2.0"
val finagleThrift = "com.twitter" %% "finagle-thrift" % "22.2.0"
val finagleThriftMux = "com.twitter" %% "finagle-thriftmux" % "22.2.0"
val utilCore = "com.twitter" %% "util-core" % "22.2.0"
val scroogeCore = "com.twitter" %% "scrooge-core" % "22.1.0"
val apacheThrift = "org.apache.thrift" % "libthrift" % "0.10.0"

lazy val root = (project in file("."))
  .aggregate(server, client, thrift)

lazy val server = (project in file("server"))
  .dependsOn(thrift)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "HelloFinagleServer",
    libraryDependencies ++= Seq(finagleHttp, finagleThriftMux, scroogeCore, utilCore),
    libraryDependencies += scalaTest % Test,
  )

lazy val client = (project in file("client"))
  .dependsOn(thrift)
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "HelloFinagleClient",
    libraryDependencies ++= Seq(finagleThriftMux, scroogeCore, utilCore),
    libraryDependencies += scalaTest % Test,
  )

lazy val thrift = (project in file("thrift"))
  .settings(
    name := "Thrift",
    Compile / scroogeThriftSourceFolder := file("thrift/main"),
    libraryDependencies ++= Seq(apacheThrift, scroogeCore, finagleThrift),
)
