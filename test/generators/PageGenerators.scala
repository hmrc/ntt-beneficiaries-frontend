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

import org.scalacheck.Arbitrary
import pages._

trait PageGenerators {

  implicit lazy val arbitraryKnownCountryPage: Arbitrary[KnownCountryPage.type] =
    Arbitrary(KnownCountryPage)

  implicit lazy val arbitraryCountryPage: Arbitrary[CountryPage.type] =
    Arbitrary(CountryPage)

  implicit lazy val arbitraryOtherDescriptionPage: Arbitrary[OtherDescriptionPage.type] =
    Arbitrary(OtherDescriptionPage)

  implicit lazy val arbitraryDescriptionPage: Arbitrary[DescriptionPage.type] =
    Arbitrary(DescriptionPage)

  implicit lazy val arbitraryCountryInUKPage: Arbitrary[CountryInUKPage.type] =
    Arbitrary(CountryInUKPage)

  implicit lazy val arbitraryUnidentifiedDescriptionPage: Arbitrary[UnidentifiedDescriptionPage.type] =
    Arbitrary(UnidentifiedDescriptionPage)

  implicit lazy val arbitraryTrustNamePage: Arbitrary[TrustNamePage.type] =
    Arbitrary(TrustNamePage)

  implicit lazy val arbitraryNumberOfBeneficiariesPage: Arbitrary[NumberOfBeneficiariesPage.type] =
    Arbitrary(NumberOfBeneficiariesPage)

  implicit lazy val arbitraryLargeNumberNamePage: Arbitrary[LargeNumberNamePage.type] =
    Arbitrary(LargeNumberNamePage)

  implicit lazy val arbitraryCompanyNamePage: Arbitrary[CompanyNamePage.type] =
    Arbitrary(CompanyNamePage)

  implicit lazy val arbitraryCharityNamePage: Arbitrary[CharityNamePage.type] =
    Arbitrary(CharityNamePage)

  implicit lazy val arbitraryLegallyIncapablePage: Arbitrary[LegallyIncapablePage.type] =
    Arbitrary(LegallyIncapablePage)

  implicit lazy val arbitraryKnownCountryOfResidencyPage: Arbitrary[KnownCountryOfResidencyPage.type] =
    Arbitrary(KnownCountryOfResidencyPage)

  implicit lazy val arbitraryKnownCountryOfNationalityPage: Arbitrary[KnownCountryOfNationalityPage.type] =
    Arbitrary(KnownCountryOfNationalityPage)

  implicit lazy val arbitraryCountryOfResidencyPage: Arbitrary[CountryOfResidencyPage.type] =
    Arbitrary(CountryOfResidencyPage)

  implicit lazy val arbitraryCountryOfNationalityPage: Arbitrary[CountryOfNationalityPage.type] =
    Arbitrary(CountryOfNationalityPage)

  implicit lazy val arbitraryKnownDateOfBirthPage: Arbitrary[KnownDateOfBirthPage.type] =
    Arbitrary(KnownDateOfBirthPage)

  implicit lazy val arbitraryIndividualsNamePage: Arbitrary[IndividualsNamePage.type] =
    Arbitrary(IndividualsNamePage)

  implicit lazy val arbitraryDateOfBirthPage: Arbitrary[DateOfBirthPage.type] =
    Arbitrary(DateOfBirthPage)

  implicit lazy val arbitraryTypeOfBeneficiaryPage: Arbitrary[TypeOfBeneficiaryPage.type] =
    Arbitrary(TypeOfBeneficiaryPage)
}
