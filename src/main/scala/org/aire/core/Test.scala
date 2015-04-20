package org.aire.core

import org.aire.mutation.MutatorOps._

class Test extends Genetics[Int] {
  def mutation = (crossover andThen mutation)
  def iterate(iterativeFunction : Int => Int) : Unit = ???
  def fitness(value: Int) : Double = ???
  def success(value: Int) : Boolean = ???
}