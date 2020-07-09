package forms

import javax.inject.Inject

import forms.mappings.Mappings
import play.api.data.Form

class KnownDateOfBirthFormProvider @Inject() extends Mappings {

  def apply(): Form[Boolean] =
    Form(
      "value" -> boolean("knownDateOfBirth.error.required")
    )
}
