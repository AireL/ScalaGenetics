package org.aire.core

import org.aire.utils.UtilityMethods._
import shapeless._
import poly._
import scala.annotation.tailrec
import scalaz._, Scalaz._
import shapeless.ops.hlist.Mapper._
import org.aire.mutation.MutatorOp

trait Genetics[A] {
  self: MutatorOp =>
  def mutation : Poly1
  def iterate[K](implicit values : K) : A
  def fitness(value: A) : Double
  def success(value: Double) : Boolean
  def maxRuns: Int = 200
  
  def ify[T, B, K <: HList](func: T => Boolean)(succ: => B)(implicit values : T :: K, conv: T => MutatorMagnet) : (Option[B], K) = {
    (func(values.head).option(succ), values.tail)
  }
}