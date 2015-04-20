package org.aire.mutation

import org.aire.core.types.Crossover
import org.aire.core.types.Crossover.ops._
import shapeless._
import poly._
import org.aire.core.types.Mutates
import org.aire.core.types.Mutates.ops._
import scala.util.Random

object MutatorOps {
  object crossover extends Poly1 {
    implicit def caseCross[T : Crossover](implicit crossover : Double, random : Random) = at[Seq[Seq[T]]](s => s.zip(Stream.continually(s.toStream).drop(1)
        .flatten.take(s.size)).map { sup => sup._1.zip(sup._2).map(tup => tup._1 @~@ tup._2)})
  }

  object mutation extends Poly1 {
    implicit def caseMutation[T : Mutates](implicit mutator : Double, random : Random) = at[Seq[Seq[T]]](s => s.map(_.map(a => a @~>)))
  }
}