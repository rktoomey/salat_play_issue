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

    // in WHAT UNIVERSE does this log statement provoke a "recursive value u needs type" error?
//    log.info("%s".format(u.getClass.getName))

    val u_* = grater[User].asObject(dbo)
    u_* should be === u     // see?  you knew u wasn't a recursive value.  stop being so inconsistent!

  }

//  "UserDao crud operations should" should "work" in {

    // ARGH - what on EARTH is the Play compiler doing here and WHY ON EARTH does it swallow the real exception>
//    Compilation error (In /test/Tests.scala around line 37)
//    The file /test/Tests.scala could not be compiled. Error raised is : recursive value u needs type

//
//    com.mongodb.casbah.commons.conversions.scala.RegisterConversionHelpers()
//    com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers()
//
//    val user = User(email = "", password = "you2?")
//    val _id = UserDao.insert(user)
//    _id should be === Some(user.id)
//
//    UserDao.findOneByID(user.id) must be === Some(user)
//
//    UserDao.remove(user)
//    UserDao.findOneByID(user.id) must be === None
//  }
}