import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class SeleniumHelper {
    private static WebDriver driver;
    private static int currentTimeout;
    private static final int DEF_TIMEOUT =10;
    private static final int DEF_PERIOD =300;

    public static void prepareDriver(){
        driver=new ChromeDriver();
        setTimeout(DEF_TIMEOUT);
    }

    public static void quit(){
        driver.close();
        driver.quit();
    }

    public static int setTimeout(int sec){
        int old=currentTimeout;
        currentTimeout =sec;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(currentTimeout));
        return old;
    }

    public static WebElement get(By by){
        return driver.findElement(by);
    }

    public static WebElement get(WebElement group, By by){
        return group.findElement(by);
    }

    public static List<WebElement> getAll(By by){
        return driver.findElements(by);
    }

    public static void waitDisplayed(By by){
        int saveTimeout=setTimeout(0);

        Wait<WebDriver> wait =
        new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(saveTimeout))
            .pollingEvery(Duration.ofMillis(DEF_PERIOD))
            .ignoring(NoSuchElementException.class);

        wait.until(d->{
            WebElement res =d.findElement(by);
            return res.isDisplayed();
        });

        setTimeout(saveTimeout);
    }

    public static void loadURL(String url){
        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);

            //похоже под Селениумом иногда почему-то прерываются скрипты на странице
            //в этом случае прокрутка туда-обратно защищает от непрогруза элементов
            //странно, да, но другие способы такие же шаманские, но медленнее и/или более громоздки
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)", "");
            js.executeScript("window.scrollBy(0,-300)", "");
        }
    }

    public static String getTitle(){
        return driver.getTitle();
    }

    public static void doClick(By by){
        Actions actions=new Actions(driver);
        protectedAction(d -> {
            WebElement wel=d.findElement(by);
            actions.scrollToElement(wel).click(wel).perform();
            return true;
        });
    }

    public static void doSendKeys(By by, String text){
        Actions actions=new Actions(driver);
        protectedAction(d->{
            WebElement element=d.findElement(by);
            element.clear();
            actions.scrollToElement(element).sendKeys(element, text).perform();
            return true;
        });
    }

    //Защита от недогрузов, динамических изменений и временных перекрытий элементов при применении Actions
    //Всё из перечисленного случайно попадалось и внезапно клало тетсты
    public static void protectedAction(Function<WebDriver, Object> func){
        int saveTimeout=setTimeout(0);

        Wait<WebDriver> wait =
        new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(saveTimeout))
            .pollingEvery(Duration.ofMillis(DEF_PERIOD))
            .ignoring(ElementNotInteractableException.class,
                      StaleElementReferenceException.class)
            .ignoring(NoSuchElementException.class);

        wait.until(func);

        setTimeout(saveTimeout);
    }

    public static boolean checkAndClick(By by){
        List<WebElement> list= getAll(by);
        if (!list.isEmpty() && list.get(0).isDisplayed() && list.get(0).isEnabled()){
            doClick(by);
            return true;
        }
        return false;
    }

    public static boolean waitForFrameThatHas(By by){
        int saveTimeout=setTimeout(0);

        Wait<WebDriver> wait =
        new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(saveTimeout * 4L)) //фрейм в среднем грузится сильно дольше остального
            .pollingEvery(Duration.ofMillis(DEF_PERIOD))
            .ignoring(NoSuchFrameException.class,
                      NoSuchElementException.class);

        try {
            wait.until(d -> {
                int i=0;
                while (true) {
                    d.switchTo().frame(i);
                    try {
                        d.findElements(by);
                        return true;
                    }catch(NoSuchElementException e){}
                    d.switchTo().defaultContent();
                    i++;
                }
            });
        } catch(TimeoutException e){
            return false;
        } finally {
            setTimeout(saveTimeout);
        }
        return true;
    }

    public static void defaultFrame(){
        driver.switchTo().defaultContent();
    }

    //Не используется. Бывает нужно при отладке
    public static void sleep(int sec){
        try {
            Thread.sleep(sec*1000L);
        }catch(Exception e){}
    }
}
