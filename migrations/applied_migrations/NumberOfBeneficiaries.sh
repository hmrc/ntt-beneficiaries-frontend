#!/bin/bash

echo ""
echo "Applying migration NumberOfBeneficiaries"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /numberOfBeneficiaries                        controllers.NumberOfBeneficiariesController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /numberOfBeneficiaries                        controllers.NumberOfBeneficiariesController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeNumberOfBeneficiaries                  controllers.NumberOfBeneficiariesController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeNumberOfBeneficiaries                  controllers.NumberOfBeneficiariesController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "numberOfBeneficiaries.title = Number of Beneficiaries in the class" >> ../conf/messages.en
echo "numberOfBeneficiaries.heading = Number of Beneficiaries in the class" >> ../conf/messages.en
echo "numberOfBeneficiaries.oneToOneHundred = 1 to 100" >> ../conf/messages.en
echo "numberOfBeneficiaries.oneHundredToTwoHundred = 101 to 200" >> ../conf/messages.en
echo "numberOfBeneficiaries.checkYourAnswersLabel = Number of Beneficiaries in the class" >> ../conf/messages.en
echo "numberOfBeneficiaries.error.required = Select numberOfBeneficiaries" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryNumberOfBeneficiariesUserAnswersEntry: Arbitrary[(NumberOfBeneficiariesPage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[NumberOfBeneficiariesPage.type]";\
    print "        value <- arbitrary[NumberOfBeneficiaries].map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryNumberOfBeneficiariesPage: Arbitrary[NumberOfBeneficiariesPage.type] =";\
    print "    Arbitrary(NumberOfBeneficiariesPage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to ModelGenerators"
awk '/trait ModelGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryNumberOfBeneficiaries: Arbitrary[NumberOfBeneficiaries] =";\
    print "    Arbitrary {";\
    print "      Gen.oneOf(NumberOfBeneficiaries.values.toSeq)";\
    print "    }";\
    next }1' ../test/generators/ModelGenerators.scala > tmp && mv tmp ../test/generators/ModelGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(NumberOfBeneficiariesPage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class CheckYourAnswersHelper/ {\
     print;\
     print "";\
     print "  def numberOfBeneficiaries: Option[Row] = userAnswers.get(NumberOfBeneficiariesPage) map {";\
     print "    answer =>";\
     print "      Row(";\
     print "        key     = Key(msg\"numberOfBeneficiaries.checkYourAnswersLabel\", classes = Seq(\"govuk-!-width-one-half\")),";\
     print "        value   = Value(msg\"numberOfBeneficiaries.$answer\"),";\
     print "        actions = List(";\
     print "          Action(";\
     print "            content            = msg\"site.edit\",";\
     print "            href               = routes.NumberOfBeneficiariesController.onPageLoad(CheckMode).url,";\
     print "            visuallyHiddenText = Some(msg\"site.edit.hidden\".withArgs(msg\"numberOfBeneficiaries.checkYourAnswersLabel\"))";\
     print "          )";\
     print "        )";\
     print "      )";\
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration NumberOfBeneficiaries completed"
