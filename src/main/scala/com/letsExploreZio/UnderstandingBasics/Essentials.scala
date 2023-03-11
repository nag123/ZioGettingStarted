package com.letsExploreZio.UnderstandingBasics

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}
object Essentials {

  //values
  //Imutable or constant value
  val aBoolean : Boolean  = true
  //Expressions
  val aExpression = if(2 > 3)"bigger" else "smaller"

  //instruction vs expression
  val theUnit = println("Hello, Scala!!!")  //unit -> void in java.

  //OOP
  class Animal
  class Cat extends Animal
  trait Carnivore {
    def eat(animal : Animal) : Unit
  }

  //A class can extend a single other class but we can mix in (extends) 0 or more traits
  class Crocodile extends Animal with Carnivore{
    override def eat(animal: Animal): Unit = println("Crunch")
  }

  //Singleton Object
  object SingleTon //singleton pattern in one line

  //Companions
  object Carnivore //Companion object of class/trait carnivore

  //generics
  class MyList[A] //Reuse the datatype of various type

  //Method notation - infix
  val three = 1+2
  val anotherthree = 1.+(2)
  //we also have prefix and postfix

  //Functional Programming
  val incrementer : Int => Int = x => x+1
  val incremented = incrementer(45) //46

  //HOF - map, flatmap , filter
  val processedList = List(1,2,3).map(incrementer)
  val aLongerList = List(2,3,4).flatMap(x => List(x,x+1))

  //For comprehension -> contains all 3 nos and 3 chrs //(1,a)(2,b)(3,c)
  val checkerboard = List(1,2,3).flatMap(n => List('a','b','c').map(c => (n,c))) //Tuple of cartisian product of all the numbers

  val checkerboardforcomp = for {
    n <- List(1,2,3)
    c <- List('a','b','c')
  } yield (n,c)

  //Options and Try
  val anOption = Option(3) //Some(3) sometimes it might also return null value so for a safer side we are declaring Some(3) in option
  val doubledOption = anOption.map(_ * 2)
  val anAttempt = Try(42)
  val modifiedAttempt = anAttempt.map(_ + 10)

  //Pattern Matching
  val anunKnown : Any = 45
  val ordinal = anunKnown match {
    case 1 => "One"
    case 2 => "Two"
    case _ => "Unknown"
  }

  val optionDescriptor : String = anOption match {
    case Some(value) => s"The option is not empty , it have some value such as :::: $value in it"
    case None => s"The option is empty"
  }

  //Futures - DS whose value is computed at future point
  //Future needs execution context

  //upto scaa 2.12 -
  //import scala.concurrent.ExecutionContext.Implicits.global
  implicit val ec : ExecutionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(8))
  val aFuture = Future{42}

  //wait for completion - Async
  aFuture.onComplete{
    case Success(value) => println(s"The asnc of value passed is :::: $value")
    case Failure(exception) => println(s"The meaning of value failed is ::: $exception")
  }
  //Map a future
  val anotherFuture = aFuture.map(_+ 1) //This contain Future(43) when it completes

  //Partial functions
  //Difference between normal and partialfunction -> Partialfunction do not accept any int , it receives argument that receives some patterns
  //based on pattern matching
  val partialFunc : PartialFunction[Int,Int] = {
    case 1 => 43
    case 7 => 56
    case 99 => 100
  }
  //the above is equal to match case

  //Advanced Stuffs
  //Traits - trait itself will have generic type arguments

  trait HigherKindedType[F[_]]
  trait SequenceChecker[F[_]]{
    def isSequential : Boolean
  }
  /*We are using  any datatype in the trait so we defined a generic type F[_] , F can be any , _ can be any */
  val listChecker = new SequenceChecker[List]{
    override def isSequential = true
  }

  val arrayChecker = new SequenceChecker[Array]{
    override def isSequential: Boolean = false
  }

  def SeqChecker = new SequenceChecker[Seq] {
    override def isSequential: Boolean = true
  }

  def main(args: Array[String]): Unit = {

  }
}
