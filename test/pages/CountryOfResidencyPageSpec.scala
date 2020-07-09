package pages

import pages.behaviours.PageBehaviours


class CountryOfResidencyPageSpec extends PageBehaviours {

  "CountryOfResidencyPage" - {

    beRetrievable[String](CountryOfResidencyPage)

    beSettable[String](CountryOfResidencyPage)

    beRemovable[String](CountryOfResidencyPage)
  }
}
