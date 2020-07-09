package pages

import play.api.libs.json.JsPath

case object LargeNumberNamePage extends QuestionPage[String] {

  override def path: JsPath = JsPath \ toString

  override def toString: String = "largeNumberName"
}
