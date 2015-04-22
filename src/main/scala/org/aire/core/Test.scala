package org.aire.core

import org.aire.mutation.MutateOps
import org.aire.mutation.CrossoverOps
import shapeless.Poly
import scala.util.Random

class Test extends Genetics[Int] with CrossoverOps with MutateOps {
  def iterate[K](implicit values : K) : Int = 1
  def fitness(value: Int) : Double = 0.1
  def success(value: Double) : Boolean = true
  def crossoverProbability : Double = 0.1
  def random : Random = ???

  def mutate = crossover andThen mutation
}