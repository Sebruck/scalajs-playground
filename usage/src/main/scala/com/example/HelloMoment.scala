package com.example

import moment.moment

import scala.scalajs.js.JSApp

object HelloMoment extends JSApp {
  override def main(): Unit = {
    println(moment().year())
  }
}
