name := "leetcode"
organization := "io.github.leibnizhu"
version := "1.0"
scalaVersion := "2.13.8"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.12"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % "test"
libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.12" % "test"
libraryDependencies += "org.scalatest" %% "scalatest-flatspec" % "3.2.12" % "test"
ensimeIgnoreScalaMismatch := true

scalacOptions ++= Seq("-deprecation","-encoding", "utf-8",  "-explaintypes", "-feature")
// testOptions in Test += Tests.Argument("-oD")