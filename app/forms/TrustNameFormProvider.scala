package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class TrustNameFormProvider @Inject() extends Mappings {

  def apply(): Form[String] =
    Form(
      "value" -> text("trustName.error.required")
        .verifying(maxLength(100, "trustName.error.length"))
    )
}
