package saucedemo.Pages;

import com.sun.jdi.ByteValue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import saucedemo.drivers.GuiDriver;
import saucedemo.utiles.Actions.waitManager;

public class checkOutPageStep1 {
    private final GuiDriver driver;
    private final waitManager wait;

    public checkOutPageStep1(GuiDriver driver) {
        this.driver = driver;
        wait=new waitManager(driver.get());

    }
    private final By firstname=By.xpath("//*[@id=\"first-name\"]");
    private final  By lastname=By.xpath("//*[@id=\"last-name\"]");
    private final By postalCode=By.xpath("//*[@id=\"postal-code\"]");
    private final  By cancelButton=By.xpath("//*[@id=\"cancel\"]");
    private final  By continueCheckout=By.xpath("//*[@id=\"continue\"]");
    private final  By errorMessage=By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]");
    public checkOutPageStep1 EnterFirstName(String firstName){
        driver.action().sendKey(firstname,firstName);
        return this;
    }
    public checkOutPageStep1 EnterLastName(String lastName){
        driver.action().sendKey(lastname,lastName);
        return this;
    }
    public checkOutPageStep1 EnterpostalCode(String postal){
        driver.action().sendKey(postalCode,postal);
        return this;
    }
    public CartPage clickOnCancelButton(){
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(ExpectedConditions.presenceOfElementLocated(cancelButton));
            org.openqa.selenium.WebElement closeButton = rawDriver.findElement(cancelButton);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", closeButton);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new CartPage(driver);
    }
    public CheckOutPageStep2 continueCheckOutButton(){
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(ExpectedConditions.presenceOfElementLocated(continueCheckout));
            org.openqa.selenium.WebElement closeButton = rawDriver.findElement(continueCheckout);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", closeButton);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new CheckOutPageStep2(driver);
    }
    public String requiredMessage(){
        return driver.action().getText(errorMessage);
    }
}
