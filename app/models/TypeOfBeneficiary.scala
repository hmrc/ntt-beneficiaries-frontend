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
