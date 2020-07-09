package pages

import models.TypeOfBeneficiary
import pages.behaviours.PageBehaviours

class TypeOfBeneficiarySpec extends PageBehaviours {

  "TypeOfBeneficiaryPage" - {

    beRetrievable[TypeOfBeneficiary](TypeOfBeneficiaryPage)

    beSettable[TypeOfBeneficiary](TypeOfBeneficiaryPage)

    beRemovable[TypeOfBeneficiary](TypeOfBeneficiaryPage)
  }
}
