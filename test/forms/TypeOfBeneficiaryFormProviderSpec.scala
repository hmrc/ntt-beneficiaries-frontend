package forms

import forms.behaviours.OptionFieldBehaviours
import models.TypeOfBeneficiary
import play.api.data.FormError

class TypeOfBeneficiaryFormProviderSpec extends OptionFieldBehaviours {

  val form = new TypeOfBeneficiaryFormProvider()()

  ".value" - {

    val fieldName = "value"
    val requiredKey = "typeOfBeneficiary.error.required"

    behave like optionsField[TypeOfBeneficiary](
      form,
      fieldName,
      validValues  = TypeOfBeneficiary.values,
      invalidError = FormError(fieldName, "error.invalid")
    )

    behave like mandatoryField(
      form,
      fieldName,
      requiredError = FormError(fieldName, requiredKey)
    )
  }
}
