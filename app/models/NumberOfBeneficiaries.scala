/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package models

import play.api.data.Form
import play.api.i18n.Messages
import play.api.libs.json._
import uk.gov.hmrc.viewmodels._

sealed trait NumberOfBeneficiaries

object NumberOfBeneficiaries extends Enumerable.Implicits {

  case object OneToOneHundred extends WithName("oneToOneHundred") with NumberOfBeneficiaries
  case object OneHundredToTwoHundred extends WithName("oneHundredToTwoHundred") with NumberOfBeneficiaries
  case object TwoHundredToFiveHundred extends WithName("twoHundredToFiveHundred") with NumberOfBeneficiaries
  case object FiveHundredToOneThousand extends WithName("fiveHundredToOneThousand") with NumberOfBeneficiaries
  case object OverOneThousand extends WithName("overOneThousand") with NumberOfBeneficiaries

  val values: Seq[NumberOfBeneficiaries] = Seq(
    OneToOneHundred,
    OneHundredToTwoHundred,
    TwoHundredToFiveHundred,
    FiveHundredToOneThousand,
    OverOneThousand
  )

  def radios(form: Form[_])(implicit messages: Messages): Seq[Radios.Item] = {

    val field = form("value")
    val items = Seq(
      Radios.Radio(msg"numberOfBeneficiaries.oneToOneHundred", OneToOneHundred.toString),
      Radios.Radio(msg"numberOfBeneficiaries.oneHundredToTwoHundred", OneHundredToTwoHundred.toString),
      Radios.Radio(msg"numberOfBeneficiaries.twoHundredToFiveHundred", TwoHundredToFiveHundred.toString),
      Radios.Radio(msg"numberOfBeneficiaries.fiveHundredToOneThousand", FiveHundredToOneThousand.toString),
      Radios.Radio(msg"numberOfBeneficiaries.overOneThousand", OverOneThousand.toString)
    )

    Radios(field, items)
  }

  implicit val enumerable: Enumerable[NumberOfBeneficiaries] =
    Enumerable(values.map(v => v.toString -> v): _*)
}
