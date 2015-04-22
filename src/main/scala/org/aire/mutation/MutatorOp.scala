package org.aire.mutation

import shapeless._
import poly._
import scala.util.Random

trait MutatorOp  {
  trait MutatorMagnet {
    type Result[_]
    def apply[K[_]]()(implicit ev: K[_] =:= Result[_]): Result[_]
  }
}