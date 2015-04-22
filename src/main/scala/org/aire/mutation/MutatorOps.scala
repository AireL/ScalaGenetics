package org.aire.mutation

import org.aire.core.types.Crossover
import org.aire.core.types.Crossover.ops._
import shapeless._
import poly._
import org.aire.core.types.Mutates
import org.aire.core.types.Mutates.ops._
import scala.util.Random
import org.aire.core.types.GenericMutator

trait CrossoverOps extends MutatorOp {
  def crossoverProbability : Double
  def random : Random
  
  implicit object crossover extends Poly1 {
    implicit def caseCross[T] = at[Seq[GenericMutator[T, Crossover[T]]]](seq => (seq match {
      case Nil => Nil
      case nel => nel.zip((nel :+(nel.head)).drop(1))
    }).map {cross => cross._1.fromTypeClass.crossover(cross._1.id, cross._2.id)(random, crossoverProbability)})
  }
}

trait MutateOps extends MutatorOp {
  implicit object mutation extends Poly1 {
    implicit def caseMutation[T : Mutates](implicit mutator : Double, random : Random) = at[Seq[Seq[T]]](s => s.map(_.map(a => a @~>)))
  }
}