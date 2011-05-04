package models



import com.mongodb.casbah.Imports._
import com.novus.salat.Context
import play.Play



case class User(_id: ObjectId = new ObjectId,
                 email: String,
                 password: String)


