# Lesson 6: Autowiring — @Qualifier

## Demonstrated Concepts

### `@Qualifier` annotation

Like `@Primary`, the `@Qualifier` annotation gives priority to one bean over the other if two beans of the same type are found. The bean whose name is specified in the `@Qualifier` annotation qualifies to be injected as a dependency. The `@Qualifier` annotation can be used in a scenario when we have multiple objects of the same type and autowiring by name cannot be used because the variable name doesn’t match any bean name.

Say, we want to use the name __CBF__ for `ContentBasedFilter`. We can either specify it in the `@Component` annotation or use `@Qualifier` annotation on the class. Both approaches, shown below, yield the same result:

```java
@Component("CBF")
public  class ContentBasedFilter implements Filter{
    //...
}
```

```java
@Component
@Qualifier("CBF")
public  class ContentBasedFilter implements Filter{
    //...
}
```

Now, we can use the `@Qualifier` annotation in the `RecommenderImplementation` class where the dependency is injected to indicate which bean to use.

```java
public class RecommenderImplementation {

    @Autowired
    @Qualifier("CBF")
    private Filter filter;
 
    public String [] recommendMovies (String movie) {       
        //...
    }
}
```

The name of the `Filter` implememtation used with the `@Qualifier` annotation (in this case, __CBF__) has to match the name used with the `@Component` (or `@Qualifier`) annotation on the class.

<img src="./images/img1.png" width="500">

When the application is run, the `ContentBasedFilter` bean qualifies to be autowired.

We can use the name __CF__ for `CollaborativeFilter` class as follows:

```java
@Component
@Qualifier("CF")
public  class CollaborativeFilter implements Filter{
    //...
}
```

Another way to give the name CF to the CollaborativeFilter bean is:

```java
@Component("CF")
public  class CollaborativeFilter implements Filter{
    //...
}
```

In the `RecommenderImplementation` class, we can inject `CollaborativeFilter` bean by using `@Qualifier` annotation and specifying the name __CF__.

```java
@Autowired
@Qualifier("CF")
private  Filter filter;
```

Depending upon which filter is required in a given scenario, we can change the `@Qualifier` annotation in the `RecommenderImplementation` class.

### Comparison with `@Primary`

The `@Qualifier` annotation takes precedence over the `@Primary` annotation. To show this, let’s add the `@Primary` annotation to the ContentBasedFilter class and run the application.

When the application is run, the `CollaborativeFilter` bean gets autowired. This is because `@Primary` is the default setting, while `@Qualifier` is specific. `@Primary` defines the default selection when no other information is available. It tells Spring to use the bean marked as primary as its first choice if it encounters more than one bean of the same type. On the other hand, `@Qualifier` tells Spring to use a specific bean if it finds multiple beans of matching type.

<img src="./images/img2.png" width="500">

`@Primary` annotation should be used if there is one clear favorite to be used in a majority of situations. In some cases, one algorithm might be more efficient or more important than the rest and is declared as the primary choice. The bean with `@Primary` gets chosen unless another bean is required, which can be specified with `@Qualifier`. The bean with `@Qualifier` is only used to request an “alternate” bean in case the primary choice is not required.

`@Autowired` annotation resolves dependencies by type. If there are more than one beans of the same type, a conflict arises. We have seen three different approaches to resolve conflicts. They can be resolved using the `@Primary` annotation, renaming the variable to match the name of the class, or by using the `@Qualifier` annotation.