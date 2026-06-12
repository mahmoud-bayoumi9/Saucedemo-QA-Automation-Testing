package saucedemo;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.*;
import saucedemo.Pages.LoginPage;
import saucedemo.Pages.NavigationPage;
import saucedemo.Pages.homepage;
import saucedemo.Pages.productDetails;
import saucedemo.customerListener.testNGListener;
import saucedemo.drivers.GuiDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@Test
@Listeners(testNGListener.class)
public class productDetailsTest extends baseTest{

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
        new homepage(driver).clickOnProductTitle();
    }
    public void addProduct(){

    }
    public void VerifyNavigatingBackToTheProductsListPageUponClickingTheBackToProductsButton(){
        new productDetails(driver).back();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/inventory.html";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    public void VerifyTheFunctionalityAndBehaviorOfTheAddToCartButtonFromProductDetails(){
       productDetails details= new productDetails(driver);details.add();
       details.verifyRemove();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
