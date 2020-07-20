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

sealed trait AddMore

object AddMore extends Enumerable.Implicits {

  case object Now extends WithName("now") with AddMore
  case object Later extends WithName("later") with AddMore
  case object No extends WithName("no") with AddMore

  val values: Seq[AddMore] = Seq(
    Now,
    Later,
    No
  )

  def radios(form: Form[_])(implicit messages: Messages): Seq[Radios.Item] = {

    val field = form("value")
    val items = Seq(
      Radios.Radio(msg"addMore.now", Now.toString),
      Radios.Radio(msg"addMore.later", Later.toString),
      Radios.Radio(msg"addMore.no", No.toString)
    )

    Radios(field, items)
  }

  implicit val enumerable: Enumerable[AddMore] =
    Enumerable(values.map(v => v.toString -> v): _*)
}
