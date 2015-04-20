name := "GeneticScala"
    
version := "1.0"
    
scalaVersion := "2.11.6"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.2.0-RC4",
  "org.scalaz" %% "scalaz-core" % "7.1.1",
  "com.github.mpilquist" %% "simulacrum" % "0.3.0"
)