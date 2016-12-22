package com.example

import org.scalajs.dom._

import scala.scalajs.js.JSApp
import scalatags.JsDom.all._

object HelloDomCounter extends JSApp {
  override def main(): Unit = {
    val root = document.getElementById("root")

    def counter(i: Int): Unit = {
      val c = div(
        h3("Scala Tags Counter"),
        div(i),
        button("+", onclick := { () => counter(i + 1) }),
        button("-", onclick := { () => counter(i - 1) })
      )

      root.innerHTML = ""
      root.appendChild(c.render)
    }

    counter(0)
  }
}
