package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(plugin = { "pretty" }, features = "src/test/resources/features/Bitly.feature", glue = {
            "stepDefinitions" })
    public class TestRunner {

    }

