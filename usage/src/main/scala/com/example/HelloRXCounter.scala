package com.example

import com.example.rxdom.RxDomHelper._
import org.scalajs.dom._
import rx._

import scala.scalajs.js.JSApp
import scalatags.JsDom.all._

object HelloRXCounter extends JSApp {
  implicit val owner = Ctx.Owner.safe()

  override def main(): Unit = {
    val root = document.getElementById("root")
    val counter = Var(0)
    val counterDiv = Rx {
      div(counter())
    }

    val html = div(
      h3("Scala RX Counter"),
      counterDiv,
      button("+", onclick := { () => counter() = counter.now + 1 }),
      button("-", onclick := { () => counter() = counter.now - 1 })
    )

    root.innerHTML = ""
    root.appendChild(html.render)
  }
}

