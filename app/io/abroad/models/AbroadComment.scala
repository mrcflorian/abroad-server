package io.abroad.models

import play.api.libs.json._

/**
 * Created by Florian on 6/8/15.
 */

case class AbroadComment(commentID: Long, statusID: Long, userID: Long, text: String, createAt: String)

object AbroadComment {

  implicit object StatusFormat extends Format[AbroadComment] {
    // convert from Tweet object to JSON (serializing to JSON)
    def writes(comment: AbroadComment): JsValue = {
      val statusSeq = Seq(
        "user_id" -> JsString(comment.commentID.toString),
        "user_id" -> JsString(comment.userID.toString),
        "status_id" -> JsString(comment.statusID.toString),
        "text" -> JsString(comment.text),
        "created_at" -> JsString(comment.createAt)
      )
      JsObject(statusSeq)
    }
    // convert from JSON string to a Status object (de-serializing from JSON)
    def reads(json: JsValue): JsResult[AbroadComment] = {
      JsSuccess(AbroadComment(0, 0, 0, "", ""))
    }
  }
}