package org.aire.core

import org.aire.utils.UtilityMethods._
import org.aire.mutation.Mutate

trait Genetics[A] {
  def diversity : Mutate
  
  def iterate(iterativeFunction : A => A) : Unit
  def fitness(value: A) : Double
  def success(value: A) : Boolean
  def maxRuns: Int = 200
  
  private def iterateWhile {
    
  }
}