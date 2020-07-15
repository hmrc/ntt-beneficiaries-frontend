#!/bin/bash

echo ""
echo "Applying migration InterruptInfo"

echo "Adding routes to conf/app.routes"
echo "" >> ../conf/app.routes
echo "GET        /interruptInfo                       controllers.InterruptInfoController.onPageLoad()" >> ../conf/app.routes

echo "Adding messages to conf.messages"
echo "" >> ../conf/messages.en
echo "interruptInfo.title = interruptInfo" >> ../conf/messages.en
echo "interruptInfo.heading = interruptInfo" >> ../conf/messages.en

echo "Migration InterruptInfo completed"
