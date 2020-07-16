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

import forms.behaviours.StringFieldBehaviours
import play.api.data.FormError

class DescriptionFormProviderSpec extends StringFieldBehaviours {

  val requiredKey = "description.error.required"
  val lengthKey = "description.error.length"
  val maxLength = 70

  val form = new DescriptionFormProvider()()

  ".descriptionOne" - {

    val field = "descriptionOne"
    val requiredKey = s"description.${field}.error.required"

    behave like fieldThatBindsValidData(
      form,
      field,
      stringsWithMaxLength(maxLength)
    )

    behave like mandatoryField(
      form,
      field,
      requiredError = FormError(field, requiredKey)
    )
  }

  ".descriptionTwo" - {

    val field = "descriptionTwo"
    val requiredKey = s"description.${field}.error.required"

    behave like fieldThatBindsValidData(
      form,
      field,
      stringsWithMaxLength(maxLength)
    )
  }

  ".descriptionThree" - {

    val field = "descriptionThree"
    val requiredKey = s"description.${field}.error.required"

    behave like fieldThatBindsValidData(
      form,
      field,
      stringsWithMaxLength(maxLength)
    )
  }

  ".descriptionFour" - {

    val field = "descriptionFour"
    val requiredKey = s"description.${field}.error.required"

    behave like fieldThatBindsValidData(
      form,
      field,
      stringsWithMaxLength(maxLength)
    )
  }

  ".descriptionFive" - {

    val field = "descriptionFive"
    val requiredKey = s"description.${field}.error.required"

    behave like fieldThatBindsValidData(
      form,
      field,
      stringsWithMaxLength(maxLength)
    )
  }
}
