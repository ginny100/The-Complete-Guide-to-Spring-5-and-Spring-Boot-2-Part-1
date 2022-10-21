# Lesson 17: XML Configuration with Java Annotations - Part 2

## Overview

Like the `<context:component-scan>` tag, the `<context:annotation-config>` tag can also detect dependency injection annotations, e.g., `@Autowired` and `@Qualifier`. But it cannot detect beans annotated with `@Component` and other stereotype annotations.

## Demonstrated Concepts

### `<context:annotation-config>` tag

If we are using the `<context:annotation-config>` tag, then we need to declare beans in the XML config file.

```xml
<!-- enable detection of dependency injection annotations --> 
<context:annotation-config />

<!-- bean definitions -->
<bean id="filter"   
class="io.datajek.springbasics.movierecommendersystem.lesson17.ContentBasedFilter" /> 

<bean id="filter1" 
class="io.datajek.springbasics.movierecommendersystem.lesson17.CollaborativeFilter"/>
    
<bean id="recommenderImpl"
class="io.datajek.springbasics.movierecommendersystem.lesson17.RecommenderImplementation"/>
```

Now that we have enabled the detection of dependency injection annotation in the `appContext.xml`, we can use the `@Autowired` annotation in `RecommenderImplementation` class as follows:

```java
public class RecommenderImplementation {
 
    @Autowired
    private Filter filter;

    //getter setter
    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    //...
}
```

Here, autowiring is taking place by name as we have declared a bean named `filter` in `appContext.xml`.

When the application is run, dependency injection takes place due to the `@Autowired` annotation.

The `<context:annotation-config>` tag is redundant in the presence of `<context:component-scan>` tag as the latter can detect both bean and dependency injection annotations.