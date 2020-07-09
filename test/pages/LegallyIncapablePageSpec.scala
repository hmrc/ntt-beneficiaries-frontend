package pages

import pages.behaviours.PageBehaviours

class LegallyIncapablePageSpec extends PageBehaviours {

  "LegallyIncapablePage" - {

    beRetrievable[Boolean](LegallyIncapablePage)

    beSettable[Boolean](LegallyIncapablePage)

    beRemovable[Boolean](LegallyIncapablePage)
  }
}
