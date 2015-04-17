package org.aire.core.types

import simulacrum._
import scala.util.Random

@typeclass trait Crossover[A] extends Mutator[A] {
  @op("@~@") def crossover(a: A, b: A)(implicit r: Random, crossover: Double) : A
}