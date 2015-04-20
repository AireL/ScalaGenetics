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
    implicit def caseCross[T : Crossover](implicit crossover : Double, random : Random) = at[(Seq[T], Seq[T])](s => s._1.zip(s._2).map(tup => tup._1 @~@ tup._2))
  }

  object mutation extends Poly1 {
    implicit def caseMutation[T : Mutates](implicit mutator : Double, random : Random) = at[Seq[T]](s => s.map(a => a @~>))
  }
}