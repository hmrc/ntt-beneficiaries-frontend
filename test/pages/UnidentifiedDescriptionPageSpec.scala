package pages

import pages.behaviours.PageBehaviours


class UnidentifiedDescriptionPageSpec extends PageBehaviours {

  "UnidentifiedDescriptionPage" - {

    beRetrievable[String](UnidentifiedDescriptionPage)

    beSettable[String](UnidentifiedDescriptionPage)

    beRemovable[String](UnidentifiedDescriptionPage)
  }
}
