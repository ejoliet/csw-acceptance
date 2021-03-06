import sbt._

object Libs {
  val ScalaVersion = "2.12.4"

  val `scalatest`                = "org.scalatest"        %% "scalatest"                % "3.0.5" //Apache License 2.0
  val `junit`                    = "junit"                % "junit"                     % "4.12" //Eclipse Public License 1.0
  val `junit-interface`          = "com.novocode"         % "junit-interface"           % "0.11" //BSD 2-clause "Simplified" License
  val `mockito-core`             = "org.mockito"          % "mockito-core"              % "2.15.0" //MIT License
  val `scalatest-embedded-kafka` = "net.manub"            %% "scalatest-embedded-kafka" % "1.0.0"
  val `embedded-redis`           = "com.github.sebruck"   %% "scalatest-embedded-redis" % "0.3.0"
  val `gson`                     = "com.google.code.gson" % "gson"                      % "2.8.2" //Apache 2.0
  val `pegdown`                  = "org.pegdown"    	  %  "pegdown"     		% "1.6.0"  
}

object CSW {
  val Version: String = {
    val env = sys.env ++ sys.props
    env.get("BUILD_ENV") match {
      case Some("PROD") ⇒ env.getOrElse("RELEASE_VERSION", "")
      case Some("DEV")  ⇒ env.getOrElse("DEV_VERSION", "0.4.0")
      // FIXME: below case will run acceptance tests with the Dev Version if BUILD_ENV=PROD is not set in release pipeline/machine
      case _ ⇒ env.getOrElse("DEV_VERSION", "0.4.0")
    }
  }

  val `csw-location`       = "org.tmt" %% "csw-location" % Version
  val `csw-location-tests` = "org.tmt" %% "csw-location" % Version classifier "tests"

  val `csw-config-server`       = "org.tmt" %% "csw-config-server" % Version
  val `csw-config-server-tests` = "org.tmt" %% "csw-config-server" % Version classifier "tests"

  val `csw-config-api`       = "org.tmt" %% "csw-config-api" % Version
  val `csw-config-api-tests` = "org.tmt" %% "csw-config-api" % Version classifier "tests"

  val `csw-config-client`       = "org.tmt" %% "csw-config-client" % Version
  val `csw-config-client-tests` = "org.tmt" %% "csw-config-client" % Version classifier "tests"

  val `csw-config-client-cli`       = "org.tmt" %% "csw-config-client-cli" % Version
  val `csw-config-client-cli-tests` = "org.tmt" %% "csw-config-client-cli" % Version classifier "tests"

  val `csw-logging`       = "org.tmt" %% "csw-logging" % Version
  val `csw-logging-tests` = "org.tmt" %% "csw-logging" % Version classifier "tests"

  val `csw-cluster-seed`       = "org.tmt" %% "csw-cluster-seed" % Version
  val `csw-cluster-seed-tests` = "org.tmt" %% "csw-cluster-seed" % Version classifier "tests"

  val `csw-commons`       = "org.tmt" %% "csw-commons" % Version
  val `csw-commons-tests` = "org.tmt" %% "csw-commons" % Version classifier "tests"

  val `csw-framework`       = "org.tmt" %% "csw-framework" % Version
  val `csw-framework-tests` = "org.tmt" %% "csw-framework" % Version classifier "tests"

  val `csw-command`       = "org.tmt" %% "csw-command" % Version
  val `csw-command-tests` = "org.tmt" %% "csw-command" % Version classifier "tests"

  val `csw-messages`       = "org.tmt" %% "csw-messages" % Version
  val `csw-messages-tests` = "org.tmt" %% "csw-messages" % Version classifier "tests"

  val `csw-location-agent`       = "org.tmt" %% "csw-location-agent" % Version
  val `csw-location-agent-tests` = "org.tmt" %% "csw-location-agent" % Version classifier "tests"
}

object Akka {
  val Version                   = "2.5.8" //all akka is Apache License 2.0
  val `akka-stream-testkit`     = "com.typesafe.akka" %% "akka-stream-testkit" % Version
  val `akka-typed-testkit`      = "com.typesafe.akka" %% "akka-typed-testkit" % Version
  val `akka-multi-node-testkit` = "com.typesafe.akka" %% "akka-multi-node-testkit" % Version
}

object AkkaHttp {
  val Version             = "10.0.10"
  val `akka-http-testkit` = "com.typesafe.akka" %% "akka-http-testkit" % Version //ApacheV2
}
