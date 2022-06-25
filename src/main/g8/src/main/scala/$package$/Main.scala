package $package$

import zio.{ ZIOAppDefault, Task, ZIO, Console }
import zio.Console.{ ConsoleLive, printLine, readLine }

object Main extends ZIOAppDefault:

  def app(c : Console): Task[Unit] =
    for
      _    <- printLine("What is your name?")
      name <- readLine
      out  <- printLine(s"Hello $name!")
    yield out

  def run = app(ConsoleLive)
