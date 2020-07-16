package forms

import forms.behaviours.StringFieldBehaviours
import play.api.data.FormError

class AddMoreFormProviderSpec extends StringFieldBehaviours {

  val requiredKey = "addMore.error.required"
  val lengthKey = "addMore.error.length"
  val maxLength = 100

  val form = new AddMoreFormProvider()()

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
