import bintray.Keys._

sbtPlugin := true

version      := "0.6.3"

scalaVersion := "2.10.5"

name := "sbt-native-packager"

organization := "com.micronautics.sbt"

scalacOptions in Compile += "-deprecation"

libraryDependencies += "org.apache.commons" % "commons-compress" % "1.4.1"

site.settings

com.typesafe.sbt.SbtSite.SiteKeys.siteMappings <+= (baseDirectory) map { dir => 
  val nojekyll = dir / "src" / "site" / ".nojekyll"
  nojekyll -> ".nojekyll"
}

site.sphinxSupport()

//ghpages.settings

//git.remoteRepo := "git@github.com:sbt/sbt-native-packager.git"

//publishTo := Some(Resolver.url("sbt-plugin-releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns))

//publishMavenStyle := false

scriptedSettings

scriptedLaunchOpts <+= version apply { v => "-Dproject.version="+v }


bintrayPublishSettings
bintrayOrganization in bintray := Some("micronautics")
repository in bintray := "scala"

publishArtifact in Test := false

