# Testing locally

* using Giter8

```shell script
g8 file://zio-dotty-quickstart.g8/ --name=foo --force
cd foo
sbt clean test
```

* using SBT

This way is not ideal (e.g. no complains on unescaped $)

```shell script
sbt g8Test
cd target/sbt-test/zio-dotty-quickstart/scripted
sbt clean test
```
