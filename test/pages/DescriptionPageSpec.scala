package pages

import pages.behaviours.PageBehaviours


class DescriptionPageSpec extends PageBehaviours {

  "DescriptionPage" - {

    beRetrievable[String](DescriptionPage)

    beSettable[String](DescriptionPage)

    beRemovable[String](DescriptionPage)
  }
}
