package saucedemo.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;
import saucedemo.utiles.Actions.AllertActions;
import saucedemo.utiles.Actions.BrowserActions;
import saucedemo.utiles.Actions.elementActions;
import saucedemo.utiles.Actions.frameActions;
import saucedemo.validation.validation;
import saucedemo.validation.verification;

import java.util.HashMap;
import java.util.Map;
public class GuiDriver {
    private final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public GuiDriver() {
        WebDriver rawDriver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // تشغيل بدون واجهة
        options.addArguments("--disable-gpu"); // إيقاف الجرافيكس لتسريع الأداء
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--no-first-run");
        options.addArguments("--headless=new"); // تشغيل بدون شاشة
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-notifications");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.popups", 1);
        options.setExperimentalOption("prefs", prefs);
        rawDriver = new ChromeDriver();
        switch ("edge") {
            case "edge":
                rawDriver = new ChromeDriver(options);
//                rawDriver = new EdgeDriver();
                break;
//            case "firefox":
//                rawDriver = new FirefoxDriver();
//                break;
            default:
                throw new IllegalArgumentException("❌ متصفح غير مدعوم: " );
        }


        WebDriver protectedDriver = ThreadGuard.protect(rawDriver);

        driverThreadLocal.set(protectedDriver);
    }
    public elementActions action(){
        return new elementActions(get());
    }
    public BrowserActions brows(){
        return new BrowserActions(get());
    }
    public frameActions frameActions(){
        return new frameActions(get());
    }
    public AllertActions allertActions(){
        return new AllertActions(get());
    }
    public validation validation(){
        return new validation(get());
    }
    public verification verfy(){
        return  new verification(get());

    }

    public WebDriver get() {
        return driverThreadLocal.get();
    }

    public void quit() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}