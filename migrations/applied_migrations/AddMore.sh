#!/bin/bash

echo ""
echo "Applying migration AddMore"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /addMore                        controllers.AddMoreController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /addMore                        controllers.AddMoreController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeAddMore                  controllers.AddMoreController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeAddMore                  controllers.AddMoreController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "addMore.title = addMore" >> ../conf/messages.en
echo "addMore.heading = addMore" >> ../conf/messages.en
echo "addMore.checkYourAnswersLabel = addMore" >> ../conf/messages.en
echo "addMore.error.required = Enter addMore" >> ../conf/messages.en
echo "addMore.error.length = AddMore must be 100 characters or less" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryAddMoreUserAnswersEntry: Arbitrary[(AddMorePage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[AddMorePage.type]";\
    print "        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryAddMorePage: Arbitrary[AddMorePage.type] =";\
    print "    Arbitrary(AddMorePage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(AddMorePage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class CheckYourAnswersHelper/ {\
     print;\
     print "";\
     print "  def addMore: Option[Row] = userAnswers.get(AddMorePage) map {";\
     print "    answer =>";\
     print "      Row(";\
     print "        key     = Key(msg\"addMore.checkYourAnswersLabel\", classes = Seq(\"govuk-!-width-one-half\")),";\
     print "        value   = Value(lit\"$answer\"),";\
     print "        actions = List(";\
     print "          Action(";\
     print "            content            = msg\"site.edit\",";\
     print "            href               = routes.AddMoreController.onPageLoad(CheckMode).url,";\
     print "            visuallyHiddenText = Some(msg\"site.edit.hidden\".withArgs(msg\"addMore.checkYourAnswersLabel\"))";\
     print "          )";\
     print "        )";\
     print "      )";\
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration AddMore completed"
