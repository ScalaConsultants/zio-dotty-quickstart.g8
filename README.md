[![Scala CI](https://github.com/ScalaConsultants/zio-dotty-quickstart.g8/workflows/Scala%20CI/badge.svg?branch=master)](https://github.com/ScalaConsultants/zio-dotty-quickstart.g8/actions?query=workflow%3A%22Scala+CI%22+branch%3Amaster)
[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-brightgreen.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)

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
Type Mismatch Error env zio.test.mock.Expectation[zio.Console.Console]
```

Template license
----------------
Written in 2022 by [Scalac Sp. z o.o.](https://scalac.io/?utm_source=scalac_github&utm_campaign=scalac1&utm_medium=web)

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
[scalac]: https://scalac.io/
[zio]: https://zio.dev/
