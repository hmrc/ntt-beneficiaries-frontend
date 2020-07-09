package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class UnidentifiedDescriptionFormProvider @Inject() extends Mappings {

  def apply(): Form[String] =
    Form(
      "value" -> text("unidentifiedDescription.error.required")
        .verifying(maxLength(100, "unidentifiedDescription.error.length"))
    )
}
