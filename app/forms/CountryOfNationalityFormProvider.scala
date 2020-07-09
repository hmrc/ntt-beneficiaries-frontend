package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class CountryOfNationalityFormProvider @Inject() extends Mappings {

  def apply(): Form[String] =
    Form(
      "value" -> text("countryOfNationality.error.required")
        .verifying(maxLength(100, "countryOfNationality.error.length"))
    )
}
