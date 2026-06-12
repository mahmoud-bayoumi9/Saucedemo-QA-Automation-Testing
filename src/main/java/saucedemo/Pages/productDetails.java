package saucedemo.Pages;

import org.openqa.selenium.By;
import saucedemo.drivers.GuiDriver;
import saucedemo.utiles.Actions.waitManager;

public class productDetails {
    private final GuiDriver driver;
    private final   waitManager wait;

    public productDetails(GuiDriver driver) {
        this.driver = driver;
        wait=new waitManager(driver.get());
    }
    private final By addButton= By.xpath("//*[@id=\"add-to-cart\"]");
    private final By backToProductPageButton=By.xpath("//*[@id=\"back-to-products\"]");
    private final By removeButton=By.xpath("//*[@id=\"remove\"]");

    public productDetails add(){
        try {

            wait.fluentWait().until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(driver.get().findElement(addButton)));
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver.get();
            js.executeScript("arguments[0].click();", driver.get().findElement(addButton));
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this;
    }
    public homepage back(){
        try {

            wait.fluentWait().until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(driver.get().findElement(backToProductPageButton)));
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver.get();
            js.executeScript("arguments[0].click();", driver.get().findElement(backToProductPageButton));
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new homepage(driver);
    }
    public productDetails verifyRemove(){
        driver.verfy().isvisiable(removeButton);
        return this;
    }
}
