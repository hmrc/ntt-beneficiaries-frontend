package pages

import pages.behaviours.PageBehaviours


class WhichCountryPageSpec extends PageBehaviours {

  "WhichCountryPage" - {

    beRetrievable[String](WhichCountryPage)

    beSettable[String](WhichCountryPage)

    beRemovable[String](WhichCountryPage)
  }
}
