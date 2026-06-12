package saucedemo;

import org.openqa.selenium.WebDriver;
import saucedemo.drivers.GuiDriver;
import saucedemo.drivers.webDriverProvider;

public class baseTest implements webDriverProvider {
    protected GuiDriver driver;
    @Override
    public WebDriver getWebDriver() {
        return driver.get();
    }
}
