package models

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.{FreeSpec, MustMatchers, OptionValues}
import play.api.libs.json.{JsError, JsString, Json}

class NumberOfBeneficiariesSpec extends FreeSpec with MustMatchers with ScalaCheckPropertyChecks with OptionValues {

  "NumberOfBeneficiaries" - {

    "must deserialise valid values" in {

      val gen = Gen.oneOf(NumberOfBeneficiaries.values)

      forAll(gen) {
        numberOfBeneficiaries =>

          JsString(numberOfBeneficiaries.toString).validate[NumberOfBeneficiaries].asOpt.value mustEqual numberOfBeneficiaries
      }
    }

    "must fail to deserialise invalid values" in {

      val gen = arbitrary[String] suchThat (!NumberOfBeneficiaries.values.map(_.toString).contains(_))

      forAll(gen) {
        invalidValue =>

          JsString(invalidValue).validate[NumberOfBeneficiaries] mustEqual JsError("error.invalid")
      }
    }

    "must serialise" in {

      val gen = Gen.oneOf(NumberOfBeneficiaries.values)

      forAll(gen) {
        numberOfBeneficiaries =>

          Json.toJson(numberOfBeneficiaries) mustEqual JsString(numberOfBeneficiaries.toString)
      }
    }
  }
}
