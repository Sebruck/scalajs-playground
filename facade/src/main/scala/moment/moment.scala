package moment

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace

@JSImport("moment", Namespace)
@js.native
object moment extends js.Object {
  val version: String = js.native
  def apply(): Date = js.native
}

@js.native
trait Date extends js.Object {
  def year(): Int = js.native
  def month(): Int = js.native
  def day(): Int = js.native
  def isBefore(date: Date): Boolean = js.native
}
