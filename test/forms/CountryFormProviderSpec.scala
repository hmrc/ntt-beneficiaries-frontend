package forms

import forms.behaviours.StringFieldBehaviours
import play.api.data.FormError

class CountryFormProviderSpec extends StringFieldBehaviours {

  val requiredKey = "country.error.required"
  val lengthKey = "country.error.length"
  val maxLength = 100

  val form = new CountryFormProvider()()

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
