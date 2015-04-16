package org.aire.utils

import scalaz._
import Scalaz._

object UtilityMethods {
  implicit def tagUnwrap[A, B](a: A @@ B) : A = Tag.unwrap(a)
  implicit class GenericOps[A](val a: A) extends AnyVal {
    def as[B] : B = a.asInstanceOf[B]
    def asOpt[B] : Option[B] = try { Some(a.as[B]) } catch { case ex: ClassCastException => None }
  }
}