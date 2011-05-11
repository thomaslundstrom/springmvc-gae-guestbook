Spring MVC on Google AppEngine lab
=========================

This repo contains code for a basic (really, basic) application built on Spring MVC to be published on Google AppEngine. No (unit|integration) tests yet.

Tested with Spring Framework version 3.0.5 and GAE version 1.4.3. 

Getting started:
  - Make sure the GAE plugin is installed as an Eclipse plugin.
  - Create new project in eclipse
  - rename war/WEB-INF/appengine-web-default.xml to appengine-web.xml
  - In appengine-web.xml, insert your application name
  - Start the project

TODO: (patches are accepted)
  - Maven-ify the project in order not to have to commit the jars into GitHub
  - Prettify the output
  - Implement ability to do content-negotiating and returning the correct Greeting
  - Implement json for the list of greetings
  - Inject the UserService into the GreetingsController
  - Implement caching