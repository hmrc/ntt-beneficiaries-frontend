package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form
import models.TypeOfBeneficiary

class TypeOfBeneficiaryFormProvider @Inject() extends Mappings {

  def apply(): Form[TypeOfBeneficiary] =
    Form(
      "value" -> enumerable[TypeOfBeneficiary]("typeOfBeneficiary.error.required")
    )
}
