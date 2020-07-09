package forms

import forms.behaviours.BooleanFieldBehaviours
import play.api.data.FormError

class KnownCountryOfNationalityFormProviderSpec extends BooleanFieldBehaviours {

  val requiredKey = "knownCountryOfNationality.error.required"
  val invalidKey = "error.boolean"

  val form = new KnownCountryOfNationalityFormProvider()()

  ".value" - {

    val fieldName = "value"

    behave like booleanField(
      form,
      fieldName,
      invalidError = FormError(fieldName, invalidKey)
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
