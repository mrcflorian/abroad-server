package io.abroad.models

import play.api.libs.json._

/**
 * Created by Florian on 6/3/15.
 */

case class AbroadStatus(statusID: Long, userID: Long, status: String, createAt: String, latitude: String, longitude: String)

object AbroadStatus {

  implicit object StatusFormat extends Format[AbroadStatus] {
    // convert from Tweet object to JSON (serializing to JSON)
    def writes(status: AbroadStatus): JsValue = {
      val statusSeq = Seq(
        "status_id" -> JsString(status.statusID.toString),
        "user_id" -> JsString(status.userID.toString),
        "status" -> JsString(status.status),
        "created_at" -> JsString(status.createAt),
        "latitude" -> JsString(status.latitude),
        "longitude" -> JsString(status.longitude),
        "image_url" -> JsString("http://img.youtube.com/vi/W9ZEnhLY7tk/0.jpg")
      )
      JsObject(statusSeq)
    }
    // convert from JSON string to a Status object (de-serializing from JSON)
    def reads(json: JsValue): JsResult[AbroadStatus] = {
      JsSuccess(AbroadStatus(0, 0, "", "", "", ""))
    }
  }
}
