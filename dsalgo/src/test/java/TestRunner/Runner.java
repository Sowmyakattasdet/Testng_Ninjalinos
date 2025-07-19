package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/Features/Launch1.feature", // adjust path to your feature files
    glue = {"Stepdefinitions","Hooks"},             // package containing step defs
   // tags= "  @login_invalid",
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
