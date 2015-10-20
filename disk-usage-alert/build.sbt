name := "disk-usage-alert"

scalaVersion := "2.11.4"

version := "0.1"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.3" % "test")
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")
