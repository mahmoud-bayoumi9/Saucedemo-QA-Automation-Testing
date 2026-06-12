package saucedemo.validation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import saucedemo.utiles.Actions.waitManager;

public abstract class BasAssertion {
    protected  final WebDriver driver;
    protected  final waitManager wait;
    protected  final Actions elementAction;
    public BasAssertion(WebDriver driver){
        this.driver=driver;
        this.elementAction=new Actions(driver);
        this.wait=new waitManager(driver);
    }
    protected abstract void assertTrue(boolean condition,String message);
    protected abstract void assertFalse(boolean condition,String message);
    protected abstract void assertequal(String actual,String expected,String message);

}
