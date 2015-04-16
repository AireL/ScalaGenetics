package org.aire.utils

import scalaz._
import Scalaz._

object UtilityMethods {
  implicit def tagUnwrap[A, B](a: A @@ B) : A = Tag.unwrap(a)
}