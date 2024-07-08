import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebDriverHelper {
    private static WebDriver driver;
    public static void initDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-http2");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quit(){
        driver.quit();
    }

    public static void loadURL(String url){
        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
    }

    public static WebElement get(By by){
        return driver.findElement(by);
    }

    public static WebElement get(WebElement parent, By by){
        return parent.findElement(by);
    }

    public static List<WebElement> getAll(By by){
        return driver.findElements(by);
    }

    public static WebElement waitDisplayed(By by){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = get(by);
        wait.until(d -> element.isDisplayed());
        return element;
    }

    public static void doClick(By by){
        Actions actions=new Actions(driver);
        WebElement element=driver.findElement(by);
        actions.scrollToElement(element).click(element).perform();
    }

    public static void sendKeys(By by, String text){
        Actions actions=new Actions(driver);
        WebElement element=driver.findElement(by);
        actions.scrollToElement(element).perform();
        element.clear();
        actions.sendKeys(element, text).perform();
    }

    public static void checkAndClick(By by){
        List<WebElement> list=getAll(by);
        if (!list.isEmpty()){
            if (list.get(0).isDisplayed() && list.get(0).isEnabled())
                doClick(by);
        }
    }

    public static void switchToFrame(By by){
        WebElement iframe = get(by);
        driver.switchTo().frame(iframe);
    }

    public static void defaultFrame(){
        driver.switchTo().defaultContent();
    }
}
