package pages

import pages.behaviours.PageBehaviours


class CompanyNamePageSpec extends PageBehaviours {

  "CompanyNamePage" - {

    beRetrievable[String](CompanyNamePage)

    beSettable[String](CompanyNamePage)

    beRemovable[String](CompanyNamePage)
  }
}
