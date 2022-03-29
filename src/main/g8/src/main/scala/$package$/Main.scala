package $package$

import java.io.IOException

import zio.{ App, ExitCode, URIO, ZEnv, ZIO, Console }
import zio.Console.{ printLine, readLine }

object Main extends App:

  val app: ZIO[Console, IOException, Unit] =
    for
      _    <- printLine("What is your name?")
      name <- readLine
      out  <- printLine(s"Hello \$name!")
    yield out

  def run(args: List[String]): URIO[ZEnv, ExitCode] =
    app.exitCode
