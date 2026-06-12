package saucedemo.Pages;

import org.openqa.selenium.By;
import saucedemo.drivers.GuiDriver;

public class LoginPage {
    private final GuiDriver driver;

   public LoginPage(GuiDriver driver) {
        this.driver = driver;
    }
    private final By userName=By.xpath("//*[@id=\"user-name\"]");
    private final By password=By.xpath("//*[@id=\"password\"]");
    private final By loginButton=By.xpath("//*[@id=\"login-button\"]");
    private final  By validationMessage=By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    public LoginPage enterUserName(String username){
        driver.action().sendKey(userName,username);
        return this;
    }
    public LoginPage enterPassword(String Password){
        driver.action().sendKey(password,Password);
        return this;
    }
    public homepage clickOnLoginButton(){
        driver.action().click(loginButton);
        return new homepage(driver);
    }
public String ValidationMessage(){
        return  driver.action().getText(validationMessage);
}
}
