package com.letsExploreZio.Scribbles

import zio.Console.printLine
import zio.{ZIO, ZIOAppDefault}

object MyScribbles extends ZIOAppDefault {
  val program = printLine("Welcome to your first ZIO app!")
  //val inerprogram = ZIO.unit
  val normalscalacode = println("Welcome to hackathon")
  val run = ZIO.unit


  //Typed blueprint
  //ZIO[R,E,A]
  //succeed with an A
  //faile with E - recoverable
  //fail with defect or throwable
  //  val program = ZIO[Any,Nothing,(Duration,Unit)]
  //  val program: ZIO[Any, Nothing, (Duration, Unit)] = Console.printLine("Ewlocome to first zio hackathon")
  //    .orDie
  //    .delay(1.second)
  //    .repeatN(10)
  //    .timed
  //    .debug("RESULT")
  //
  //  def flackyservice[A](ms: Int, value: A): ZIO[Any, Nothing, A] = {
  //    ZIO.succeed(value).delay(ms.millis)
  //  }
  //
  //  def flackservice[A](ms: Int, n: Int): ZIO[Any, AppError, Int] ={
  //for {
  //      _ <- ZIO.sleep(500.millis)
  //      int <- Random.nextIntBounded(10)
  //      _ <- ZIO.fail(s"I dont like $int").when(int % n == 0)
  //    } yield int
  //}.debug(s"Result $n")
  //
  //val run  = flackservice(7).retry(Schedule.recurs(4) && Schedule.exponential(500.millis)
  //.tapOutput(duration => ZIO.debug(s"Sleeping for $duration")))
  //  private val effect : ZIO[Any,Nothing,(Iterable[String],Iterable[Int])] = ZIO.partitionPar((1 <= to <= 10).toList)(_ => flackservice)
  //
  //  val example2 : ZIO[Any,Nothing,Double] =
  //    ZIO.fail("100")
  //    .orElseSucceed(10.5)
  //
  //  val run = flackyservice(ms=1500,value = 42).timeoutFail("Timeout!!!")(1.second)
  //
  //
  //
  //  private val failOOps : ZIO[Any,String,Nothing] =
  //
  //    failOOps.catchaAll {
  //      error => ZIO.succeed(error.length)
  //    }
  //
  //  //def timed[A](future)
  //  val run = program
  //  //override def run:IO[IOException,Unit]= {
  //
  //  //  printLine("Welcome to your first ZIO app!")
  // // }
}
