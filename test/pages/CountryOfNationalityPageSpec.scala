package pages

import pages.behaviours.PageBehaviours


class CountryOfNationalityPageSpec extends PageBehaviours {

  "CountryOfNationalityPage" - {

    beRetrievable[String](CountryOfNationalityPage)

    beSettable[String](CountryOfNationalityPage)

    beRemovable[String](CountryOfNationalityPage)
  }
}
