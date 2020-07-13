#!/bin/bash

echo ""
echo "Applying migration Country"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /country                        controllers.CountryController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /country                        controllers.CountryController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeCountry                  controllers.CountryController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeCountry                  controllers.CountryController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "country.title = country" >> ../conf/messages.en
echo "country.heading = country" >> ../conf/messages.en
echo "country.checkYourAnswersLabel = country" >> ../conf/messages.en
echo "country.error.required = Enter country" >> ../conf/messages.en
echo "country.error.length = Country must be 100 characters or less" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryCountryUserAnswersEntry: Arbitrary[(CountryPage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[CountryPage.type]";\
    print "        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryCountryPage: Arbitrary[CountryPage.type] =";\
    print "    Arbitrary(CountryPage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(CountryPage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class CheckYourAnswersHelper/ {\
     print;\
     print "";\
     print "  def country: Option[Row] = userAnswers.get(CountryPage) map {";\
     print "    answer =>";\
     print "      Row(";\
     print "        key     = Key(msg\"country.checkYourAnswersLabel\", classes = Seq(\"govuk-!-width-one-half\")),";\
     print "        value   = Value(lit\"$answer\"),";\
     print "        actions = List(";\
     print "          Action(";\
     print "            content            = msg\"site.edit\",";\
     print "            href               = routes.CountryController.onPageLoad(CheckMode).url,";\
     print "            visuallyHiddenText = Some(msg\"site.edit.hidden\".withArgs(msg\"country.checkYourAnswersLabel\"))";\
     print "          )";\
     print "        )";\
     print "      )";\
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration Country completed"
