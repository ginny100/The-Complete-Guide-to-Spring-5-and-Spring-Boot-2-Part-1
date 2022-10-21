# Lesson 13: Contexts and Dependency Injection Framework

## Overview:

Contexts and Dependency Injection (CDI) is an interface that standardizes dependency injection for Java EE. It defines different annotations for dependency injection like `@Named`, `@Inject`, `@Scope`, `@Singleton`, etc. Different CDI implementation frameworks provide support and functionality for these annotations.

`@Named` is used to define a bean and `@Inject` is used for autowiring one bean into another. Spring supports most of the annotations defined by CDI.

To be able to use CDI annotations in our Spring application, we need to add a dependency to the `dependencies` section in the `pom.xml` file of the project as follows:

```xml
<dependency>
    <groupId>javax.inject</groupId>
    <artifactId>javax.inject</artifactId>
    <version>1</version>
</dependency>
```

The dependency is automatically downloaded when the `pom.xml` file is saved and is visible in the __Maven Dependencies__ folder as `javax.inject-1.jar`. This jar lists the annotations defined by CDI. Now, we can use these annotations in our application.

## Demonstrated Concepts

### `@Named`

Spring framework provides an implementation for some CDI annotations. In Spring framework, a bean is declared using the `@Component` annotation. However, it also supports the `@Named` annotation. This means we can replace the `@Component` from the `RecommenderImplementation`, `ContentBasedFilter`, and `CollaborativeFilter` classes and use `@Named` to declare components.

```java
import javax.inject.Named;

@Named
public class RecommenderImplementation {
    //...
}
```

```java
@Named
public class ContentBasedFilter {
    //...
}
```

```java
@Named
public class CollaborativeFilter {
    //...
}
```

### `@Inject`

Spring has the `@Autowired` annotation for dependency injection but it also supports the equivalent CDI annotation, `@Inject`. So, the `Filter` dependency in `RecommenderImplementation` class declared using `@Autowired` can be declared using `@Inject`.

```java
import javax.inject.Inject;

@Named
public class RecommenderImplementation {
    @Inject
    @Qualifier("CF")
    private Filter filter;
    //...
}
```

In the `main` method, we print the beans to verify if the `RecommenderImplementation` bean is getting detected and the `Filter` dependency is getting autowired successfully.

```java
public static void main(String[] args) {
    //...
    RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
    System.out.println(recommender);
    System.out.println(recommender.getFilter());
    //...   
}
```

When the application is run, the output is the same as when `@Component` and `@Autowired` annotations were used.

### Other CDI annotations

Other annotations provided by CDI are `@Qualifier`, `@Scope`, and `@Singleton`. 

- `@Qualifier` is similar to the one we have seen in Spring and is used to break ties if two beans of the same type qualify to be injected in a dependency.
- `@Scope` is used to set the scope of the bean, similar to the `@Scope` annotation in Spring.
- `@Singleton` is used to explicitly set the scope to singleton in CDI annotation. In Spring, we can specify singleton scope using the `@Scope` annotation.

Both Spring and CDI annotations provide the same functionality. The only difference is that if the application is migrated to another framework, the CDI annotations can still be used, whereas Spring annotations are specific to the Spring framework. Thus, CDI annotations are _often preferred_ because CDI is a Java EE standard.