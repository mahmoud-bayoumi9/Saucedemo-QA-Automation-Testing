package saucedemo;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.*;
import saucedemo.Pages.*;
import saucedemo.customerListener.testNGListener;
import saucedemo.drivers.GuiDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@Listeners(testNGListener.class)
public class checkoutstep1Test extends baseTest {
    @BeforeSuite
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "70.0.3538.77").
                        put("os", System.getProperty("os.name"))
                        .put("URL", "http://testjs.site88.net")
                        .build());
    }
    @BeforeMethod
    public void setup(){
        driver=new GuiDriver();
        new NavigationPage(driver).navigate();
        new LoginPage(driver).enterUserName("problem_user").
                enterPassword("secret_sauce").clickOnLoginButton();
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver.get());
        actions.moveByOffset(10, 10).click().perform();
        new homepage(driver).showCartPage();
        new CartPage(driver).checkout();
    }
    @Test
    public void VerifyThatTheSystemPreventsCheckoutWhenFirstNameLastNameAndPostalCodeFieldsAreLeftEmpty(){
       checkOutPageStep1 check= new checkOutPageStep1(driver);check.continueCheckOutButton();
        String Expected="sss";
        String actual=check.requiredMessage();
        driver.verfy().assertequal(actual,Expected,"not matched");
    }
    @Test
    public void VerifyThatTheFirstNameFieldRejectsNumericInputsAndDisplaysAnErrorMessage(){
        checkOutPageStep1 check= new checkOutPageStep1(driver);check.EnterFirstName("34sd4").
                EnterLastName("bayoumi").EnterpostalCode("61115").continueCheckOutButton();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/checkout-step-one.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Test
    public void VerifyThatTheFirstNameFieldRejectsSpecialCharactersInputsAndDisplaysAnErrorMessage(){
        checkOutPageStep1 check= new checkOutPageStep1(driver);check.EnterFirstName("@dff").
                EnterLastName("Bayoumi").EnterpostalCode("61115").continueCheckOutButton();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/checkout-step-one.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Test
    public void VerifyThatTheLastNameFieldRejectsNumericInputsAndDisplaysAnErrorMessage(){
        checkOutPageStep1 check= new checkOutPageStep1(driver);check.EnterFirstName("Mahmoud").
                EnterLastName("333").EnterpostalCode("61115").continueCheckOutButton();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/checkout-step-one.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Test
    public void VerifyThatTheLastNameFieldRejectsSpecialCharactersInputsAndDisplaysAnErrorMessage(){
        checkOutPageStep1 check= new checkOutPageStep1(driver);check.EnterFirstName("Mahmoud").
                EnterLastName("bayoumi@").EnterpostalCode("61115").continueCheckOutButton();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/checkout-step-one.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Test
    public void CheckOutWithValidData(){
        checkOutPageStep1 check= new checkOutPageStep1(driver);check.EnterFirstName("Mahmoud").
                EnterLastName("bayoumi").EnterpostalCode("61115").continueCheckOutButton();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/checkout-step-two.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
