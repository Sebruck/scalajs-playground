package com.example

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSImport

object HelloReactCounter extends JSApp {
  ReactInit

  override def main(): Unit = {
    val Counter = ReactComponentB[Unit]("Counter")
      .initialState(CounterState(0))
      .renderBackend[Backend]
      .build

    ReactDOM.render(Counter(), dom.document.getElementById("root"))
  }
}

case class CounterState(current: Int)

class Backend($: BackendScope[Unit, CounterState]) {

  private val add = (_: ReactEventI) =>
    $.modState(s => s.copy(current = s.current + 1))

  private val subtract = (_: ReactEventI) =>
    $.modState(s => s.copy(current = s.current - 1))

  def render(state: CounterState): ReactTagOf[html.Div] = <.div(
    <.h3("Simple REACT Counter"),
    <.div(state.current),
    <.button("-", ^.onClick ==> subtract),
    <.button("+", ^.onClick ==> add)
  )
}
