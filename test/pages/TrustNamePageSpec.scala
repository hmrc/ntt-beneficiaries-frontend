package pages

import pages.behaviours.PageBehaviours


class TrustNamePageSpec extends PageBehaviours {

  "TrustNamePage" - {

    beRetrievable[String](TrustNamePage)

    beSettable[String](TrustNamePage)

    beRemovable[String](TrustNamePage)
  }
}
