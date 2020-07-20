#!/bin/bash

echo ""
echo "Applying migration LegallyIncapable"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /legallyIncapable                        controllers.LegallyIncapableController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /legallyIncapable                        controllers.LegallyIncapableController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeLegallyIncapable                  controllers.LegallyIncapableController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeLegallyIncapable                  controllers.LegallyIncapableController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "legallyIncapable.title = legallyIncapable" >> ../conf/messages.en
echo "legallyIncapable.heading = legallyIncapable" >> ../conf/messages.en
echo "legallyIncapable.checkYourAnswersLabel = legallyIncapable" >> ../conf/messages.en
echo "legallyIncapable.error.required = Select yes if legallyIncapable" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryLegallyIncapableUserAnswersEntry: Arbitrary[(LegallyIncapablePage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[LegallyIncapablePage.type]";\
    print "        value <- arbitrary[Boolean].map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryLegallyIncapablePage: Arbitrary[LegallyIncapablePage.type] =";\
    print "    Arbitrary(LegallyIncapablePage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(LegallyIncapablePage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class CheckYourAnswersHelper/ {\
     print;\
     print "";\
     print "  def legallyIncapable: Option[Row] = userAnswers.get(LegallyIncapablePage) map {";\
     print "    answer =>";\
     print "      Row(";\
     print "        key     = Key(msg\"legallyIncapable.checkYourAnswersLabel\", classes = Seq(\"govuk-!-width-one-half\")),";\
     print "        value   = Value(yesOrNo(answer)),";\
     print "        actions = List(";\
     print "          Action(";\
     print "            content            = msg\"site.edit\",";\
     print "            href               = routes.LegallyIncapableController.onPageLoad(CheckMode).url,";\
     print "            visuallyHiddenText = Some(msg\"site.edit.hidden\".withArgs(msg\"legallyIncapable.checkYourAnswersLabel\"))";\
     print "          )";\
     print "        )";\
     print "      )";\
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration LegallyIncapable completed"
