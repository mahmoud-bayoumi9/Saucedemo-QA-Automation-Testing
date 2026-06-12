package saucedemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import saucedemo.drivers.GuiDriver;
import saucedemo.utiles.Actions.waitManager;

public class completeCheckOutPage {
    private final GuiDriver driver;
    private final waitManager wait;

    public completeCheckOutPage(GuiDriver driver) {
        this.driver = driver;
        wait=new waitManager(driver.get());

    }
    private final By BackToHome=By.xpath("//*[@id=\"back-to-products\"]");
    private final By thank=By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    public homepage backToHome(){
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(ExpectedConditions.presenceOfElementLocated(BackToHome));
            org.openqa.selenium.WebElement closeButton = rawDriver.findElement(BackToHome);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", closeButton);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new homepage(driver);
    }
    public completeCheckOutPage verifyComplete(){
        driver.verfy().isvisiable(thank);
        return this;
    }
    public completeCheckOutPage verifyBackHomeButon(){
        driver.verfy().isvisiable(BackToHome);
        return this;
    }

}
