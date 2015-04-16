package org.aire.mutation

import scala.util.Random
import org.aire.core.Genetics

trait Mutator {
  self: Genetics =>
  def seed : Long
  implicit lazy val randomGenerator = {
    val r = new Random()
    r.setSeed(seed)
    r
  }
}