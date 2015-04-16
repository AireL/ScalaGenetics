package org.aire.core.types

import simulacrum._
import scala.util.Random

@typeclass trait Mutates[A] {
  @op("@~>") def mutate(a: A)(implicit r: Random, mutator: Double) : A
}