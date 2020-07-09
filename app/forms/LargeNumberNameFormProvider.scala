package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class LargeNumberNameFormProvider @Inject() extends Mappings {

  def apply(): Form[String] =
    Form(
      "value" -> text("largeNumberName.error.required")
        .verifying(maxLength(100, "largeNumberName.error.length"))
    )
}
