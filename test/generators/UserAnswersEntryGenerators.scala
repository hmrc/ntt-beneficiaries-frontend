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

import models._
import org.scalacheck.Arbitrary
import org.scalacheck.Arbitrary.arbitrary
import pages._
import play.api.libs.json.{JsValue, Json}

trait UserAnswersEntryGenerators extends PageGenerators with ModelGenerators {

  implicit lazy val arbitraryKnownCountryUserAnswersEntry: Arbitrary[(KnownCountryPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[KnownCountryPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryCountryUserAnswersEntry: Arbitrary[(CountryPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[CountryPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryOtherDescriptionUserAnswersEntry: Arbitrary[(OtherDescriptionPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[OtherDescriptionPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryDescriptionUserAnswersEntry: Arbitrary[(DescriptionPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[DescriptionPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryCountryInUKUserAnswersEntry: Arbitrary[(CountryInUKPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[CountryInUKPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryUnidentifiedDescriptionUserAnswersEntry: Arbitrary[(UnidentifiedDescriptionPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[UnidentifiedDescriptionPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryTrustNameUserAnswersEntry: Arbitrary[(TrustNamePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[TrustNamePage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryNumberOfBeneficiariesUserAnswersEntry: Arbitrary[(NumberOfBeneficiariesPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[NumberOfBeneficiariesPage.type]
        value <- arbitrary[NumberOfBeneficiaries].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryLargeNumberNameUserAnswersEntry: Arbitrary[(LargeNumberNamePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[LargeNumberNamePage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryCompanyNameUserAnswersEntry: Arbitrary[(CompanyNamePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[CompanyNamePage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryCharityNameUserAnswersEntry: Arbitrary[(CharityNamePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[CharityNamePage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryLegallyIncapableUserAnswersEntry: Arbitrary[(LegallyIncapablePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[LegallyIncapablePage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryKnownCountryOfResidencyUserAnswersEntry: Arbitrary[(KnownCountryOfResidencyPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[KnownCountryOfResidencyPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryKnownCountryOfNationalityUserAnswersEntry: Arbitrary[(KnownCountryOfNationalityPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[KnownCountryOfNationalityPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryCountryOfResidencyUserAnswersEntry: Arbitrary[(CountryOfResidencyPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[CountryOfResidencyPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryCountryOfNationalityUserAnswersEntry: Arbitrary[(CountryOfNationalityPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[CountryOfNationalityPage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryKnownDateOfBirthUserAnswersEntry: Arbitrary[(KnownDateOfBirthPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[KnownDateOfBirthPage.type]
        value <- arbitrary[Boolean].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryIndividualsNameUserAnswersEntry: Arbitrary[(IndividualsNamePage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[IndividualsNamePage.type]
        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryDateOfBirthUserAnswersEntry: Arbitrary[(DateOfBirthPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[DateOfBirthPage.type]
        value <- arbitrary[Int].map(Json.toJson(_))
      } yield (page, value)
    }

  implicit lazy val arbitraryTypeOfBeneficiaryUserAnswersEntry: Arbitrary[(TypeOfBeneficiaryPage.type, JsValue)] =
    Arbitrary {
      for {
        page  <- arbitrary[TypeOfBeneficiaryPage.type]
        value <- arbitrary[TypeOfBeneficiary].map(Json.toJson(_))
      } yield (page, value)
    }
}
