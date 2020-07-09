package pages

import pages.behaviours.PageBehaviours

class KnownDateOfBirthPageSpec extends PageBehaviours {

  "KnownDateOfBirthPage" - {

    beRetrievable[Boolean](KnownDateOfBirthPage)

    beSettable[Boolean](KnownDateOfBirthPage)

    beRemovable[Boolean](KnownDateOfBirthPage)
  }
}
