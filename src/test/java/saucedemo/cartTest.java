package saucedemo;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.*;
import saucedemo.Pages.CartPage;
import saucedemo.Pages.LoginPage;
import saucedemo.Pages.NavigationPage;
import saucedemo.Pages.homepage;
import saucedemo.customerListener.testNGListener;
import saucedemo.drivers.GuiDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@Listeners(testNGListener.class)
@Test
public class cartTest extends baseTest {
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
    }
    @Test
    public  void VerifyNavigatingBackToTheProductsPageUponClickingTheContinueShoppingButton(){
        new CartPage(driver).continueShopping();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/inventory.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Test
    public  void VerifyNavigatingToTheCheckOutpageUponClickingTheCheckOutButton(){
        new CartPage(driver).checkout();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/checkout-step-one.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
