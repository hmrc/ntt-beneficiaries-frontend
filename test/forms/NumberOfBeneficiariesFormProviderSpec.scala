package forms

import forms.behaviours.OptionFieldBehaviours
import models.NumberOfBeneficiaries
import play.api.data.FormError

class NumberOfBeneficiariesFormProviderSpec extends OptionFieldBehaviours {

  val form = new NumberOfBeneficiariesFormProvider()()

  ".value" - {

    val fieldName = "value"
    val requiredKey = "numberOfBeneficiaries.error.required"

    behave like optionsField[NumberOfBeneficiaries](
      form,
      fieldName,
      validValues  = NumberOfBeneficiaries.values,
      invalidError = FormError(fieldName, "error.invalid")
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
