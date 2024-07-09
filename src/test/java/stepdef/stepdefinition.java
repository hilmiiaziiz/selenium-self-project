package stepdef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import org.yaml.snakeyaml.Yaml;

public class stepdefinition {

    static Map<?,?> property;
    static String objectFilePath = "src/main/resources/object.yml";

   public static WebDriver driver;

    public static void getProp(String demo) throws IOException, InterruptedException {

        Properties prop = new Properties();
        File file = new File("src/main/resources/configsetting.properties");
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);

//        WebDriverManager.chromedriver().setup();
//        if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
//        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty(demo));
//        }
//        else if (prop.getProperty("browser").equalsIgnoreCase("firefox"));
//        {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.get(prop.getProperty("demo"));
//        }
        Thread.sleep(2000);
        driver.manage().window().maximize();
    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "//reports//" + testCaseName + "_"
                + ThreadLocalRandom.current().nextInt() + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }

//    public static void initializeObjectProperties(){
//
//    }

    public static String getElementProperty(String objectstring){
        try {
            Reader rd = new FileReader(objectFilePath);
            Yaml yml = new Yaml();
            property = (Map<?, ?>) yml.load(rd);
            rd.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<?,?> map = (Map<?,?>) property.get(objectstring.split("\\.")[0]);
        return map.get(objectstring.split("\\.")[1]).toString();
    }

}