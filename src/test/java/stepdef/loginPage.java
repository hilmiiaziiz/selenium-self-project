package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import pageObject.loginPageObject;

import static pageObject.loginPageObject.*;

import java.io.IOException;

public class loginPage extends stepdefinition {


    @Given("^User open the (.*) url$")
    public void openTheWeb(String demo) throws InterruptedException, IOException {
        stepdefinition.getProp(demo);
//        Properties p = new Properties();
//        GeneralFunction.callProp(p);
//        loginPageObject.openUrl(p.getProperty("URLBBDEV"));

    }

    @And("^User verify label page$")
    public void labelVerification() {
        verify_label();

    }

    @And("^User verify username field")
    public void unameFieldVerify() {
        verify_uname_field();

    }

    @When("^User verify password field")
    public void passwordFieldVerify() {
        verify_password_field();
    }

    @And("^User verify button login$")
    public void loginButtonVerify() {
        verify_login_button();
    }

    @And("^User input (.*) text on (.*) field$")
    public void inputText(String text, String loc) {
        WebElement element = driver.findElement(By.xpath(loc));
        element.sendKeys(text);

    }

    @And("^User click on (.*)$")
    public void clickElement(String loc) {
        WebElement element = driver.findElement(By.xpath(loc));
        element.click();

    }

    @And("^User verify (.*) appears$")
    public void verifyElement(String loc) {
        WebElement element = driver.findElement(By.xpath(stepdefinition.getElementProperty(loc)));
        element.isDisplayed();

    }

    @And("^User verify value (.*) is (.*)")
    public void verifyElement(String value, String expected) {
        WebElement element = driver.findElement(By.xpath(value));
        Assert.assertEquals(element.getText(), expected);
    }

    @And("^close browser")
    public void closeBrowser() {
        driver.close();
    }
}