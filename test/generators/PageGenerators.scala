package generators

import org.scalacheck.Arbitrary
import pages._

trait PageGenerators {

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
