package pages

import pages.behaviours.PageBehaviours


class AddMorePageSpec extends PageBehaviours {

  "AddMorePage" - {

    beRetrievable[String](AddMorePage)

    beSettable[String](AddMorePage)

    beRemovable[String](AddMorePage)
  }
}
