package io.datajek.springbasics.movierecommendersystem.lesson9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * In lesson 9, the original annotation used in this class is @SpringBootApplication
 */
@SpringBootApplication
/**
 * Try each of the 3 annotations @SpringBootApplication, @ComponentScan(basePackages="..."), and @ComponentScan(includeFilters=...)
 * for the purpose of lesson 10
 */
//@ComponentScan(basePackages="io.datajek.springbasics.movierecommendersystem.lesson10")
//@ComponentScan(includeFilters = @ComponentScan.Filter (type= FilterType.REGEX, pattern="io.datajek.springbasics.movierecommendersystem.lesson9.*"))
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {

		//ApplicationContext manages the beans and dependencies
		ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		/**
		 * The following block of code is for the purpose of lesson 9
		 */
//		//Retrieve and print singleton bean from application context
//		ContentBasedFilter filter = appContext.getBean(ContentBasedFilter.class);
//		System.out.println("\nContentBasedFilter bean with singleton scope");
//		System.out.println(filter);
//
//		//Retrieve and print prototype bean from the singleton bean twice
//		Movie movie1 = filter.getMovie();
//		Movie movie2 = filter.getMovie();
//		Movie movie3 = filter.getMovie();
//
//		System.out.println("\nMovie bean with prototype scope");
//		System.out.println(movie1);
//		System.out.println(movie2);
//		System.out.println(movie3);
//
//		//Print number of instances of each bean
//		System.out.println("\nContentBasedFilter instances created: "+ ContentBasedFilter.getInstances());
//		System.out.println("Movie instances created: "+ Movie.getInstances());

		/**
		 * The following block of code is for the purpose of lesson 10
		 */
		System.out.println("CollaborativeFilter bean found = " + appContext.containsBean("collaborativeFilter"));
		System.out.println("ContentBasedFilter bean found = " + appContext.containsBean("contentBasedFilter"));
	}
}