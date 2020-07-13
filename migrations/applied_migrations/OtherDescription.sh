#!/bin/bash

echo ""
echo "Applying migration OtherDescription"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /otherDescription                        controllers.OtherDescriptionController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /otherDescription                        controllers.OtherDescriptionController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeOtherDescription                  controllers.OtherDescriptionController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeOtherDescription                  controllers.OtherDescriptionController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "otherDescription.title = otherDescription" >> ../conf/messages.en
echo "otherDescription.heading = otherDescription" >> ../conf/messages.en
echo "otherDescription.checkYourAnswersLabel = otherDescription" >> ../conf/messages.en
echo "otherDescription.error.required = Enter otherDescription" >> ../conf/messages.en
echo "otherDescription.error.length = OtherDescription must be 100 characters or less" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryOtherDescriptionUserAnswersEntry: Arbitrary[(OtherDescriptionPage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[OtherDescriptionPage.type]";\
    print "        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryOtherDescriptionPage: Arbitrary[OtherDescriptionPage.type] =";\
    print "    Arbitrary(OtherDescriptionPage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(OtherDescriptionPage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class CheckYourAnswersHelper/ {\
     print;\
     print "";\
     print "  def otherDescription: Option[Row] = userAnswers.get(OtherDescriptionPage) map {";\
     print "    answer =>";\
     print "      Row(";\
     print "        key     = Key(msg\"otherDescription.checkYourAnswersLabel\", classes = Seq(\"govuk-!-width-one-half\")),";\
     print "        value   = Value(lit\"$answer\"),";\
     print "        actions = List(";\
     print "          Action(";\
     print "            content            = msg\"site.edit\",";\
     print "            href               = routes.OtherDescriptionController.onPageLoad(CheckMode).url,";\
     print "            visuallyHiddenText = Some(msg\"site.edit.hidden\".withArgs(msg\"otherDescription.checkYourAnswersLabel\"))";\
     print "          )";\
     print "        )";\
     print "      )";\
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration OtherDescription completed"
