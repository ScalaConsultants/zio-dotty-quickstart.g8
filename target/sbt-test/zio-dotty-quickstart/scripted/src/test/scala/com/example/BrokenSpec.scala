package com.example

import zio.test.Assertion._
import zio.test.junit.JUnitRunnableSpec
import zio.test.mock.MockConsole
import zio.test.{assertM, suite, testM}
import zio.console

object BrokenSpec extends JUnitRunnableSpec {

  def spec = suite("ZIOConsoleTest")(
    testM("expect call with input satisfying assertion") {
      val app = console.putStrLn("foo")
      val env = MockConsole.PutStrLn(equalTo("foo"))
      val out = app.provideLayer(env)
      assertM(out)(isUnit)
    }
  )
}
