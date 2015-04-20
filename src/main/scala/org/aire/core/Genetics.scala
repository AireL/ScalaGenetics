package org.aire.core

import org.aire.utils.UtilityMethods._
import shapeless._
import poly._

trait Genetics[A] {
  
  def mutation : Poly
  def iterate(iterativeFunction : A => A) : Unit
  def fitness(value: A) : Double
  def success(value: A) : Boolean
  def maxRuns: Int = 200
  
  private def iterateWhile {
    
  }
}