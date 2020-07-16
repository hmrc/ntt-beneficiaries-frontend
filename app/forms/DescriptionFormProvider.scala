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

package forms

import javax.inject.Inject
import forms.mappings.Mappings
import models.Description
import play.api.data.Form
import play.api.data.Forms._

class DescriptionFormProvider @Inject() extends Mappings {

  def apply(): Form[Description] =
    Form(
      mapping(
        "descriptionOne" -> text("description.descriptionOne.error.required")
          .verifying(maxLength(70, "description.descriptionOne.error.required")),
        "descriptionTwo" -> optionalText().verifying(optMaxLength(70, "description.descriptionTwo.error.required")),
        "descriptionThree" -> optionalText().verifying(optMaxLength(70, "description.descriptionThree.error.required")),
        "descriptionFour" -> optionalText().verifying(optMaxLength(70, "description.descriptionFour.error.required")),
        "descriptionFive" -> optionalText().verifying(optMaxLength(70, "description.descriptionFive.error.required"))
      )(Description.apply)(Description.unapply)
    )
}
