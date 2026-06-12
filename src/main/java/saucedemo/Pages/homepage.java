package saucedemo.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import saucedemo.drivers.GuiDriver;
import saucedemo.utiles.Actions.waitManager;

public class homepage {
    private final GuiDriver driver;
    private  final waitManager wait;
    public homepage(GuiDriver driver) {
        this.driver=driver;this.wait = new waitManager(driver.get());
    }
    private  final  By ProductTitle=By.xpath("//*[@id=\"item_4_title_link\"]/div");
    public final By allProducts=By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private final  By menuItem=By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    private final By menuContainer = By.xpath("//div[@class='bm-menu-wrap']");
    private final By closeMenuButton=By.xpath("//*[@id=\"react-burger-cross-btn\"]");
    private final By allItemsNav    = By.id("inventory_sidebar_link");
    private final By AboutNav       = By.id("about_sidebar_link");
    private final By Logout         = By.id("logout_sidebar_link");
    private final By ResetAppState  = By.id("reset_sidebar_link");
    private final By addProductButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By cartIcon=By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    public homepage displayMenu(){
        wait.fluentWait().until(ExpectedConditions.visibilityOf(driver.get().findElement(menuItem)));
        driver.action().click(menuItem);
        return this;
    }public homepage verifyAllItems(){
        wait.fluentWait().until(ExpectedConditions.visibilityOf(driver.get().findElement(allItemsNav)));
        driver.verfy().isvisiable(allItemsNav);
        wait.fluentWait().until(ExpectedConditions.visibilityOf(driver.get().findElement(menuContainer)));
        return this;
    }
//    public homepage clickAllItems(){
//        wait.fluentWait().until(ExpectedConditions.elementToBeClickable(allItemsNav));
//        driver.action().click(allItemsNav);
//        return this;
//    }
public void clickAllItems() {
    try {
        org.openqa.selenium.WebDriver rawDriver = driver.get();

        org.openqa.selenium.WebElement burgerMenu = rawDriver.findElement(By.id("react-burger-menu-btn"));
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;

        js.executeScript("arguments[0].click();", burgerMenu);
        Thread.sleep(500);

        org.openqa.selenium.WebElement allItemsLink = rawDriver.findElement(By.id("inventory_sidebar_link"));
        js.executeScript("arguments[0].click();", allItemsLink);

    } catch (Exception e) {
        org.openqa.selenium.WebDriver rawDriver = driver.get();
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
        js.executeScript("arguments[0].click();", rawDriver.findElement(By.id("inventory_sidebar_link")));
    }
}
    public homepage verifyAbout(){
        wait.fluentWait().until(ExpectedConditions.visibilityOf(driver.get().findElement(AboutNav)));
        driver.verfy().isvisiable(AboutNav);
        return this;
    }
    public AboutPage clickAboutOption() {
        org.openqa.selenium.WebDriver rawDriver = driver.get();
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
        try {
            org.openqa.selenium.WebElement burgerMenu = rawDriver.findElement(By.id("react-burger-menu-btn"));
            js.executeScript("arguments[0].click();", burgerMenu);
            Thread.sleep(500);
            org.openqa.selenium.WebElement aboutLink = rawDriver.findElement(By.id("about_sidebar_link"));
            js.executeScript("arguments[0].click();", aboutLink);
        } catch (Exception e) {
            System.out.println("فشلت الطريقة العادية، يتم الضغط المباشر: " + e.getMessage());
            js.executeScript("arguments[0].click();", rawDriver.findElement(By.id("about_sidebar_link")));
        }
        return new AboutPage();
    }
    public homepage verifyALogout(){
        wait.fluentWait().until(ExpectedConditions.visibilityOf(driver.get().findElement(Logout)));
        driver.verfy().isvisiable(Logout);
        return this;
    }
    public AboutPage clickLogoutOption() {
        org.openqa.selenium.WebDriver rawDriver = driver.get();
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
        try {
            org.openqa.selenium.WebElement burgerMenu = rawDriver.findElement(By.id("react-burger-menu-btn"));
            js.executeScript("arguments[0].click();", burgerMenu);
            Thread.sleep(500);
            org.openqa.selenium.WebElement aboutLink = rawDriver.findElement(By.id("logout_sidebar_link"));
            js.executeScript("arguments[0].click();", aboutLink);
        } catch (Exception e) {
            System.out.println("فشلت الطريقة العادية، يتم الضغط المباشر: " + e.getMessage());
            js.executeScript("arguments[0].click();", rawDriver.findElement(By.id("logout_sidebar_link")));
        }
        return new AboutPage();
    }
    public homepage verifyReset(){
        wait.fluentWait().until(ExpectedConditions.visibilityOf(driver.get().findElement(ResetAppState)));
        driver.verfy().isvisiable(ResetAppState);
        return this;
    }
//    public homepage ClickClose(){
//        wait.fluentWait().until(ExpectedConditions.elementToBeClickable(closeMenuButton));
//        driver.action().click(closeMenuButton);
//        return this;
//    }
public homepage ClickClose() {
    try {
        org.openqa.selenium.WebDriver rawDriver = driver.get();
        wait.fluentWait().until(ExpectedConditions.presenceOfElementLocated(By.id("react-burger-cross-btn")));
        org.openqa.selenium.WebElement closeButton = rawDriver.findElement(By.id("react-burger-cross-btn"));
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
        js.executeScript("arguments[0].click();", closeButton);
        Thread.sleep(500);
    } catch (Exception e) {
        System.out.println( e.getMessage());
    }
    return this;
}
    public productDetails clickOnProductTitle() {
        try {
            wait.fluentWait().until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(driver.get().findElement(ProductTitle)));
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver.get();
            js.executeScript("arguments[0].click();", driver.get().findElement(ProductTitle));
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new productDetails(driver);
    }
    public productDetails clickAddProductButton() {
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(addProductButton));
            org.openqa.selenium.WebElement element = rawDriver.findElement(addProductButton);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", element);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new productDetails(driver);

    }
    public String removeText(){
        return driver.action().getText(removeButton);
    }
    public productDetails clickRemoveProductButton() {
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(removeButton));
            org.openqa.selenium.WebElement element = rawDriver.findElement(removeButton);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", element);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new productDetails(driver);

    }
    public String addText(){
        return driver.action().getText(addProductButton);
    }
    public CartPage showCartPage() {
        try {
            org.openqa.selenium.WebDriver rawDriver = driver.get();
            wait.fluentWait().until(ExpectedConditions.presenceOfElementLocated(cartIcon));
            org.openqa.selenium.WebElement closeButton = rawDriver.findElement(cartIcon);
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) rawDriver;
            js.executeScript("arguments[0].click();", closeButton);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        return new CartPage(driver);
    }
}
