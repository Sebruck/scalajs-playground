package com.example.rxdom

import org.scalajs.dom
import rx._

import scalatags.JsDom.all._

object RxDomHelper {
  implicit def rxFrag[T](r: Rx[T])(implicit ev: T => Frag, ctx: Ctx.Owner): Frag = {
    def rSafe: dom.Node = div(r.now).render

    var last = rSafe
    r.triggerLater {
      val newLast = rSafe
      last.parentNode.replaceChild(newLast, last)
      last = newLast
    }
    last
  }
}
