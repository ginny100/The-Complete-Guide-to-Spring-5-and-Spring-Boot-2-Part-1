# Lesson 5: Autowiring By Name

## Overview

In the last lesson, we looked at the autowiring by type approach where priority was given to the collaborative filter using the `@Primary` annotation.

## Demonstrated Concepts

### Autowiring By Name

Another approach is autowiring by name where we specify the bean that is to be used by name. In this approach, while creating an object, the dependency is injected by matching the name of the reference variable to the bean name. The developer has to ensure that the variable name is the same as its bean name.

We will begin by omitting the `@Primary` annotation from the `CollaborativeFilter` class. Now, to let Spring know which bean to use, we will change the variable name in the `RecommenderImplementation` class to match the bean name as follows:
    
```java
public class RecommenderImplementation {
    
    @Autowired
    private Filter contentBasedFilter;
        
    public String [] recommendMovies (String movie) {       
        System.out.println("\nName of the filter in use: " + contentBasedFilter + "\n");
        String[] results = contentBasedFilter.getRecommendations("Finding Dory");
        return results;
    }
}
```

Now when the application is run, it chooses the `ContentBasedFilter` bean for autowiring. When Spring finds two beans of the same type (`Filter`), it determines that the bean to inject is the one whose name matches the bean with the `@Component` annotation. In other words, the variable name (`contentBasedFilter`) matches the bean name (`ContentBasedFilter`).

```java
public class RecommenderImplementation {
    @Autowired
    private Filter contentBasedFilter;
    //...
}
```

```java
@Component
public class ContentBasedFilter implements Filter{
    //...
}
```

<img src="./images/img1.png" width="500">

If we change the name of the variable to `filter`, the bean name and variable names are different. Then, when the application is run, autowiring does not take place and, as expected, we get the _NoUniqueBeanDefinitionException_.

We have seen two autowiring approaches so far. To see which autowiring approach takes precedence, we will use the `@Primary` annotation on `ContentBasedFilter` class and use autowiring by name by changing the name of the variable of type `Filter` in `RecommenderImplementation` class to `collaborativeFilter`.

The application chooses the `ContentBasedFilter` bean, showing that `@Primary` has a higher priority.

This is because `@Autowired` annotation tries to resolve dependency by type first. If it fails to resolve a conflict and finds more than one bean of the same type then it tries to resolve it by name.

The autowiring by name approach is advantageous when we want to use one bean in one situation and another bean in some other situation. Using `@Primary` will always give preference to one bean, which is impractical if we want to use different beans in different scenarios. Autowiring by name ensures that if we have some other component which wants to use another type of bean, it can request Spring by using a different variable name.