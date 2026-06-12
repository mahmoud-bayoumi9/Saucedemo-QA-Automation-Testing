package saucedemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import saucedemo.drivers.GuiDriver;
import saucedemo.utiles.Actions.waitManager;

public class CartPage {
    private final GuiDriver driver;
    private final waitManager wait;

    public CartPage(GuiDriver driver) {
        this.driver = driver;
        wait=new waitManager(driver.get());

    }
    private  final By CartCounter= By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private final By continueButton=By.xpath("//*[@id=\"continue-shopping\"]");
    private final  By CheckOutButton=By.xpath("//*[@id=\"checkout\"]");

    public void setcounter(){
        int counter = Integer.parseInt(driver.action().getText(CartCounter));
        counter+=1;
        driver.get().findElement(CartCounter).clear();
        driver.action().sendKey(CartCounter,String.valueOf(counter));
    }
    public homepage continueShopping(){
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(ExpectedConditions.presenceOfElementLocated(continueButton));
            org.openqa.selenium.WebElement closeButton = rawDriver.findElement(continueButton);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", closeButton);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new homepage(driver);
    }
    public checkOutPageStep1 checkout(){
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(ExpectedConditions.presenceOfElementLocated(CheckOutButton));
            org.openqa.selenium.WebElement closeButton = rawDriver.findElement(CheckOutButton);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", closeButton);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new checkOutPageStep1(driver);
    }

}
