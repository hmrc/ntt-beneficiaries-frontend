package forms

import forms.behaviours.StringFieldBehaviours
import play.api.data.FormError

class CharityNameFormProviderSpec extends StringFieldBehaviours {

  val requiredKey = "charityName.error.required"
  val lengthKey = "charityName.error.length"
  val maxLength = 100

  val form = new CharityNameFormProvider()()

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
