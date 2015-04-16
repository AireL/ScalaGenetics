package org.aire.mutation

import scala.util.Try
import scalaz._
import org.aire.core.Types._
import org.aire.core.Genetics

trait Mutation extends Mutator {
  self: Genetics =>
  implicit val mutationProbability : Double
}
