package generators

import models.UserAnswers
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.TryValues
import pages._
import play.api.libs.json.{JsPath, JsValue, Json}

trait UserAnswersGenerator extends TryValues {
  self: Generators =>

  val generators: Seq[Gen[(QuestionPage[_], JsValue)]] =
    arbitrary[(UnidentifiedDescriptionPage.type, JsValue)] ::
    arbitrary[(TrustNamePage.type, JsValue)] ::
    arbitrary[(NumberOfBeneficiariesPage.type, JsValue)] ::
    arbitrary[(LargeNumberNamePage.type, JsValue)] ::
    arbitrary[(CompanyNamePage.type, JsValue)] ::
    arbitrary[(CharityNamePage.type, JsValue)] ::
    arbitrary[(LegallyIncapablePage.type, JsValue)] ::
    arbitrary[(KnownCountryOfResidencyPage.type, JsValue)] ::
    arbitrary[(KnownCountryOfNationalityPage.type, JsValue)] ::
    arbitrary[(CountryOfResidencyPage.type, JsValue)] ::
    arbitrary[(CountryOfNationalityPage.type, JsValue)] ::
    arbitrary[(KnownDateOfBirthPage.type, JsValue)] ::
    arbitrary[(IndividualsNamePage.type, JsValue)] ::
    arbitrary[(DateOfBirthPage.type, JsValue)] ::
    arbitrary[(TypeOfBeneficiaryPage.type, JsValue)] ::
    Nil

  implicit lazy val arbitraryUserData: Arbitrary[UserAnswers] = {

    import models._

    Arbitrary {
      for {
        id      <- nonEmptyString
        data    <- generators match {
          case Nil => Gen.const(Map[QuestionPage[_], JsValue]())
          case _   => Gen.mapOf(oneOf(generators))
        }
      } yield UserAnswers (
        id = id,
        data = data.foldLeft(Json.obj()) {
          case (obj, (path, value)) =>
            obj.setObject(path.path, value).get
        }
      )
    }
  }
}
