# Lesson 16: XML Configuration with Java Annotations

## Overview

In the last lesson, we removed all Java annotations from our application and used the `appContext.xml` file to define beans and inject the dependency. However, if we want to detect beans defined by the `@Component` annotation and inject the dependencies using `@Autowired` annotation while using XML context, we can do that too.

In large projects, declaring a lot of beans using the `<bean>` tag is cumbersome, so annotation-based dependency injection was introduced in Spring 2.5. This enabled automatic detection of beans having the `@Component` annotation. The `<context:component-scan>` tag is used to turn this feature on.

> __Note from `ginny100`:__ Highly recommend creating a whole new project using Spring Initializr with a separate `appContext.xml` file and the whole `lesson16` package of this current project to follow along in this lesson.

## Demonstrated Concepts

### `<context:component-scan>` tag

Right now, we have declared three beans in `appContext.xml`. Suppose we want to declare the `ContentBasedFilter` and `CollaborativeFilter` beans using the `@Component` annotation instead of defining them using the `<bean>` tag in `appContext.xml`.

```java
@Component
public class ContentBasedFilter implements Filter {
    //..
}
```

```java
@Component
public class CollaborativeFilter implements Filter {
    //..
}
```

Just annotating the classes with `@Component` isn’t enough for Spring to detect them as beans. We need to trigger a component scan. In XML context, the `<context:component-scan>` tag is used to activate component scanning. To be able to use this tag, we will define a new schema and provide a shortcut name for it as context in `appContext.xml`.

> By default, any tag that is used without any namespace (like `<bean>`) belongs to the default schema, which is http://www.springframework.org/schema/beans.

In the code shown below, line 3 (`xmlns:context="http://www.springframework.org/schema/context"`) defines the `context` namespace and lines 6 (`http://www.springframework.org/schema/context`) and 7 (`http://www.springframework.org/schema/context/spring-context.xsd">`) provide the schema location of the namespace.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:context="http://www.springframework.org/schema/context"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/context
http://www.springframework.org/schema/context/spring-context.xsd">
```

The above code will replace the existing metadata information in `appContext.xml`.

Now, we can use the `<context:component-scan>` tag and remove the `<bean>` entries for the classes having `@Component` annotation from the configuration file.

```xml
<!-- enable component scan -->
<context:component-scan
 base-package="io.datajek.springbasics.movierecommendersystem.lesson16" />

<bean id="recommenderImpl" 
 class="io.datajek.springbasics.movierecommendersystem.lesson16.RecommenderImplementation">
 <property name="filter" ref="collaborativeFilter"/>
</bean>
```

Here, we are directing Spring to scan the __io.datajek.springbasics.movierecommendersystem.lesson16__ package. By default, Spring will scan everything marked with `@Component` as well as the `@Controller`, `@Repository`, and `@Service` annotations.

In the `main` method, we will print the list of beans and also check if autowiring is taking place. The `recommenderImpl` bean is declared in `appContext.xml` while its dependency is declared using `@Component` annotation.

```java
public static void main(String[] args) {
    
    ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                                                                    "appContext.xml");
    //check the beans which have been loaded
    System.out.println("\nBeans loaded:");
    System.out.println(Arrays.toString(appContext.getBeanDefinitionNames()));

    //retrieve bean from the application context
    RecommenderImplementation recommender = 
    appContext.getBean("recommenderImpl", RecommenderImplementation.class);

    //print dependency
    System.out.println("\nDependency: " + recommender.getFilter());
    System.out.println();
 
    appContext.close();
}
```

When the application is run, all beans defined using the `<bean>` tag and `@Component` annotation are detected. The bean names are displayed using the `getBeanDefinitionNames()` method. As can be seen from the output, the list of beans is quite long. This is because the output shows all the beans in the IOC container. Autowiring is also taking place as expected.

Just like XML context detected the `@Component` annotation, it can also detect the `@Autowired` annotation. Right now, we are using `<property>` tag for injecting `collaborativeFilter` bean in `recommenderImpl`. We can remove it and instead use the `@Autowired` annotation in the `RecommenderImplementation` class as follows:

```java
public class RecommenderImplementation {
 
    @Autowired
    @Qualifier("contentBasedFilter")
    private Filter filter;
    //...
}
```

We are using the `@Qualifier` annotation to break the tie between two beans of `Filter` type.

After removing dependency injection, the updated bean definition in `appContext.xml` is:

```xml
<bean id="recommenderImpl" 
 class="io.datajek.springbasics.movierecommendersystem.lesson16.RecommenderImplementation"/>
```