package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class CompanyNameFormProvider @Inject() extends Mappings {

  def apply(): Form[String] =
    Form(
      "value" -> text("companyName.error.required")
        .verifying(maxLength(100, "companyName.error.length"))
    )
}
