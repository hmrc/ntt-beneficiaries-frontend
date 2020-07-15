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

package generators

import models.UserAnswers
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.TryValues
import pages._
import play.api.libs.json.{JsPath, JsValue, Json}

trait UserAnswersGenerator extends TryValues {
  self: Generators =>

  val generators: Seq[Gen[(QuestionPage[_], JsValue)]] =
    arbitrary[(KnownCountryPage.type, JsValue)] ::
    arbitrary[(CountryPage.type, JsValue)] ::
    arbitrary[(WhichCountryPage.type, JsValue)] ::
    arbitrary[(OtherDescriptionPage.type, JsValue)] ::
    arbitrary[(DescriptionPage.type, JsValue)] ::
    arbitrary[(CountryInUKPage.type, JsValue)] ::
    arbitrary[(UnidentifiedDescriptionPage.type, JsValue)] ::
    arbitrary[(TrustNamePage.type, JsValue)] ::
    arbitrary[(NumberOfBeneficiariesPage.type, JsValue)] ::
    arbitrary[(LargeNumberNamePage.type, JsValue)] ::
    arbitrary[(CompanyNamePage.type, JsValue)] ::
    arbitrary[(CharityNamePage.type, JsValue)] ::
    arbitrary[(LegallyIncapablePage.type, JsValue)] ::
    arbitrary[(KnownCountryOfResidencyPage.type, JsValue)] ::
    arbitrary[(KnownCountryOfNationalityPage.type, JsValue)] ::
    arbitrary[(CountryOfResidencyPage.type, JsValue)] ::
    arbitrary[(CountryOfNationalityPage.type, JsValue)] ::
    arbitrary[(KnownDateOfBirthPage.type, JsValue)] ::
    arbitrary[(IndividualsNamePage.type, JsValue)] ::
    arbitrary[(DateOfBirthPage.type, JsValue)] ::
    arbitrary[(TypeOfBeneficiaryPage.type, JsValue)] ::
    Nil

  implicit lazy val arbitraryUserData: Arbitrary[UserAnswers] = {

    import models._

    Arbitrary {
      for {
        id      <- nonEmptyString
        data    <- generators match {
          case Nil => Gen.const(Map[QuestionPage[_], JsValue]())
          case _   => Gen.mapOf(oneOf(generators))
        }
      } yield UserAnswers (
        id = id,
        data = data.foldLeft(Json.obj()) {
          case (obj, (path, value)) =>
            obj.setObject(path.path, value).get
        }
      )
    }
  }
}
