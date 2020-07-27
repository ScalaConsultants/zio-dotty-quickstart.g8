## zio-dotty-quickstart.g8

A [Giter8][g8] template for a basic Dotty application build using [ZIO]

### Setting up the project

```shell script
sbt new ScalaConsultants/zio-dotty-quickstart.g8
```

### Run tests

```shell script
cd <project-name>
sbt test
```

### Known issues

* There is [error in zio-test when testing console interactions](https://github.com/zio/zio/issues/3995):
```scala
Type Mismatch Error env zio.test.mock.Expectation[zio.console.Console]
```

Template license
----------------
Written in 2020 by [Scalac Sp. z o.o.][scalac].

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
[scalac]: https://scalac.io/
[zio]: https://zio.dev/
[sbt-scalafmt]: https://github.com/scalameta/sbt-scalafmt
