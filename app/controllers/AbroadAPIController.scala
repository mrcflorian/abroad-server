package controllers

import play.api.mvc._
import play.api.libs.json._


/**
 * Created by Florian on 6/2/15.
 */

class AbroadAPIController extends Controller {

  def updateUser(email: String, firstName: String, facebook: String) = Action {
    Ok(views.html.jsonResponse(Json.stringify(Json.toJson(AbroadDatabaseController.updateUser(email, firstName, facebook)))))
  }

  def newsFeed(userID: String, skip: Long = 0) = Action {
    val statuses = AbroadDatabaseController.getNewsFeed(userID, skip)
    Ok(views.html.jsonResponse(Json.stringify(Json.toJson(statuses))))
  }
}
