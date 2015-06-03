package controllers

import anorm._
import java.net.URLDecoder

import io.abroad.models.{AbroadUser, AbroadStatus}
import play.api.db._
import play.api.Play.current

/**
 * Created by Florian on 6/3/15.
 */

object AbroadDatabaseController {

  def updateUser(email: String, firstName: String, facebook: String): AbroadUser = {
    val decodedEmail = URLDecoder.decode(email.replace("+", "%2B"), "UTF-8").replace("%2B", "+")
    val decodedFirstName = URLDecoder.decode(firstName.replace("+", "%2B"), "UTF-8").replace("%2B", "+")
    val decodedFacebook = URLDecoder.decode(facebook.replace("+", "%2B"), "UTF-8").replace("%2B", "+")

    val query = "select * from users where email='" + email + "'"
    val user = runSelectUserQuery(query)
    if (user.length > 0) {

    } else {
      runUpdateQuery("insert into users values(null, '" + decodedFacebook + "', '" + decodedFirstName + "', 'lastName', '" + decodedEmail + "', 'lat', 'long', 'nationality', 'birthday', 'sign_up_date', 'sign_up_location')"
      )
    }
    AbroadDatabaseController.getUser(email)
  }

  def runSelectUserQuery(query: String): List[(String, String)] =
    DB.withConnection { implicit c =>
      SQL(query)().map(row =>
        row[String]("facebook_id") -> row[String]("firstname")
      ).toList
    }

  def runUpdateQuery(query: String): Boolean =
    DB.withConnection { implicit c =>
      SQL(query).execute()
    }

  def getNewsFeed(user_id: String, skip: Long): List[(AbroadStatus)] =
    DB.withConnection { implicit c =>
      SQL("select * from statuses")().map(row => AbroadStatus(
        row[Long]("status_id"),
        row[Long]("user_id"),
        row[String]("status"),
        row[String]("created_at"),
        row[String]("latitude"),
        row[String]("longitude")
      )
      ).toList
    }

  def getUser(email: String): AbroadUser =
    DB.withConnection { implicit c =>
      SQL("select * from users where email='" + email + "'")().map(row => AbroadUser(
        row[Long]("user_id"),
        row[String]("email"),
        row[String]("firstname"),
        row[String]("profile_picture"),
        row[String]("latitude"),
        row[String]("longitude")
      )
      ).toList(0)
    }
}