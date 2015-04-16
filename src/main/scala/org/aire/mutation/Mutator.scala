package org.aire.mutation

import scala.util.Random

trait Mutator {
  def seed : Long
  implicit lazy val randomGenerator = {
    val r = new Random()
    r.setSeed(seed)
    r
  }
}