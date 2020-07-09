package generators

import org.scalacheck.Arbitrary
import pages._

trait PageGenerators {

  implicit lazy val arbitraryKnownDateOfBirthPage: Arbitrary[KnownDateOfBirthPage.type] =
    Arbitrary(KnownDateOfBirthPage)

  implicit lazy val arbitraryIndividualsNamePage: Arbitrary[IndividualsNamePage.type] =
    Arbitrary(IndividualsNamePage)

  implicit lazy val arbitraryDateOfBirthPage: Arbitrary[DateOfBirthPage.type] =
    Arbitrary(DateOfBirthPage)

  implicit lazy val arbitraryTypeOfBeneficiaryPage: Arbitrary[TypeOfBeneficiaryPage.type] =
    Arbitrary(TypeOfBeneficiaryPage)
}
