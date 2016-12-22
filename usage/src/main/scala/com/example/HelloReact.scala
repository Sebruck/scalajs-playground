package com.example

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSImport

@JSImport("./react-init.js", JSImport.Namespace)
object ReactInit extends js.Object

object HelloReact extends JSApp {
  ReactInit

  override def main(): Unit = {

    val HelloMessage = ReactComponentB[String]("HelloMessage")
      .render($ => <.div("Hello ", $.props))
      .build

    ReactDOM.render(HelloMessage("Explorers"), dom.document.getElementById("root"))
  }
}
