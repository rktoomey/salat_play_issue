import play._
import play.test._

import models._

import org.scalatest._
import org.scalatest.junit._
import org.scalatest.matchers._

class BasicTests extends UnitFlatSpec with ShouldMatchers {
    
    "Instantiating a UserDao" should "work" in {
      val dao = UserDao
    }
}