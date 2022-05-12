package com.app.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatGoodCoach") Explicit Bean ID
@Component  // Implicit Bean ID  = tennisCoach (Class Name with lower-case first letter)
//@Scope("prototype")   // default is singleton 
public class TennisCoach implements Coach {
	
	// Add private field
	@Autowired    // spring will automatically set this field with java technology called reflection.
	//@Qualifier("happyFortuneService")
	@Qualifier("happyFortuneService")
	private FortuneService fortuneSecvice;
	
	//Define default constructor
	public TennisCoach() {
		System.out.println("Inside the default constructor : TennisCoach");
	}
	
	
	// Define my init method
	// Any return type could be used but most commonly void is used
	@PostConstruct
	public void doMyStartWork() {
		System.out.println("TennisCoach: Inside my method doMyStartWork()");
	}
	
	// Define my destroy method
	@PreDestroy
	public void doMyCleanupWork() {
		System.out.println("TennisCoach: Inside my method doMyCleanupWork()");
	}	
	
	// Add constructor for Auto-wiring
	// Configure dependency injection with @Autowired annotation
/*	@Autowired
	public TennisCoach(FortuneService fortuneSecvice) {
		this.fortuneSecvice = fortuneSecvice;
	}
*/	
	
/*	
	// Define the setter method
	@Autowired
	public void setFortuneSecvice(FortuneService fortuneSecvice) {
		System.out.println("Inside the setter method : setFortuneSecvice");
		this.fortuneSecvice = fortuneSecvice;
	}
*/
	
/*	
	// Define the any method
	@Autowired
	public void anyMethodName(FortuneService fortuneSecvice) {
		System.out.println("Inside the setter method : anyMethodName");
		this.fortuneSecvice = fortuneSecvice;
	}
*/

	@Override
	public String getDailyWorkout() {
		System.out.println("Inside the TennisCoach method : getDailyWorkout");
		return "Flip pactice daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneSecvice.getMyFortune();
	}

}
