package customjs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("./foo.js", JSImport.Namespace)
@js.native
object Obj extends js.Object {
  def bar(i: js.Function1[String, String], str: String): String = js.native
}
