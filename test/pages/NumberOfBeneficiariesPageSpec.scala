package pages

import models.NumberOfBeneficiaries
import pages.behaviours.PageBehaviours

class NumberOfBeneficiariesSpec extends PageBehaviours {

  "NumberOfBeneficiariesPage" - {

    beRetrievable[NumberOfBeneficiaries](NumberOfBeneficiariesPage)

    beSettable[NumberOfBeneficiaries](NumberOfBeneficiariesPage)

    beRemovable[NumberOfBeneficiaries](NumberOfBeneficiariesPage)
  }
}
