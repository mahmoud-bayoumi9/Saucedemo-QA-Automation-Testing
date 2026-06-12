package saucedemo.Pages;

import saucedemo.drivers.GuiDriver;

public class NavigationPage {
    private final GuiDriver driver;

    public NavigationPage(GuiDriver driver) {
        this.driver = driver;
    }
    public  LoginPage navigate(){
        driver.brows().navigateToSpecificUrl("https://www.saucedemo.com/");
        return new LoginPage(driver);

}
}
