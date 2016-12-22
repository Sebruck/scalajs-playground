import sbt.Keys._

scalaVersion in ThisBuild := "2.12.1"

val `scalajs-test` =
  project.in(file("."))
    .aggregate(usage, facade)

lazy val usage =
  project.in(file("usage"))
    .enablePlugins(ScalaJSBundlerPlugin)
    .settings(
      libraryDependencies ++= Seq(
        "com.github.japgolly.scalajs-react" %%% "core" % "0.11.3",
        "org.scala-js" %%% "scalajs-dom" % "0.9.0",
        "com.lihaoyi" %%% "scalatags" % "0.6.2",
        "com.lihaoyi" %%% "scalarx" % "0.3.2"
      )
    )
    .dependsOn(facade)

lazy val facade =
  project.in(file("facade"))
    .enablePlugins(ScalaJSBundlerPlugin)
    .settings(
      npmDependencies in Compile ++= Seq(
        "node-uuid" -> "1.4.7",
        "moment" -> "2.17.1",
        "react" -> "15.3.2",
        "react-dom" -> "15.3.2"
      )
    )
