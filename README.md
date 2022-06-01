# Project_P2 - PokePals

## Description
Pokemon is probably is the most famous anime franshise accross the globe. Worth over USD $99 billion. The idea with this was to create a social network whereby pokedex collectors can show-off their collection to the world. Our social network allows users to add pokemon to their collection and get comments from other pokemon users. Furthermore, the users can also add pokemons to their wishlist.

## User Stories for 
### Pokémon Pals
1.	A new user can register.
2.  A new user can also upload their profile image
2.	A new user can login.
3.  A user can see its own pokemon collection and comments on those collection.
4.  A user can see its own pokemon wishlist and comments on those wishlist.
5.  A user can see all the possible pokemons available from all the generations.
6.  A user can also search the pokemon by name.
7.  A user can add pokemon to their collection and wishlist.
8.  The pokemon added in the collection or in the wishlist must be unique. That is a user cannot add more than one pokemon of the same name in their collection or wishlist.
9. A user can make a comment on their own collection or wishlist.
10. A user can see all other pokepals on our network.
11. A user can view a specific pokepal's collections and all the associated comments made by other pokepal.
12. A user can view a specific pokepal's wishlist and all the associated comments made by other pokepal.
13. A user can make a comment on other pokepal's collection. The comment will be added and changes must be reflected in realtime. 
14. A user can make a comment on other pokepal's wishlist. The comment will be added and changes must be reflected in realtime.
15. A user can update profile details. including password.
16. A user can also update its profile picture as well. 
17. A user can logout. 

## Technologies/Frameworks Used
### Front-end
- Angular
- Bootstrap (for styling only)

### Back-end
- Java
- Spring boot
    - Web
    - Data (JPA)
- Lombok
- AWS RDS (postgres)
- AWS s3 buckets to store images
- H2 to test back-end service layer

## How to use this repo?
### Front-end
- The front-end has been seperated in the `UI` folder. 
- Simply install the necessary dependencies in your local environment and `ng serve` to fire up the angular app.

### Back-end
- The POM.xml (project) is on the root directory.
- You must make some adjustments to `application.properties`. Simply change the aws credentials to access 

```properties
server.port=9003 
<!-- User can change the port, default is 8080 -->

spring.servlet.multipart.max-file-size=10MB

#PSQL CONfig
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

# Everytime we change then the table will be updated, none would not run and .sql files
spring.jpa.hibernate.ddl-auto=none
spring.jpa.hibernate.show.sql=true

# this is our connection to the databse
spring.datasource.url=jdbc:postgresql://**<your AWS RDS database>**
spring.datasource.username=**<your AWS RDS database username, it is mostly postgres> **
spring.datasource.password=**<your AWS RDS database password>**
spring.datasource.initialization-mode=never

logging.level.org.springframework.context=DEBUG
``` 
- You must also make some adjustments to `AmazonConfig` in utility package
```java
@Configuration
public class AmazonConfig {

    @Bean //spring instantiates this at runtime.
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials("<insert your access ID>", "<insert your secret key>");
        return AmazonS3ClientBuilder.standard().withRegion("<insert-aws-region>") // like "us-east-1"
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }
}
```
- You must also make some changes in the `BucketName` class and change `PROFILE_IMAGE` and insert your s3 bucket name
```Java
package com.revature.project_p2.utility;

public enum BucketName {
    PROFILE_IMAGE("<your bucket name here>");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}

```
- For best user experience, the dimensions of the user images should not exceed 300px by 300px
