package org.aire.mutation

import scala.util.Random
import org.aire.core.Genetics
import org.aire.core.types.Mutator

trait Mutate {
  type Mutated[T] <: Mutator[T]
  def seed : Long
  implicit lazy val randomGenerator = {
    val r = new Random()
    r.setSeed(seed)
    r
  }
  def mutate[T](code: Seq[Seq[T]])(implicit mutator: T => Mutated[T]) : Seq[Seq[T]]
}