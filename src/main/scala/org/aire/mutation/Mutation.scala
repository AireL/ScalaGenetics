package org.aire.mutation

import scala.util.Try
import scalaz._
import org.aire.core.Types._

trait Mutation extends Mutator {
  implicit val mutationProbability : Double
}
