package pages

import pages.behaviours.PageBehaviours


class LargeNumberNamePageSpec extends PageBehaviours {

  "LargeNumberNamePage" - {

    beRetrievable[String](LargeNumberNamePage)

    beSettable[String](LargeNumberNamePage)

    beRemovable[String](LargeNumberNamePage)
  }
}
