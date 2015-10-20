package transitive

import org.specs2.mutable.Specification

class DependenciesSpec extends Specification {

  "Transitive dependencies" should {

    "not expand when there is nothing to expand" in {
      val dependencies = Dependencies(
        "A" → Set("B", "C", "D"),
        "E" → Set("F", "G", "H")
      )

      dependencies.expand must beEqualTo(dependencies)
    }

    "expand a simple dependency" in {
      val dependencies = Dependencies(
        "A" → Set("B"),
        "B" → Set("C")
      )

      dependencies.expand must beEqualTo(Dependencies(
        "A" → Set("B", "C"),
        "B" → Set("C")
      ))
    }

    "expand a simple rightmost dependency" in {
      val dependencies = Dependencies(
        "A" → Set("B", "C", "D"),
        "D" → Set("Y")
      )

      dependencies.expand must beEqualTo(Dependencies(
        "A" → Set("B", "C", "D", "Y"),
        "D" → Set("Y")
      ))
    }

    "expand a simple inner dependency" in {
      val dependencies = Dependencies(
        "A" → Set("B", "C", "D"),
        "C" → Set("Y")
      )

      dependencies.expand must beEqualTo(Dependencies(
        "A" → Set("B", "C", "Y", "D"),
        "D" → Set("Y")
      ))
    }
  }
}