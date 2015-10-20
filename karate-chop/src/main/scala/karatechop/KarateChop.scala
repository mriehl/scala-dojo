package karatechop

import scala.language.implicitConversions

case class KarateChop[T](values: TraversableOnce[T]) {

  def chop(value: T): Int = -1

}

object KarateChop {
  implicit def toKarateChop[T](values: TraversableOnce[T]): KarateChop[T] = KarateChop(values)
}
