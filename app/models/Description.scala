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

import play.api.libs.json.{JsObject, OWrites, Reads, __}

final case class Description(descriptionOne: String,
                             descriptionTwo: Option[String],
                             descriptionThree: Option[String],
                             descriptionFour: Option[String],
                             descriptionFive: Option[String])

object Description {

  implicit lazy val reads: Reads[Description] = {
    import play.api.libs.functional.syntax._
    (
      (__ \ "descriptionOne").read[String] and
        (__ \ "descriptionTwo").readNullable[String] and
        (__ \ "descriptionThree").readNullable[String] and
        (__ \ "descriptionFour").readNullable[String] and
        (__ \ "descriptionFive").readNullable[String]
      ) (Description.apply _)
  }

  implicit lazy val writes: OWrites[Description] = {
    import play.api.libs.functional.syntax._
    (
      (__ \ "descriptionOne").write[String] and
        (__ \ "descriptionTwo").writeNullable[String] and
        (__ \ "descriptionThree").writeNullable[String] and
        (__ \ "descriptionFour").writeNullable[String] and
        (__ \ "descriptionFive").writeNullable[String]
      ) (unlift(Description.unapply))
  }
}
