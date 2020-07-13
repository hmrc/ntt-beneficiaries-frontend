package pages

import pages.behaviours.PageBehaviours


class CountryPageSpec extends PageBehaviours {

  "CountryPage" - {

    beRetrievable[String](CountryPage)

    beSettable[String](CountryPage)

    beRemovable[String](CountryPage)
  }
}
