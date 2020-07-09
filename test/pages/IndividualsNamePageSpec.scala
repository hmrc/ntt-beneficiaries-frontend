package pages

import pages.behaviours.PageBehaviours


class IndividualsNamePageSpec extends PageBehaviours {

  "IndividualsNamePage" - {

    beRetrievable[String](IndividualsNamePage)

    beSettable[String](IndividualsNamePage)

    beRemovable[String](IndividualsNamePage)
  }
}
