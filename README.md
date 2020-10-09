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
 - Reference for serving static resources in Spring 2 - https://stackoverflow.com/questions/24916894/serving-static-web-resources-in-spring-boot-spring-security-application
 - Reference for @Service annotation - https://stackoverflow.com/questions/40384056/consider-defining-a-bean-of-type-package-in-your-configuration-spring-boot
 - Reference for principal - https://www.thymeleaf.org/doc/articles/layouts.html
 - Reference for redirecting a POST request to a POST route - https://www.baeldung.com/spring-redirect-and-forward
 - Reference for date conversion - https://www.javatpoint.com/java-sql-date
 - Reference for getting a current timestamp into DB - https://alvinalexander.com/java/java-current-date-example-now/
 - Reference for FlexBox - https://css-tricks.com/snippets/css/a-guide-to-flexbox/
