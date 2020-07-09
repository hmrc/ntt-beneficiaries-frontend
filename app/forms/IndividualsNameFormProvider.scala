package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class IndividualsNameFormProvider @Inject() extends Mappings {

  def apply(): Form[String] =
    Form(
      "value" -> text("individualsName.error.required")
        .verifying(maxLength(100, "individualsName.error.length"))
    )
}
