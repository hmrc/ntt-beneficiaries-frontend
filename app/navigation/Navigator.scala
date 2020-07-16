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

import javax.inject.{Inject, Singleton}

import play.api.mvc.Call
import controllers.routes
import pages._
import models._

@Singleton
class Navigator @Inject()() {

  private val normalRoutes: Page => UserAnswers => Call = {
    case InterruptInfoPage             => _ => routes.TypeOfBeneficiaryController.onPageLoad(NormalMode)
    case TypeOfBeneficiaryPage         => _ => routes.IndividualsNameController.onPageLoad(NormalMode)
    case IndividualsNamePage           => _ => routes.KnownDateOfBirthController.onPageLoad(NormalMode)
    case KnownDateOfBirthPage          => _ => routes.DateOfBirthController.onPageLoad(NormalMode)
    case DateOfBirthPage               => _ => routes.KnownCountryOfNationalityController.onPageLoad(NormalMode)
    case KnownCountryOfNationalityPage => _ => routes.CountryOfNationalityController.onPageLoad(NormalMode)
    case CountryOfNationalityPage      => _ => routes.KnownCountryOfResidencyController.onPageLoad(NormalMode)
    case KnownCountryOfResidencyPage   => _ => routes.CountryOfResidencyController.onPageLoad(NormalMode)
    case CountryOfResidencyPage        => _ => routes.LegallyIncapableController.onPageLoad(NormalMode)
    case LegallyIncapablePage          => _ => routes.UnidentifiedDescriptionController.onPageLoad(NormalMode)
    case UnidentifiedDescriptionPage   => _ => routes.CharityNameController.onPageLoad(NormalMode)
    case CharityNamePage               => _ => routes.TrustNameController.onPageLoad(NormalMode)
    case TrustNamePage                 => _ => routes.CompanyNameController.onPageLoad(NormalMode)
    case CompanyNamePage               => _ => routes.LargeNumberNameController.onPageLoad(NormalMode)
    case LargeNumberNamePage           => _ => routes.NumberOfBeneficiariesController.onPageLoad(NormalMode)
    case NumberOfBeneficiariesPage     => _ => routes.DescriptionController.onPageLoad(NormalMode)
    case DescriptionPage               => _ => routes.OtherDescriptionController.onPageLoad(NormalMode)
    case OtherDescriptionPage          => _ => routes.KnownCountryController.onPageLoad(NormalMode)
    case KnownCountryPage              => _ => routes.CountryInUKController.onPageLoad(NormalMode)
    case CountryInUKPage               => _ => routes.CountryController.onPageLoad(NormalMode)
    case CountryPage                   => _ => routes.CheckYourAnswersController.onPageLoad()
    case CheckYourAnswersPage          => _ => routes.AddMoreController.onPageLoad(NormalMode)
  }

  private val checkRouteMap: Page => UserAnswers => Call = {
    case _ => _ => routes.CheckYourAnswersController.onPageLoad()
  }

  def nextPage(page: Page, mode: Mode, userAnswers: UserAnswers): Call = mode match {
    case NormalMode =>
      normalRoutes(page)(userAnswers)
    case CheckMode =>
      checkRouteMap(page)(userAnswers)
  }
}
