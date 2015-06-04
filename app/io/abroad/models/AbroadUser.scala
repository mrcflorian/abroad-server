package io.abroad.models

import play.api.libs.json._

/**
 * Created by Florian on 6/3/15.
 */
/*
import java.sql.Date
import play.api.db._
import play.api.Play.current
import org.scalaquery.ql._
import org.scalaquery.ql.TypeMapper._
import org.scalaquery.ql.extended.{ExtendedTable => Table}
import org.scalaquery.ql.extended.H2Driver.Implicit._

import org.scalaquery.session._

object AbroadUser extends Table[(Long, String, String, String, String, String, String, String, String, String, String)]("users") {

  lazy val database = Database.forDataSource(DB.getDataSource())

  def userID = column[Long]("user_id", O PrimaryKey, O AutoInc)
  def facebookID = column[String]("facebook_id")
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def email = column[String]("email")
  def latitude = column[String]("latitude")
  def longitude = column[String]("longitude")
  def nationality = column[String]("nationality")
  def birthday = column[String]("birthday")
  def signUpDate = column[String]("sign_up_date")
  def signUpLocation = column[String]("sign_up_location")

  def * = userID ~ facebookID ~ firstName ~ lastName ~ email ~ latitude ~ longitude ~ nationality ~ birthday ~ signUpDate ~ signUpLocation

  def findAll = database.withSession { implicit db:Session =>
    (for(t <- this) yield t.userID ~ t.firstName).list
  }
}
*/

case class AbroadUser(userID: Long, email: String, firstName: String, profilePicture: String, latitude: String, longitude: String)

object AbroadUser {

  implicit object UserFormat extends Format[AbroadUser] {
    // convert from Tweet object to JSON (serializing to JSON)
    def writes(user: AbroadUser): JsValue = {
      val statusSeq = Seq(
        "user_id" -> JsString(user.userID.toString),
        "email" -> JsString(user.email),
        "firstname" -> JsString(user.firstName),
        "latitude" -> JsString(user.latitude),
        "longitude" -> JsString(user.longitude),
        "profile_picture" -> JsString(user.profilePicture)
      )
      JsObject(statusSeq)
    }
    // convert from JSON string to a Status object (de-serializing from JSON)
    def reads(json: JsValue): JsResult[AbroadUser] = {
      JsSuccess(AbroadUser(0, "", "", "", "", ""))
    }
  }
}