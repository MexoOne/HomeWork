import org.openqa.selenium.By;

public interface MtsByConfig {
    String URL = "https://www.mts.by/";

    By ELEMENT_TO_WAIT = By.id("pay-section");
    By POPUP_CANCEL_BUTTON = By.className("cookie__cancel");
}
