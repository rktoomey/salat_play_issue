package models

import com.mongodb.casbah.commons.Imports._
import com.novus.salat._
import play.Play
import com.mongodb.casbah.MongoConnection

object `package` {

  /**
    * Here is where we define the custom Play serialization context, including the Play classloader.
    */
  implicit val ctx = {
    val c = new Context {
      val name = Some("play-context")
    }

    c.registerClassLoader(Play.classloader)

    c
  }

  object DB {
    val connection = MongoConnection()("salat_play_db")
  }

}

