scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked",
  "-explain",
  "-explain-types"
)

scalaVersion := dottyLatestNightlyBuild.get

val zioVersion = "1.0.0-RC21-2"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio"             % zioVersion,
  "dev.zio" %% "zio-test"        % zioVersion % Test,
  "dev.zio" %% "zio-test-sbt"    % zioVersion % Test,
  "dev.zio" %% "zio-test-junit"   % zioVersion % Test,
  "dev.zio" %% "zio-test-magnolia" % zioVersion % Test
)

libraryDependencies := libraryDependencies.value.map(_.withDottyCompat(scalaVersion.value))

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")