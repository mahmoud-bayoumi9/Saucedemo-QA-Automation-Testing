package saucedemo;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.*;
import saucedemo.Pages.*;
import saucedemo.customerListener.testNGListener;
import saucedemo.drivers.GuiDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@Listeners(testNGListener.class)
@Test
public class checkOutStep2Test extends baseTest {
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
        new checkOutPageStep1(driver).EnterFirstName("Mahmoud").
                EnterLastName("bayoumi").EnterpostalCode("61115").continueCheckOutButton();

    }
    @Test
    public void VerifyFinishButtonCompletesTheOrderSuccessfully(){
        new CheckOutPageStep2(driver).clickOnFinishButton();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/checkout-complete.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Test
    public void VerifyCancelButtonReturnsToCartPageFromCheckOut(){
        new CheckOutPageStep2(driver).clickOnFinishButton();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/inventory-item.html?id=0";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
