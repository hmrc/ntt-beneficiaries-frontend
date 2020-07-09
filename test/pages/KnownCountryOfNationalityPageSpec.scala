package pages

import pages.behaviours.PageBehaviours

class KnownCountryOfNationalityPageSpec extends PageBehaviours {

  "KnownCountryOfNationalityPage" - {

    beRetrievable[Boolean](KnownCountryOfNationalityPage)

    beSettable[Boolean](KnownCountryOfNationalityPage)

    beRemovable[Boolean](KnownCountryOfNationalityPage)
  }
}
