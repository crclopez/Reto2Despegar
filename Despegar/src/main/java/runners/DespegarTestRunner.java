package runners;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="projectFeatures", glue="stepDefinitions")
public class DespegarTestRunner {

}
