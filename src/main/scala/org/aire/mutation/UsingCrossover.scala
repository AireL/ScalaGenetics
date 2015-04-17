package org.aire.core

import scala.util.Random
import scala.util.Try
import org.aire.core.types.Crossover
import org.aire.mutation.Mutate
import org.aire.core.types.Crossover.ops._

trait UsingCrossover extends Mutate {
  implicit val crossoverProbability : Double
  override type Mutated[T] = Crossover[T]
  abstract override def mutate[T](code : Seq[Seq[T]])(implicit mutator : T => Mutated[T]) : Seq[Seq[T]] =
    super.mutate(code.zip(Stream.continually(code.toStream).drop(1).flatten.take(code.size)).map { tup =>
      tup._1.zip(tup._2).map(t => t._1.crossover(t._1, t._2))
    })
}