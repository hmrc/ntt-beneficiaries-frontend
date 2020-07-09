#!/bin/bash

echo ""
echo "Applying migration CountryOfNationality"

echo "Adding routes to conf/app.routes"

echo "" >> ../conf/app.routes
echo "GET        /countryOfNationality                        controllers.CountryOfNationalityController.onPageLoad(mode: Mode = NormalMode)" >> ../conf/app.routes
echo "POST       /countryOfNationality                        controllers.CountryOfNationalityController.onSubmit(mode: Mode = NormalMode)" >> ../conf/app.routes

echo "GET        /changeCountryOfNationality                  controllers.CountryOfNationalityController.onPageLoad(mode: Mode = CheckMode)" >> ../conf/app.routes
echo "POST       /changeCountryOfNationality                  controllers.CountryOfNationalityController.onSubmit(mode: Mode = CheckMode)" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "countryOfNationality.title = countryOfNationality" >> ../conf/messages.en
echo "countryOfNationality.heading = countryOfNationality" >> ../conf/messages.en
echo "countryOfNationality.checkYourAnswersLabel = countryOfNationality" >> ../conf/messages.en
echo "countryOfNationality.error.required = Enter countryOfNationality" >> ../conf/messages.en
echo "countryOfNationality.error.length = CountryOfNationality must be 100 characters or less" >> ../conf/messages.en

echo "Adding to UserAnswersEntryGenerators"
awk '/trait UserAnswersEntryGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryCountryOfNationalityUserAnswersEntry: Arbitrary[(CountryOfNationalityPage.type, JsValue)] =";\
    print "    Arbitrary {";\
    print "      for {";\
    print "        page  <- arbitrary[CountryOfNationalityPage.type]";\
    print "        value <- arbitrary[String].suchThat(_.nonEmpty).map(Json.toJson(_))";\
    print "      } yield (page, value)";\
    print "    }";\
    next }1' ../test/generators/UserAnswersEntryGenerators.scala > tmp && mv tmp ../test/generators/UserAnswersEntryGenerators.scala

echo "Adding to PageGenerators"
awk '/trait PageGenerators/ {\
    print;\
    print "";\
    print "  implicit lazy val arbitraryCountryOfNationalityPage: Arbitrary[CountryOfNationalityPage.type] =";\
    print "    Arbitrary(CountryOfNationalityPage)";\
    next }1' ../test/generators/PageGenerators.scala > tmp && mv tmp ../test/generators/PageGenerators.scala

echo "Adding to UserAnswersGenerator"
awk '/val generators/ {\
    print;\
    print "    arbitrary[(CountryOfNationalityPage.type, JsValue)] ::";\
    next }1' ../test/generators/UserAnswersGenerator.scala > tmp && mv tmp ../test/generators/UserAnswersGenerator.scala

echo "Adding helper method to CheckYourAnswersHelper"
awk '/class CheckYourAnswersHelper/ {\
     print;\
     print "";\
     print "  def countryOfNationality: Option[Row] = userAnswers.get(CountryOfNationalityPage) map {";\
     print "    answer =>";\
     print "      Row(";\
     print "        key     = Key(msg\"countryOfNationality.checkYourAnswersLabel\", classes = Seq(\"govuk-!-width-one-half\")),";\
     print "        value   = Value(lit\"$answer\"),";\
     print "        actions = List(";\
     print "          Action(";\
     print "            content            = msg\"site.edit\",";\
     print "            href               = routes.CountryOfNationalityController.onPageLoad(CheckMode).url,";\
     print "            visuallyHiddenText = Some(msg\"site.edit.hidden\".withArgs(msg\"countryOfNationality.checkYourAnswersLabel\"))";\
     print "          )";\
     print "        )";\
     print "      )";\
     print "  }";\
     next }1' ../app/utils/CheckYourAnswersHelper.scala > tmp && mv tmp ../app/utils/CheckYourAnswersHelper.scala

echo "Migration CountryOfNationality completed"
