#!/bin/bash

echo ""
echo "Applying migration UnidentifiedDescription"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /unidentifiedDescription                        controllers.UnidentifiedDescriptionController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /unidentifiedDescription                        controllers.UnidentifiedDescriptionController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeUnidentifiedDescription                  controllers.UnidentifiedDescriptionController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeUnidentifiedDescription                  controllers.UnidentifiedDescriptionController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "unidentifiedDescription.title = unidentifiedDescription" >> ../conf/messages.en
echo "unidentifiedDescription.heading = unidentifiedDescription" >> ../conf/messages.en
echo "unidentifiedDescription.checkYourAnswersLabel = unidentifiedDescription" >> ../conf/messages.en
echo "unidentifiedDescription.error.required = Enter unidentifiedDescription" >> ../conf/messages.en
echo "unidentifiedDescription.error.length = UnidentifiedDescription must be 100 characters or less" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryUnidentifiedDescriptionUserAnswersEntry: Arbitrary[(UnidentifiedDescriptionPage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[UnidentifiedDescriptionPage.type]";\
    print "        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryUnidentifiedDescriptionPage: Arbitrary[UnidentifiedDescriptionPage.type] =";\
    print "    Arbitrary(UnidentifiedDescriptionPage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(UnidentifiedDescriptionPage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class CheckYourAnswersHelper/ {\
     print;\
     print "";\
     print "  def unidentifiedDescription: Option[Row] = userAnswers.get(UnidentifiedDescriptionPage) map {";\
     print "    answer =>";\
     print "      Row(";\
     print "        key     = Key(msg\"unidentifiedDescription.checkYourAnswersLabel\", classes = Seq(\"govuk-!-width-one-half\")),";\
     print "        value   = Value(lit\"$answer\"),";\
     print "        actions = List(";\
     print "          Action(";\
     print "            content            = msg\"site.edit\",";\
     print "            href               = routes.UnidentifiedDescriptionController.onPageLoad(CheckMode).url,";\
     print "            visuallyHiddenText = Some(msg\"site.edit.hidden\".withArgs(msg\"unidentifiedDescription.checkYourAnswersLabel\"))";\
     print "          )";\
     print "        )";\
     print "      )";\
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration UnidentifiedDescription completed"
