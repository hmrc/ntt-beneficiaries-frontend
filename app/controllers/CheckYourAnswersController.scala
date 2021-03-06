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

package controllers

import com.google.inject.Inject
import controllers.actions.{DataRequiredAction, DataRetrievalAction, IdentifierAction}
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import renderer.Renderer
import navigation.Navigator
import repositories.SessionRepository
import models.{NormalMode, UserAnswers}
import pages.CheckYourAnswersPage
import services.CountryService
import uk.gov.hmrc.play.bootstrap.controller.FrontendBaseController
import uk.gov.hmrc.viewmodels.{NunjucksSupport, SummaryList}
import utils.CheckYourAnswersHelper

import scala.concurrent.ExecutionContext

class CheckYourAnswersController @Inject()(
                                           override val messagesApi: MessagesApi,
                                           navigator: Navigator,
                                           sessionRepository: SessionRepository,
                                           identify: IdentifierAction,
                                           getData: DataRetrievalAction,
                                           requireData: DataRequiredAction,
                                           val controllerComponents: MessagesControllerComponents,
                                           renderer: Renderer,
                                           countryService: CountryService
)(implicit ec: ExecutionContext) extends FrontendBaseController with I18nSupport with NunjucksSupport {

  def onPageLoad(): Action[AnyContent] = (identify andThen getData andThen requireData).async {
    implicit request =>

      val checkYourAnswersHelper = new CheckYourAnswersHelper(request.userAnswers, countryService)

      val answers: Seq[SummaryList.Row] = Seq(
        checkYourAnswersHelper.typeOfBeneficiary,
        checkYourAnswersHelper.individualsName,
        checkYourAnswersHelper.knownDateOfBirth,
        checkYourAnswersHelper.dateOfBirth,
        checkYourAnswersHelper.knownCountryOfNationality,
        checkYourAnswersHelper.countryOfNationality,
        checkYourAnswersHelper.knownCountryOfResidency,
        checkYourAnswersHelper.countryOfResidency,
        checkYourAnswersHelper.legallyIncapable,
        checkYourAnswersHelper.unidentifiedDescription,
        checkYourAnswersHelper.charityName,
        checkYourAnswersHelper.trustName,
        checkYourAnswersHelper.companyName,
        checkYourAnswersHelper.largeNumberName,
        checkYourAnswersHelper.numberOfBeneficiaries,
        checkYourAnswersHelper.description,
        checkYourAnswersHelper.otherDescription,
        checkYourAnswersHelper.knownCountry,
        checkYourAnswersHelper.countryInUK,
        checkYourAnswersHelper.country
      ).flatten

      renderer.render(
        "check-your-answers.njk",
        Json.obj("list" -> answers)
      ).map(Ok(_))
  }

  def onSubmit: Action[AnyContent] = (identify andThen getData andThen requireData).async {
    implicit request =>
      val answers = UserAnswers(request.internalId)
      for {
        _ <- sessionRepository.set(answers)
      } yield Redirect(navigator.nextPage(CheckYourAnswersPage, NormalMode, answers))
  }
}
