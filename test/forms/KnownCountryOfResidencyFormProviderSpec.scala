package forms

import forms.behaviours.BooleanFieldBehaviours
import play.api.data.FormError

class KnownCountryOfResidencyFormProviderSpec extends BooleanFieldBehaviours {

  val requiredKey = "knownCountryOfResidency.error.required"
  val invalidKey = "error.boolean"

  val form = new KnownCountryOfResidencyFormProvider()()

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
