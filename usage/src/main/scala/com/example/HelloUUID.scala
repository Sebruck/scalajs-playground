package com.example

import uuid.uuid

import scala.scalajs.js.JSApp

object HelloUUID extends JSApp {
  override def main(): Unit = {
    println("Hello " + uuid.v4())
  }
}

