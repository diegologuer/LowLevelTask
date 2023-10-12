# Task 2

## Task Instructions
Create a Spring Boot application to manage a simple inventory system for a store. The system should allow users to view a list of available products, add new products, and update existing ones. 
Each product should have a name, description, price, and quantity. Use Hibernate to persist the product information in a MySQL database.

## Run Instructions
1. Import the project as a Maven project in an IDE.
2. In order to run the project some requirements are requested:
   - MySQL must be installed and running, create a db called lowleveltask.
   - Maven should be isntalled in the OS.
3. Run the program from the route: `/LowLevelTask/src/main/java/com/Task/LowLevelTask/LowLevelTaskApplication.java` as a java application.

## Additional instructions
- In order to run the tests go to `/LowLevelTask/src/test/java/com/Task/LowLevelTask/LowLevelApplicationTests.java` and run it as JUnit test.
- JaCoCo is used for code coverage.
  - In order to use it open a Terminal in the project route and excecute `mvn clean test` and then `mvn jacoco:report`.
  - To check results go to `LowLevelTask\target\site` and open index.html.
- SonarQube is used for complexity and style, in order to monitor tests please replace the ´token´
  from the file `/LowLevelTask/src/main/resources/application.properties`.

## Feedback
- Was it easy to complete the task using AI?
  Some basic knodelge of springboot is required to make the code work. It is not simple without springboot knoledge. 
- How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics)
  About 3 hours.
- Was the code ready to run after generation? What did you have to change to make it usable?
  I had to ask chatGPT for more details of every step, some information is missing and had some errors before running the code succesfully.
- Which challenges did you face during completion of the task?
  It was important to understand the code before using it, and not all the code was simple to understand.
- Which specific prompts you learned as a good practice to complete the task?
  Used examples, be specific, refer to previous outputs, keeping the context.

   
