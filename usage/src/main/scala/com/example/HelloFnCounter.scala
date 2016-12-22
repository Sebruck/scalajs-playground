package com.example

import org.scalajs.dom._

import scala.scalajs.js.JSApp
import scalatags.JsDom.all._

trait Action
case object Add extends Action
case object Sub extends Action

case class State(i: Int)

object Counter {
  def reduce(s: State, a: Action): State = a match {
    case Add => State(s.i + 1)
    case Sub => State(s.i - 1)
  }

  def render(s: State, dispatch: Action => Unit) = {
    div(
      h3("Scala Tags Counter"),
      div(s.i),
      button("+", onclick := { () => dispatch(Add) }),
      button("-", onclick := { () => dispatch(Sub) })
    )
  }
}

object HelloFnCounter extends JSApp {
  override def main(): Unit = {
    val root = document.getElementById("root")
    var initialState = State(0)

    def cycle(s: State): Unit = {
      def dispatch(a: Action) = {
        cycle(Counter.reduce(s, a))
      }
      root.innerHTML = ""
      root.appendChild(Counter.render(s, dispatch).render)
    }

    cycle(initialState)
  }
}
