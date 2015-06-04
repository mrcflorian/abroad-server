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

  def newsFeedTop(userID: Long, topID: Long = 0) = Action {
    val statuses = AbroadDatabaseController.getNewsFeedTop(userID, topID)
    Ok(views.html.jsonResponse(Json.stringify(Json.toJson(statuses))))
  }

  def messagingUsers(userID: Long, skip: Long = 0) = Action {
    val users = AbroadDatabaseController.getMessagingUsers(userID, skip)
    Ok(views.html.jsonResponse(Json.stringify(Json.toJson(users))))
  }

  def addStatus(userID: Long, status: String) = Action {
    val response = AbroadDatabaseController.addStatus(userID, status)
    Ok(views.html.jsonResponse(Json.stringify(Json.toJson(response))))
  }
}
