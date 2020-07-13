package pages

import pages.behaviours.PageBehaviours

class CountryInUKPageSpec extends PageBehaviours {

  "CountryInUKPage" - {

    beRetrievable[Boolean](CountryInUKPage)

    beSettable[Boolean](CountryInUKPage)

    beRemovable[Boolean](CountryInUKPage)
  }
}
