# Testing locally

```shell script
sbt g8Test
```
generates sample project in
```shell script
cd target/sbt-test/zio-dotty-quickstart/scripted
```

Now you can check whether
tests pass:
```shell script
sbt clean test
```

files are properly formatted:
```shell script
sbt scalafmtCheck
```
etc