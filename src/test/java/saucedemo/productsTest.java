package saucedemo;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.*;
import saucedemo.Pages.LoginPage;
import saucedemo.Pages.NavigationPage;
import saucedemo.Pages.homepage;
import saucedemo.customerListener.testNGListener;
import saucedemo.drivers.GuiDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Listeners(testNGListener.class)
@Test
public class productsTest extends baseTest{

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
    }
    public void VerifyThatClickingTheMenuToggleExpandsAndDisplaysAllNavigationMenuItems(){
        homepage home=new homepage(driver);home.displayMenu();
      home.verifyAbout();
      home.verifyALogout();
      home.verifyAllItems();
      home.verifyReset();

    }
    public void VerifyTheFunctionalityOfAllItemsMenuOption(){
        homepage home=new homepage(driver);
        home.displayMenu();
        home.clickAllItems();
        home.ClickClose();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/inventory.html";
        driver.verfy().assertequal(actual,expected,"not matched");

    }
    public void VerifyTheFunctionalityOfAboutMenuOption(){
        homepage home=new homepage(driver);
        home.displayMenu();
        home.clickAboutOption();
        home.ClickClose();
        String actual=driver.get().getCurrentUrl();
        String expected="https://saucelabs.com/error/404";
        driver.verfy().assertequal(actual,expected,"not matched");

    }
    public void VerifyTheFunctionalityOfLogoutMenuOption(){
        homepage home=new homepage(driver);
        home.displayMenu();
        home.clickLogoutOption();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/";
        driver.verfy().assertequal(actual,expected,"not matched");

    }
    public void VerifyNavigatingToTheProductDetailsPageUponClickingASpecificProduct(){
        homepage home=new homepage(driver);
        home.clickOnProductTitle();
        String actual=driver.get().getCurrentUrl();
        String expected="https://www.saucedemo.com/inventory-item.html?id=5";
        driver.verfy().assertequal(actual,expected,"not matched");

    }
    @Test()

    public void VerifyTheFunctionalityAndBehaviorOfTheAddToCartButton(){
        homepage home=new homepage(driver);
        home.clickAddProductButton();
        String Expected="Remove";
        String actual=home.removeText();
        driver.verfy().assertequal(actual,Expected,"not matched");

    }
    @Test(dependsOnMethods = {"VerifyTheFunctionalityAndBehaviorOfTheAddToCartButton"})
    public void VerifyTheFunctionalityAndBehaviorOfTheRemoveFromCartButton(){
        homepage home=new homepage(driver);
        home.clickRemoveProductButton();
        String Expected="Add to cart";
        String actual=home.addText();
        driver.verfy().assertequal(actual,Expected,"not matched");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
