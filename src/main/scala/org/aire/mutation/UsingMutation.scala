package org.aire.mutation

import scala.util.Try
import scalaz._
import org.aire.core.Types._
import org.aire.core.Genetics
import org.aire.core.types.Mutates
import org.aire.core.types.Mutates.ops._

trait UsingMutation extends Mutate {
  self: Genetics[_] =>
  override type Mutated[T] = Mutates[T]
  abstract override def mutate[T](code: Seq[Seq[T]])(implicit mutator: T => Mutated[T]) : Seq[Seq[T]] = {
    super.mutate(code.map(_.map(a => a.mutate(a))))
  }
  implicit val mutationProbability : Double

}
