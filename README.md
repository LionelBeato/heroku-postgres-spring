# heroku-postgres-spring

- Deployed app: https://arcane-savannah-09879.herokuapp.com/


## How to implement Heroku-Postgres with a Spring Boot App

1. Initialize your application with the following dependencies:

2. Make sure you have all the appropriate MVC-related classes. In your controller, make sure you have `Post` Method.
3. Go to your project's root and add the file `system.properties` with the following line:

    ```
    java.runtime.version=11
    ```

4. In your application.properties, add in the following lines:

    ```
    spring.datasource.url=${SPRING_DATA_URL}
    spring.datasource.username=${SPRING_DATA_USERNAME}
    spring.datasource.password=${SPRING_DATA_PASSWORD}
    spring.jpa.show-sql=false
    spring.jpa.generate-ddl=true
    spring.jpa.hibernate.ddl-auto=${SPRING_JPA_HIBERNATE_DDL-AUTO}
    
    server.port=${PORT:8080}
    
    # this tells spring that we're using postgresql
    spring.datasource.platform=${SPRING_JPA_DATABASE-PLATFORM}
    
    # specifies the driver used
    spring.datasource.driver-class-name=org.postgresql.Driver
    
    # enforces a SQL dialect
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    
    # enabling the h2 console for quick viewing of our database
    spring.h2.console.enabled=true
    spring.h2.console.settings.web-allow-others=true
    ```
   
5. `git init` inside of your projects root, `git add .`, and `git commit`. 
6. Create a GitHub repo for your project and push your local repository to Github. 
7. On Heroku, go to your dashboard and click on *New > Create New App.*
8. Feel free to add a name if you want to. Heroku will generate one for you regardless.
9. Click on your app on your dashboard. YOu should now be in your app's *Overview* section.
10. Now we need to connect your GitHub repo with your Heroku app. Go to the *Deploy* page for your app on Heroku and scroll down. There should be a section for *Deployment Method*. Click on the GitHub option. It may now prompt you to connect your GitHub. Go ahead and connect it. You should now be able to search for your project's repository. Do so and select it. 
11. Once that's done you have the option to set up automatic deployments if you'd like. However, you always have the ability to manually deploy from this screen. 
12. Go back to *Overview*. Under *Installed add-ons*, there should be a section with *Heroku-Postgres*. Click on that. 
13. The link should take you to your database's overview page. Here, click on *Settings* and then *View Credentials*. Take note of this information as it will be important later.
14. Go back to your Project page and navigate to *Settings*. There should be a section called *Config Vars*. Click on *Reveal Config Vars*.
15. You should now see a section that will allow you to input config variables. Follow these instructions:

    <blockquote>
    
    Click on Reveal Config Vars and create the following Environment Variables:
     
     1. SPRING_DATASOURCE_URL = jdbc:postgresql://YourPostgresHerokuHostNameHere:5432/YourPostgresHerokuDatabaseNameHere (mind the leading jdbc: and the ql addition to postgres!)
     
     2. SPRING_DATASOURCE_USERNAME = YourPostgresHerokuUserNameHere
     3. SPRING_DATASOURCE_PASSWORD = YourPostgresHerokuPasswordHere
     4. SPRING_DATASOURCE_DRIVER-CLASS-NAME= org.postgresql.Driver (this isn´t always needed since Spring Boot can deduce it for most databases from the url, just for completeness here)
     5. SPRING_JPA_DATABASE-PLATFORM = org.hibernate.dialect.PostgreSQLDialect
     6. SPRING_DATASOURCE_TYPE = org.apache.tomcat.jdbc.pool.DataSource
     7. SPRING_JPA_HIBERNATE_DDL-AUTO = update (this will automatically create your tables according to your JPA entities, which is really great - since you don´t need to hurdle with CREATE SQL statements or DDL files)
     
     </blockquote>
     
16. With every config var created, your application on heroku will reload. Check to see if a CRUD action associated with your app works correctly. If it does, you can check your database by navigating to your ~/h2-console or by simply making a get call. 
     
     
## Notes

- If anything is confusing or wrong please feel free to let me know or open a pull request. 
- The source code for the project is in this repo. Don't be afraid to reference it!  

## References 

- This guide's inspired by the following stackoverflow thread: https://stackoverflow.com/questions/33633243/connecting-to-heroku-postgres-from-spring-boot
