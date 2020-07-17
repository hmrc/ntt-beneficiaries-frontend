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

package utils

import java.time.format.DateTimeFormatter

import controllers.routes
import models.{CheckMode, Description, Name, UserAnswers}
import pages._
import play.api.i18n.Messages
import CheckYourAnswersHelper._
import services.CountryService
import uk.gov.hmrc.viewmodels._
import uk.gov.hmrc.viewmodels.SummaryList._
import uk.gov.hmrc.viewmodels.Text.Literal

class CheckYourAnswersHelper(userAnswers: UserAnswers, countryService: CountryService)(implicit messages: Messages) {

  def addMore: Option[Row] = userAnswers.get(AddMorePage) map {
    answer =>
      Row(
        key     = Key(msg"addMore.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.AddMoreController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"addMore.checkYourAnswersLabel"))
          )
        )
      )
  }

  def knownCountry: Option[Row] = userAnswers.get(KnownCountryPage) map {
    answer =>
      Row(
        key     = Key(msg"knownCountry.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(yesOrNo(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.KnownCountryController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"knownCountry.checkYourAnswersLabel"))
          )
        )
      )
  }

  def country: Option[Row] = userAnswers.get(CountryPage) map {
    answer =>
      Row(
        key     = Key(msg"country.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(country(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.CountryController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"country.checkYourAnswersLabel"))
          )
        )
      )
  }

  def otherDescription: Option[Row] = userAnswers.get(OtherDescriptionPage) map {
    answer =>
      Row(
        key     = Key(msg"otherDescription.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.OtherDescriptionController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"otherDescription.checkYourAnswersLabel"))
          )
        )
      )
  }

  def description: Option[Row] = userAnswers.get(DescriptionPage) map {
    answer =>
      Row(
        key     = Key(msg"description.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(descriptionHtml(descriptionAsList(answer))),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.DescriptionController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"description.checkYourAnswersLabel"))
          )
        )
      )
  }

  def countryInUK: Option[Row] = userAnswers.get(CountryInUKPage) map {
    answer =>
      Row(
        key     = Key(msg"countryInUK.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(yesOrNo(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.CountryInUKController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"countryInUK.checkYourAnswersLabel"))
          )
        )
      )
  }

  def unidentifiedDescription: Option[Row] = userAnswers.get(UnidentifiedDescriptionPage) map {
    answer =>
      Row(
        key     = Key(msg"unidentifiedDescription.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.UnidentifiedDescriptionController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"unidentifiedDescription.checkYourAnswersLabel"))
          )
        )
      )
  }

  def trustName: Option[Row] = userAnswers.get(TrustNamePage) map {
    answer =>
      Row(
        key     = Key(msg"trustName.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.TrustNameController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"trustName.checkYourAnswersLabel"))
          )
        )
      )
  }

  def numberOfBeneficiaries: Option[Row] = userAnswers.get(NumberOfBeneficiariesPage) map {
    answer =>
      Row(
        key     = Key(msg"numberOfBeneficiaries.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(msg"numberOfBeneficiaries.$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.NumberOfBeneficiariesController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"numberOfBeneficiaries.checkYourAnswersLabel"))
          )
        )
      )
  }

  def largeNumberName: Option[Row] = userAnswers.get(LargeNumberNamePage) map {
    answer =>
      Row(
        key     = Key(msg"largeNumberName.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.LargeNumberNameController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"largeNumberName.checkYourAnswersLabel"))
          )
        )
      )
  }

  def companyName: Option[Row] = userAnswers.get(CompanyNamePage) map {
    answer =>
      Row(
        key     = Key(msg"companyName.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.CompanyNameController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"companyName.checkYourAnswersLabel"))
          )
        )
      )
  }

  def charityName: Option[Row] = userAnswers.get(CharityNamePage) map {
    answer =>
      Row(
        key     = Key(msg"charityName.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(lit"$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.CharityNameController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"charityName.checkYourAnswersLabel"))
          )
        )
      )
  }

  def legallyIncapable: Option[Row] = userAnswers.get(LegallyIncapablePage) map {
    answer =>
      Row(
        key     = Key(msg"legallyIncapable.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(yesOrNo(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.LegallyIncapableController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"legallyIncapable.checkYourAnswersLabel"))
          )
        )
      )
  }

  def knownCountryOfResidency: Option[Row] = userAnswers.get(KnownCountryOfResidencyPage) map {
    answer =>
      Row(
        key     = Key(msg"knownCountryOfResidency.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(yesOrNo(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.KnownCountryOfResidencyController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"knownCountryOfResidency.checkYourAnswersLabel"))
          )
        )
      )
  }

  def knownCountryOfNationality: Option[Row] = userAnswers.get(KnownCountryOfNationalityPage) map {
    answer =>
      Row(
        key     = Key(msg"knownCountryOfNationality.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(yesOrNo(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.KnownCountryOfNationalityController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"knownCountryOfNationality.checkYourAnswersLabel"))
          )
        )
      )
  }

  def countryOfResidency: Option[Row] = userAnswers.get(CountryOfResidencyPage) map {
    answer =>
      Row(
        key     = Key(msg"countryOfResidency.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(country(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.CountryOfResidencyController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"countryOfResidency.checkYourAnswersLabel"))
          )
        )
      )
  }

  def countryOfNationality: Option[Row] = userAnswers.get(CountryOfNationalityPage) map {
    answer =>
      Row(
        key     = Key(msg"countryOfNationality.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(country(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.CountryOfNationalityController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"countryOfNationality.checkYourAnswersLabel"))
          )
        )
      )
  }

  def knownDateOfBirth: Option[Row] = userAnswers.get(KnownDateOfBirthPage) map {
    answer =>
      Row(
        key     = Key(msg"knownDateOfBirth.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(yesOrNo(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.KnownDateOfBirthController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"knownDateOfBirth.checkYourAnswersLabel"))
          )
        )
      )
  }

  def individualsName: Option[Row] = userAnswers.get(IndividualsNamePage) map {
    answer =>
      Row(
        key     = Key(msg"individualsName.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(name(answer)),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.IndividualsNameController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"individualsName.checkYourAnswersLabel"))
          )
        )
      )
  }

  def dateOfBirth: Option[Row] = userAnswers.get(DateOfBirthPage) map {
    answer =>
      Row(
        key     = Key(msg"dateOfBirth.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(Literal(answer.format(dateFormatter))),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.DateOfBirthController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"dateOfBirth.checkYourAnswersLabel"))
          )
        )
      )
  }

  def typeOfBeneficiary: Option[Row] = userAnswers.get(TypeOfBeneficiaryPage) map {
    answer =>
      Row(
        key     = Key(msg"typeOfBeneficiary.checkYourAnswersLabel", classes = Seq("govuk-!-width-one-half")),
        value   = Value(msg"typeOfBeneficiary.$answer"),
        actions = List(
          Action(
            content            = msg"site.edit",
            href               = routes.TypeOfBeneficiaryController.onPageLoad(CheckMode).url,
            visuallyHiddenText = Some(msg"site.edit.hidden".withArgs(msg"typeOfBeneficiary.checkYourAnswersLabel"))
          )
        )
      )
  }

  private def country(code: String): Content =
    lit"${countryService.getCountryByCode(code).getOrElse("")}"

  private def name(answer: Name): Content =
    lit"${answer.firstName} ${answer.middleName.map(s => s.concat(" ")).getOrElse("")}${answer.lastName}"

  private def yesOrNo(answer: Boolean): Content =
    if (answer) {
      msg"site.yes"
    } else {
      msg"site.no"
    }

  private def descriptionHtml(x: List[Option[String]]): Html = {

    val ifBullet = if (flatList.size == 1) "<ul class=\"list\">" else "<ul class=\"list list-bullet\">"

    def flatList = x.flatten

    if(flatList.length > 1) {
      Html(
        ifBullet + flatList.map(value =>
          "<li>" + value + "</li>"
        ).mkString("</li>") + "</ul>"
      )
    } else {
      Html(
        ifBullet + flatList.map(value =>
          "<p>" + value + "</p>"
        ).mkString("")
      )
    }
  }

  private def descriptionAsList(desc: Description) = {
    List(
      Some(desc.descriptionOne),
      desc.descriptionTwo,
      desc.descriptionThree,
      desc.descriptionFour,
      desc.descriptionFive
    )
  }
}

object CheckYourAnswersHelper {

  private val dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
}
