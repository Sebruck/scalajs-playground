package com.example

import customjs.Obj._
import moment.moment

import scala.scalajs.js.JSApp

object HelloNativeJs extends JSApp {
  override def main(): Unit = {
    println(bar(_.reverse, "abc"))
  }
}
