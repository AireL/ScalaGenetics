name := "GeneticScala"
    
version := "1.0"
    
scalaVersion := "2.11.5"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.1"

libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.3.0"