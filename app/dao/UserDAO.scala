package dao

import com.novus.salat._
import com.novus.salat.dao._
import com.mongodb.casbah.commons.Imports._
import com.novus.salat._

// the implicit ctx is defined in models package object
import models._

object UserDao extends SalatDAO[User, ObjectId](collection = DB.connection("users"))