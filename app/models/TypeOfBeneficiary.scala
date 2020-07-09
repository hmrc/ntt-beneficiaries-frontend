package models

import play.api.data.Form
import play.api.i18n.Messages
import play.api.libs.json._
import uk.gov.hmrc.viewmodels._

sealed trait TypeOfBeneficiary

object TypeOfBeneficiary extends Enumerable.Implicits {

  case object Individual extends WithName("individual") with TypeOfBeneficiary
  case object Unidentified extends WithName("unidentified") with TypeOfBeneficiary
  case object Charity extends WithName("charity") with TypeOfBeneficiary
  case object Trust extends WithName("trust") with TypeOfBeneficiary
  case object Company extends WithName("company") with TypeOfBeneficiary
  case object LargeNumbers extends WithName("largeNumbers") with TypeOfBeneficiary
  case object Others extends WithName("others") with TypeOfBeneficiary

  val values: Seq[TypeOfBeneficiary] = Seq(
    Individual,
    Unidentified
  )

  def radios(form: Form[_])(implicit messages: Messages): Seq[Radios.Item] = {

    val field = form("value")
    val items = Seq(
      Radios.Radio(msg"typeOfBeneficiary.individual", Individual.toString),
      Radios.Radio(msg"typeOfBeneficiary.unidentified", Unidentified.toString),
      Radios.Radio(msg"typeOfBeneficiary.charity", Unidentified.toString),
      Radios.Radio(msg"typeOfBeneficiary.trust", Unidentified.toString),
      Radios.Radio(msg"typeOfBeneficiary.company", Unidentified.toString),
      Radios.Radio(msg"typeOfBeneficiary.largeNumbers", Unidentified.toString),
      Radios.Radio(msg"typeOfBeneficiary.others", Unidentified.toString)
    )

    Radios(field, items)
  }

  implicit val enumerable: Enumerable[TypeOfBeneficiary] =
    Enumerable(values.map(v => v.toString -> v): _*)
}
