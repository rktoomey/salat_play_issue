import play._
import play.test._

// the implicit ctx is defined in models package object
import models._
import dao._

import com.novus.salat._
import com.novus.salat.dao._
import com.mongodb.casbah.commons.Imports._

import org.scalatest._
import org.scalatest.junit._
import org.scalatest.matchers._

class BasicTests extends UnitFlatSpec with ShouldMatchers {

  "Serializing an instance of User" should "work" in {

    com.mongodb.casbah.commons.conversions.scala.RegisterConversionHelpers()
    com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers()

    val u = User(email = "someone@nobody.org", password = "you2?")

    ctx.classLoaders.size should be === 2

    val _grater: Option[Grater[_]] = ctx.lookup("models.User")
    _grater should not be (None)

    val dbo = _grater.get.asInstanceOf[Grater[User]].asDBObject(u)
//    println("SERIALIZED: %s".format(u))

//    val u_* = grater[User].asObject(dbo)

//    u_* should be === u


  }

//    "Instantiating a UserDao" should "work" in {
//      val dao = UserDao
//    }
}