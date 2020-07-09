package models

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.{FreeSpec, MustMatchers, OptionValues}
import play.api.libs.json.{JsError, JsString, Json}

class TypeOfBeneficiarySpec extends FreeSpec with MustMatchers with ScalaCheckPropertyChecks with OptionValues {

  "TypeOfBeneficiary" - {

    "must deserialise valid values" in {

      val gen = Gen.oneOf(TypeOfBeneficiary.values)

      forAll(gen) {
        typeOfBeneficiary =>

          JsString(typeOfBeneficiary.toString).validate[TypeOfBeneficiary].asOpt.value mustEqual typeOfBeneficiary
      }
    }

    "must fail to deserialise invalid values" in {

      val gen = arbitrary[String] suchThat (!TypeOfBeneficiary.values.map(_.toString).contains(_))

      forAll(gen) {
        invalidValue =>

          JsString(invalidValue).validate[TypeOfBeneficiary] mustEqual JsError("error.invalid")
      }
    }

    "must serialise" in {

      val gen = Gen.oneOf(TypeOfBeneficiary.values)

      forAll(gen) {
        typeOfBeneficiary =>

          Json.toJson(typeOfBeneficiary) mustEqual JsString(typeOfBeneficiary.toString)
      }
    }
  }
}
