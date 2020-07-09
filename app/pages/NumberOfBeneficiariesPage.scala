package pages

import models.NumberOfBeneficiaries
import play.api.libs.json.JsPath

case object NumberOfBeneficiariesPage extends QuestionPage[NumberOfBeneficiaries] {

  override def path: JsPath = JsPath \ toString

  override def toString: String = "numberOfBeneficiaries"
}
