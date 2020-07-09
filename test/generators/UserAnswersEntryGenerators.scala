package generators

import models._
import org.scalacheck.Arbitrary
import org.scalacheck.Arbitrary.arbitrary
import pages._
import play.api.libs.json.{JsValue, Json}

trait UserAnswersEntryGenerators extends PageGenerators with ModelGenerators {

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
