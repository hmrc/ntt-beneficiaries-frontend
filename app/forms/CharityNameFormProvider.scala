package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class CharityNameFormProvider @Inject() extends Mappings {

  def apply(): Form[String] =
    Form(
      "value" -> text("charityName.error.required")
        .verifying(maxLength(100, "charityName.error.length"))
    )
}
