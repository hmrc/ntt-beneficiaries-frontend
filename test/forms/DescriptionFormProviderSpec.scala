package forms

import forms.behaviours.StringFieldBehaviours
import play.api.data.FormError

class DescriptionFormProviderSpec extends StringFieldBehaviours {

  val requiredKey = "description.error.required"
  val lengthKey = "description.error.length"
  val maxLength = 70

  val form = new DescriptionFormProvider()()

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