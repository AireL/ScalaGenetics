package org.aire.core.types

trait GenericMutator[T, TC <: Mutator[T]] {
  def fromTypeClass : TC
  def id : T
}