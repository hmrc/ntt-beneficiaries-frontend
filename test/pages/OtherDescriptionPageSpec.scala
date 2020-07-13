package pages

import pages.behaviours.PageBehaviours


class OtherDescriptionPageSpec extends PageBehaviours {

  "OtherDescriptionPage" - {

    beRetrievable[String](OtherDescriptionPage)

    beSettable[String](OtherDescriptionPage)

    beRemovable[String](OtherDescriptionPage)
  }
}
