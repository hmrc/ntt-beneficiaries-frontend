package forms

import forms.behaviours.StringFieldBehaviours
import play.api.data.FormError

class IndividualsNameFormProviderSpec extends StringFieldBehaviours {

  val requiredKey = "individualsName.error.required"
  val lengthKey = "individualsName.error.length"
  val maxLength = 100

  val form = new IndividualsNameFormProvider()()

  ".value" - {

    val fieldName = "value"

    behave like fieldThatBindsValidData(
      form,
      fieldName,
      stringsWithMaxLength(maxLength)
    )

    behave like fieldWithMaxLength(
      form,
      fieldName,
      maxLength = maxLength,
      lengthError = FormError(fieldName, lengthKey, Seq(maxLength))
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
