package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form
import models.NumberOfBeneficiaries

class NumberOfBeneficiariesFormProvider @Inject() extends Mappings {

  def apply(): Form[NumberOfBeneficiaries] =
    Form(
      "value" -> enumerable[NumberOfBeneficiaries]("numberOfBeneficiaries.error.required")
    )
}
