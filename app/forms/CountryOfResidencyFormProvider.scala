package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class CountryOfResidencyFormProvider @Inject() extends Mappings {

  def apply(): Form[String] =
    Form(
      "value" -> text("countryOfResidency.error.required")
        .verifying(maxLength(100, "countryOfResidency.error.length"))
    )
}
