#!/bin/bash

echo ""
echo "Applying migration TypeOfBeneficiary"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /typeOfBeneficiary                        controllers.TypeOfBeneficiaryController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /typeOfBeneficiary                        controllers.TypeOfBeneficiaryController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeTypeOfBeneficiary                  controllers.TypeOfBeneficiaryController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeTypeOfBeneficiary                  controllers.TypeOfBeneficiaryController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "typeOfBeneficiary.title = Type of Beneficiary" >> ../conf/messages.en
echo "typeOfBeneficiary.heading = Type of Beneficiary" >> ../conf/messages.en
echo "typeOfBeneficiary.individual = Individual" >> ../conf/messages.en
echo "typeOfBeneficiary.unidentified = Unidentied Class" >> ../conf/messages.en
echo "typeOfBeneficiary.checkYourAnswersLabel = Type of Beneficiary" >> ../conf/messages.en
echo "typeOfBeneficiary.error.required = Select typeOfBeneficiary" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryTypeOfBeneficiaryUserAnswersEntry: Arbitrary[(TypeOfBeneficiaryPage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[TypeOfBeneficiaryPage.type]";\
    print "        value <- arbitrary[TypeOfBeneficiary].map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryTypeOfBeneficiaryPage: Arbitrary[TypeOfBeneficiaryPage.type] =";\
    print "    Arbitrary(TypeOfBeneficiaryPage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to ModelGenerators"
awk '/trait ModelGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryTypeOfBeneficiary: Arbitrary[TypeOfBeneficiary] =";\
    print "    Arbitrary {";\
    print "      Gen.oneOf(TypeOfBeneficiary.values.toSeq)";\
    print "    }";\
    next }1' ../test/generators/ModelGenerators.scala > tmp && mv tmp ../test/generators/ModelGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(TypeOfBeneficiaryPage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class CheckYourAnswersHelper/ {\
     print;\
     print "";\
     print "  def typeOfBeneficiary: Option[Row] = userAnswers.get(TypeOfBeneficiaryPage) map {";\
     print "    answer =>";\
     print "      Row(";\
     print "        key     = Key(msg\"typeOfBeneficiary.checkYourAnswersLabel\", classes = Seq(\"govuk-!-width-one-half\")),";\
     print "        value   = Value(msg\"typeOfBeneficiary.$answer\"),";\
     print "        actions = List(";\
     print "          Action(";\
     print "            content            = msg\"site.edit\",";\
     print "            href               = routes.TypeOfBeneficiaryController.onPageLoad(CheckMode).url,";\
     print "            visuallyHiddenText = Some(msg\"site.edit.hidden\".withArgs(msg\"typeOfBeneficiary.checkYourAnswersLabel\"))";\
     print "          )";\
     print "        )";\
     print "      )";\
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration TypeOfBeneficiary completed"
