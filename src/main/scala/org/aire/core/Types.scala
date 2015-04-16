package org.aire.core

import scalaz._
import Scalaz._
import org.aire.core.types.Mutates
import org.aire.core.types.Crossover
import org.aire.utils.UtilityMethods._
import scala.util.Try
import scala.util.Random
import org.aire.core.types.Crossover.ops._

object Types {
  implicit val stringCrosssover : Crossover[String] = new Crossover[String] {
    def crossover(a : String, b : String)(implicit r: Random, crossover: Double) : String = a.zipWithIndex.map {
      case tup if r.nextDouble() > crossover => Try(b.charAt(tup._2)).getOrElse(tup._1)
      case tup => tup._1
    }.mkString
  }
  implicit val crossInt : Crossover[Int] = new Crossover[Int] {
    def crossover(a: Int, b: Int)(implicit r: Random, crossover: Double) : Int = Try {
      Integer.parseInt(a.toBinaryString @~@ b.toBinaryString)
    } getOrElse (Int.MaxValue)
  }
  implicit val mutInt : Mutates[Int] = new Mutates[Int] {
    def mutate(a : Int)(implicit r : Random, mutator : Double) : Int = Try {
      Integer.parseInt(binaryFlip(a.toBinaryString, mutator)(r))
    } getOrElse (Int.MaxValue)
  }
  implicit val mutLong : Mutates[Long] = new Mutates[Long] {
    def mutate(a : Long)(implicit r : Random, mutator : Double) : Long = Try {
      java.lang.Long.parseLong(binaryFlip(a.toBinaryString, mutator)(r))
    } getOrElse (Long.MaxValue)
  }
  implicit val stringMutation : Mutates[String] = new Mutates[String] {
    def mutate(a : String)(implicit r : Random, mutator : Double) : String = a.map {
      case cha if r.nextDouble() > mutator => r.nextPrintableChar()
      case cha => cha
    }.mkString
  }
  private def binaryFlip(s : String, mutationProbability : Double)(r : Random) : String = s.map[Char, String] {
    case flip if r.nextDouble() > mutationProbability => if (flip == '0') '1' else '0'
    case noflip                                       => noflip
  }
}