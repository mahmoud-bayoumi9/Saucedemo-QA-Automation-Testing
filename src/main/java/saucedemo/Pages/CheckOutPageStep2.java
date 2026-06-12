package saucedemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import saucedemo.drivers.GuiDriver;
import saucedemo.utiles.Actions.waitManager;

public class CheckOutPageStep2 {
    private final GuiDriver driver;
    private final waitManager wait;

    public CheckOutPageStep2 (GuiDriver driver) {
        this.driver = driver;
        wait=new waitManager(driver.get());

    }
    private final By cancelButton=By.xpath("//*[@id=\"cancel\"]");
    private final By finishButton=By.xpath("//*[@id=\"finish\"]");
    public checkOutPageStep1 clickOnCancelButton(){
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
        return new checkOutPageStep1(driver);
    }

    public completeCheckOutPage clickOnFinishButton(){
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(ExpectedConditions.presenceOfElementLocated(finishButton));
            org.openqa.selenium.WebElement closeButton = rawDriver.findElement(finishButton);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", closeButton);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new completeCheckOutPage(driver);

    }
}
