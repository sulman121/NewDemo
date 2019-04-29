package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 
		features="/Users/selenium/eclipse-workspace/UnitedAriLine/EMICalculator/src/test/resource/Feature/LoanCalculator.Feature",
		glue= {"Steps"}
		
		
		
		
		
		
		
		
		)








public class DefaultRunner {

}
