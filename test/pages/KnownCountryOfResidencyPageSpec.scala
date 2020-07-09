package pages

import pages.behaviours.PageBehaviours

class KnownCountryOfResidencyPageSpec extends PageBehaviours {

  "KnownCountryOfResidencyPage" - {

    beRetrievable[Boolean](KnownCountryOfResidencyPage)

    beSettable[Boolean](KnownCountryOfResidencyPage)

    beRemovable[Boolean](KnownCountryOfResidencyPage)
  }
}
