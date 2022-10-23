# Lesson 19: Using an External Property File

## Overview

The application configuration is different in different environments. To use different configurations in different environments, a property file is used to externalize the values for each environment.

## Demonstrated Concepts

### `application-properties` file

The application-properties file is a text file that defines the key-value pair for a property. The name of the property follows a convention where the class name is used with the property name to disambiguate properties with the same name in different classes.

In this lesson, we create a variable `favoriteMovie` in `RecommenderImplementation` class for the input string as follows:

```java
String favoriteMovie = "Finding Dory";

public String getFavoriteMovie() {
    return favoriteMovie;
}

//...
```

We will dynamically fetch the value of `favoriteMovie` from a property file. To make sure that the value has been read from the file, we create a getter method `getFavoriteMovie` that returns the value read.

We will create a file called `app.properties` in __src/main/resources__ and define a value for `favoriteMovie` in it. Every line in this file defines a value for a property key using the equality (=) sign. As per convention, the fully-qualified name of the variable should be used.

```properties
recommender.implementation.favoriteMovie = Finding Dory
```

### `@Value`

We can now dynamically fetch the `favoriteMovie` value from `app.properties` file using the `@Value` annotation. This annotation can be used with the constructor or setter method. It can also be used directly on the variable using the following syntax:

```java
@Value("＄{recommender.implementation.favoriteMovie}")
String favoriteMovie;
```

If the property value is not found in `app.properties` file, Spring throws the `IllegalArgumentException`. One way to avoid this exception is to provide a default value for the property:

```java
@Value("＄{recommender.implementation.favoriteMovie: Spirited Away}")
String favoriteMovie;
```

Now, if the `favoriteMovie` property is commented out in the `app.properties` file using the `#` symbol, its default value will be read.

### `@PropertySource`

In the `MovieRecommenderSystemApplication` method, we will mention the name of the file from where to fetch the value using the `@PropertySource` annotation. By default, Spring loads the property file from the classpath. Since our file is in __src/main/resources__, we will use `classpath:app.properties`. The `getFavoriteMovie` method will print the value read from the property file.

```java
@SpringBootApplication
  
 @PropertySource("classpath:app.properties")
public class MovieRecommenderSystemApplication {
    public static void main(String[] args) {
		
        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
		
        String favoriteMovie = recommender.getFavoriteMovie();
        System.out.println(favoriteMovie);
    }
}
```

If the code given below is executed, our application will run as usual after reading the value from the property file. This gives us the freedom to change the value of `favoriteMovie` in the `app.properties` file without having to make changes to the source code.

<img src="./images/img1.png" width="500">