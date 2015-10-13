sbtPlugin := true

version      := "0.6.5" // This is actually v0.6.3

scalaVersion := "2.10.6"

name := "sbt-native-packager"

organization := "com.typesafe.sbt"

scalacOptions in Compile += "-deprecation"

libraryDependencies += "org.apache.commons" % "commons-compress" % "1.4.1"

site.settings

com.typesafe.sbt.SbtSite.SiteKeys.siteMappings <+= baseDirectory map { dir =>
  val nojekyll = dir / "src" / "site" / ".nojekyll"
  nojekyll -> ".nojekyll"
}

site.sphinxSupport()

//ghpages.settings

//git.remoteRepo := "git@github.com:sbt/sbt-native-packager.git"

//publishTo := Some(Resolver.url("sbt-plugin-releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns))

publishMavenStyle := false // publish using Ivy style

scriptedSettings

scriptedLaunchOpts <+= version apply { v => "-Dproject.version="+v }


bintrayOrganization := Some("micronautics")
bintrayRepository := "sbt"

publishArtifact in Test := false

com.typesafe.sbt.SbtGit.versionWithGit
