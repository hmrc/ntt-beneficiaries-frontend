/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
