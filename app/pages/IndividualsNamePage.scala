package pages

import play.api.libs.json.JsPath

case object IndividualsNamePage extends QuestionPage[String] {

  override def path: JsPath = JsPath \ toString

  override def toString: String = "individualsName"
}
