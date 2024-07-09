package utility;


//import helper.configProperties;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import stepdef.configProperties;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"src/test/java/PageObject", "stepdef"}, tags = "",
        plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"}
)


public class runner {
    @BeforeClass
    public static void  BeforeClass(){
//        configProperties.initializePropertyFile();
    }
}
