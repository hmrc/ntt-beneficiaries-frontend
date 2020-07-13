package forms

import forms.behaviours.StringFieldBehaviours
import play.api.data.FormError

class OtherDescriptionFormProviderSpec extends StringFieldBehaviours {

  val requiredKey = "otherDescription.error.required"
  val lengthKey = "otherDescription.error.length"
  val maxLength = 100

  val form = new OtherDescriptionFormProvider()()

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
