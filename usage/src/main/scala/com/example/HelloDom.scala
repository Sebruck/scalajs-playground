package com.example

import scala.scalajs.js.JSApp
import org.scalajs.dom._

object HelloDom extends JSApp {
  def main(): Unit = {
    document.getElementById("root").textContent = "Hello Team Explorers"
  }
}
