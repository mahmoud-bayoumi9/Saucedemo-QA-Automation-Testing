package saucedemo;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.testng.annotations.*;
import saucedemo.Pages.LoginPage;
import saucedemo.Pages.NavigationPage;
import saucedemo.Pages.homepage;
import saucedemo.customerListener.testNGListener;
import saucedemo.drivers.GuiDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@Test
@Listeners(testNGListener.class)
public class loginTest extends baseTest{

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
    }
    @Test
    @Description("User should Redirect to homepage Page")
//    @Issue("jjjjj")
//    @Severity(SeverityLevel.CRITICAL)
//    @Link("DDDDDDDD")
    @Owner("Mahmoud")
    public void VerifyUserCannotLoginWithEmptyUsernameAndPasswordFields(){
        LoginPage login= new LoginPage(driver);login.clickOnLoginButton();
        String actual=login.ValidationMessage();
        String expected="Epic sadface: Username is required";
                driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Owner("Mahmoud")
    public void VerifyUserCannotLoginWithEmptyUsername(){
        LoginPage login= new LoginPage(driver);login.enterPassword("secret_sauce").clickOnLoginButton();
        String actual=login.ValidationMessage();
        String expected="Epic sadface: Username is required";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Owner("Mahmoud")
    public void VerifyUserCannotLoginWithEmptyPasswordFields(){
        LoginPage login= new LoginPage(driver);login.enterUserName("standard_user").clickOnLoginButton();
        String actual=login.ValidationMessage();
        String expected="Epic sadface: Password is required";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Owner("Mahmoud")
    public void VerifyLoginFunctionalityWithInvalidUsernameAndValidPassword(){
        LoginPage login= new LoginPage(driver);login.enterUserName("Mahmoud").enterPassword("secret_sauce").clickOnLoginButton();
        String actual=login.ValidationMessage();
        String expected="Epic sadface: Username and password do not match any user in this service";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Owner("Mahmoud")
    public void VerifyLoginFunctionalityWithValidUsernameAndInvalidPassword(){
        LoginPage login= new LoginPage(driver);login.enterUserName("ocked_out_user").enterPassword("98983ds").clickOnLoginButton();
        String actual=login.ValidationMessage();
        String expected="Epic sadface: Username and password do not match any user in this service";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Owner("Mahmoud")
    public void LoginValidationUsingMismatchedRegisteredCredentials(){
        LoginPage login= new LoginPage(driver);login.enterUserName("ocked_out_user").enterPassword("mahmoud0122").clickOnLoginButton();
        String actual=login.ValidationMessage();
        String expected="Epic sadface: Username and password do not match any user in this service";
        driver.verfy().assertequal(actual,expected,"not matched");
    }
    @Owner("Mahmoud")
    public void LoginWithValidUsernameAndPassword(){
        LoginPage login= new LoginPage(driver);login.enterUserName("problem_user").
                enterPassword("secret_sauce").clickOnLoginButton();
        driver.verfy().isvisiable(new homepage(driver).allProducts);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

