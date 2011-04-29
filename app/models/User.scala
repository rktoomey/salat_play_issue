package models

import com.novus.salat._
import com.novus.salat.dao._
import com.novus.salat.global._

import com.mongodb.casbah.Imports._

import play._

object DB {
  val connection = MongoConnection()("salat_play_db")
}

case class User(
  _id: ObjectId = new ObjectId, 
  email:String, 
  password:String
  )


object UserDao extends SalatDAO[User, ObjectId] {
  //comment/uncomment the next line to get a sense
  //of what happens when you include the Play classloader
  //ctx.registerClassLoader(Play.classloader)  
  val _grater = grater[User]
  val collection = DB.connection("users")
}