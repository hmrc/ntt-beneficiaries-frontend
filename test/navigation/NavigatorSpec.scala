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

package navigation

import base.SpecBase
import controllers.routes
import generators.Generators
import pages._
import models._
import org.scalacheck.Arbitrary.arbitrary
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class NavigatorSpec extends SpecBase with ScalaCheckPropertyChecks with Generators {

  val navigator = new Navigator

  "Navigator" - {

    "in Normal mode" - {

      "must go from InterruptInfo page to TypeOfBeneficiary page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(InterruptInfoPage, NormalMode, answers)
              .mustBe(routes.TypeOfBeneficiaryController.onPageLoad(NormalMode))
        }
      }

      "must go from TypeOfBeneficiary page to IndividualsName page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(TypeOfBeneficiaryPage, NormalMode, answers)
              .mustBe(routes.IndividualsNameController.onPageLoad(NormalMode))
        }
      }

      "must go from IndividualsName page to KnownDateOfBirth page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(IndividualsNamePage, NormalMode, answers)
              .mustBe(routes.KnownDateOfBirthController.onPageLoad(NormalMode))
        }
      }

      "must go from KnownDateOfBirth page to DateOfBirth page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(KnownDateOfBirthPage, NormalMode, answers)
              .mustBe(routes.DateOfBirthController.onPageLoad(NormalMode))
        }
      }

      "must go from DateOfBirth page to KnownCountryOfNationality page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(DateOfBirthPage, NormalMode, answers)
              .mustBe(routes.KnownCountryOfNationalityController.onPageLoad(NormalMode))
        }
      }

      "must go from KnownCountryOfNationality page to CountryOfNationality page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(KnownCountryOfNationalityPage, NormalMode, answers)
              .mustBe(routes.CountryOfNationalityController.onPageLoad(NormalMode))
        }
      }

      "must go from CountryOfNationality page to KnownCountryOfResidency page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(CountryOfNationalityPage, NormalMode, answers)
              .mustBe(routes.KnownCountryOfResidencyController.onPageLoad(NormalMode))
        }
      }

      "must go from KnownCountryOfResidency page to CountryOfResidency page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(KnownCountryOfResidencyPage, NormalMode, answers)
              .mustBe(routes.CountryOfResidencyController.onPageLoad(NormalMode))
        }
      }

      "must go from CountryOfResidency page to LegallyIncapable page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(CountryOfResidencyPage, NormalMode, answers)
              .mustBe(routes.LegallyIncapableController.onPageLoad(NormalMode))
        }
      }

      "must go from LegallyIncapable page to UnidentifiedDescription page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(LegallyIncapablePage, NormalMode, answers)
              .mustBe(routes.UnidentifiedDescriptionController.onPageLoad(NormalMode))
        }
      }

      "must go from UnidentifiedDescription page to CharityName page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(UnidentifiedDescriptionPage, NormalMode, answers)
              .mustBe(routes.CharityNameController.onPageLoad(NormalMode))
        }
      }

      "must go from CharityName page to TrustsName page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(CharityNamePage, NormalMode, answers)
              .mustBe(routes.TrustNameController.onPageLoad(NormalMode))
        }
      }

      "must go from TrustName page to CompanyName page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(TrustNamePage, NormalMode, answers)
              .mustBe(routes.CompanyNameController.onPageLoad(NormalMode))
        }
      }

      "must go from CompanyName page to LargeNumberName page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(CompanyNamePage, NormalMode, answers)
              .mustBe(routes.LargeNumberNameController.onPageLoad(NormalMode))
        }
      }

      "must go from LargeNumberName page to NumberOfBeneficiaries page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(LargeNumberNamePage, NormalMode, answers)
              .mustBe(routes.NumberOfBeneficiariesController.onPageLoad(NormalMode))
        }
      }

      "must go from NumberOfBeneficiaries page to Description page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(NumberOfBeneficiariesPage, NormalMode, answers)
              .mustBe(routes.DescriptionController.onPageLoad(NormalMode))
        }
      }

      "must go from Description page to OtherDescription page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(DescriptionPage, NormalMode, answers)
              .mustBe(routes.OtherDescriptionController.onPageLoad(NormalMode))
        }
      }

      "must go from OtherDescription page to KnownCountry page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(OtherDescriptionPage, NormalMode, answers)
              .mustBe(routes.KnownCountryController.onPageLoad(NormalMode))
        }
      }

      "must go from KnownCountry page to CountryInUK page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(KnownCountryPage, NormalMode, answers)
              .mustBe(routes.CountryInUKController.onPageLoad(NormalMode))
        }
      }

      "must go from CountryInUK page to Country page" in {

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(CountryInUKPage, NormalMode, answers)
              .mustBe(routes.CountryController.onPageLoad(NormalMode))
        }
      }
    }

    "in Check mode" - {

      "must go from a page that doesn't exist in the edit route map  to Check Your Answers" in {

        case object UnknownPage extends Page

        forAll(arbitrary[UserAnswers]) {
          answers =>

            navigator.nextPage(UnknownPage, CheckMode, answers)
              .mustBe(routes.CheckYourAnswersController.onPageLoad())
        }
      }
    }
  }
}
