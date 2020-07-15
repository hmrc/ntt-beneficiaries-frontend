package pages

import pages.behaviours.PageBehaviours

class KnownCountryPageSpec extends PageBehaviours {

  "KnownCountryPage" - {

    beRetrievable[Boolean](KnownCountryPage)

    beSettable[Boolean](KnownCountryPage)

    beRemovable[Boolean](KnownCountryPage)
  }
}
