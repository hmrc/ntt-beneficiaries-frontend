package generators

import models._
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.{Arbitrary, Gen}

trait ModelGenerators {

  implicit lazy val arbitraryTypeOfBeneficiary: Arbitrary[TypeOfBeneficiary] =
    Arbitrary {
      Gen.oneOf(TypeOfBeneficiary.values.toSeq)
    }
}
