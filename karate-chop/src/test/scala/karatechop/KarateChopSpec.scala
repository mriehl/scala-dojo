package karatechop
import KarateChop._

import org.specs2.mutable.Specification

class KarateChopSpec extends Specification {

  "A test" should {

    "not find element in empty seq" in {
        Seq.empty chop 3 must beEqualTo(-1)
    }

    "not find element in single element seq when element is not inside it" in {
        Seq(1) chop 3 must beEqualTo(-1)
    }

    "find element in single element seq when element is inside it" in {
      Seq(1) chop 1 must beEqualTo(0)
    }

    "not find element in seq when element is not inside it" in {
      Seq(1, 3, 5) chop 0 must beEqualTo(-1)
    }

    "find element in seq when element is head" in {
      Seq(1, 3, 5) chop 1 must beEqualTo(0)
    }

    "find element in seq when element is inbetween" in {
      Seq(1, 3, 5) chop 3 must beEqualTo(1)
    }

    "find element in seq when element is tail" in {
      Seq(1, 3, 5) chop 5 must beEqualTo(2)
    }
  }
}