package controllers

import play.api.mvc._
import play.api.db._
import anorm._
import play.api.Play.current

/**
 * Created by Florian on 6/2/15.
 */
class AbroadAPIController extends Controller {

  def updateUser(email: String, firstName: String, facebook: String) = Action {
    DB.withConnection { implicit c =>
      val result: Boolean = SQL("insert into users values(1, '2', '3', '4', '5', '6', '7', '8', '9', '10', '11')").execute()
    }
    Ok(views.html.jsonResponse(""))
  }

  def newsFeed(userID: String) = Action {
    Ok(views.html.jsonResponse(""))
  }
}
