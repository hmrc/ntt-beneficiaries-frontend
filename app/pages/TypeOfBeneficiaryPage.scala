package pages

import models.TypeOfBeneficiary
import play.api.libs.json.JsPath

case object TypeOfBeneficiaryPage extends QuestionPage[TypeOfBeneficiary] {

  override def path: JsPath = JsPath \ toString

  override def toString: String = "typeOfBeneficiary"
}
