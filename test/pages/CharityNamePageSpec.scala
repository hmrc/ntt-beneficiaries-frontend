package pages

import pages.behaviours.PageBehaviours


class CharityNamePageSpec extends PageBehaviours {

  "CharityNamePage" - {

    beRetrievable[String](CharityNamePage)

    beSettable[String](CharityNamePage)

    beRemovable[String](CharityNamePage)
  }
}
