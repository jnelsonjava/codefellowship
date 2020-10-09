# Code Fellowship

We connect coders. And we protect their login information with Spring Security.

## Running App

In order to get the app running, go to the [Github Repo](https://github.com/jnelsonjava/codefellowship) and get the clone link from the "Code" dropdown menu.

Navigate in your terminal to where you would like to copy the app locally and run `git clone <insert-Github-link-here`.

From there you'll need to set up a Postgresql database named "codefellowship". And to connect to it, edit the "application.properties" file found in "src/main/resources/".

In "application.properties", replace `<username>` and `<password>` with your Postgres username and password.

And with that, you should be set to run the app! In your terminal, enter `./gradlew bootRun` and open up http://localhost:8080/.

Enjoy!

## Attributions

 - Reference for "if and" statements in thymeleaf - https://stackoverflow.com/questions/16018577/how-to-have-multiple-condition-in-an-thif-tag-using-thymeleaf

