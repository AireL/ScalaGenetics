package org.aire.core

import scala.util.Random
import scala.util.Try
import org.aire.mutation.Mutator

trait UsingCrossover extends Mutator {
  self: Genetics =>
  implicit val crossoverProbability : Double
}