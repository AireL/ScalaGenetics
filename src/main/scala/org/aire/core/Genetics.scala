package org.aire.core

trait Genetics[A] {
  def iterate(iterativeFunction : A => A) : Unit
  def fitness(value: A) : Double
  def success(value: A) : Boolean
  
  private def iterateWhile {
    
  }
}