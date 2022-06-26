package $package$

import zio.{ZIOAppDefault, Task, Console}
import zio.Console.ConsoleLive

object Main extends ZIOAppDefault:

  def app(c: Console): Task[Unit] =
    for
      _    <- c.printLine("What is your name?")
      name <- c.readLine
      _    <- c.printLine(s"Hello \$name!")
    yield ()

  def run = app(ConsoleLive)
