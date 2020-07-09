package models

import play.api.data.Form
import play.api.i18n.Messages
import play.api.libs.json._
import uk.gov.hmrc.viewmodels._

sealed trait NumberOfBeneficiaries

object NumberOfBeneficiaries extends Enumerable.Implicits {

  case object Onetoonehundred extends WithName("oneToOneHundred") with NumberOfBeneficiaries
  case object Onehundredtotwohundred extends WithName("oneHundredToTwoHundred") with NumberOfBeneficiaries

  val values: Seq[NumberOfBeneficiaries] = Seq(
    Onetoonehundred,
    Onehundredtotwohundred
  )

  def radios(form: Form[_])(implicit messages: Messages): Seq[Radios.Item] = {

    val field = form("value")
    val items = Seq(
      Radios.Radio(msg"numberOfBeneficiaries.oneToOneHundred", Onetoonehundred.toString),
      Radios.Radio(msg"numberOfBeneficiaries.oneHundredToTwoHundred", Onehundredtotwohundred.toString)
    )

    Radios(field, items)
  }

  implicit val enumerable: Enumerable[NumberOfBeneficiaries] =
    Enumerable(values.map(v => v.toString -> v): _*)
}
