import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.By;

import java.util.stream.Stream;

public interface Task2Config {
    By PHONE_FIELD = By.id("connection-phone");
    By SUM_FIELD = By.id("connection-sum");
    By SUBMIT_BUTTON = By.xpath("//form[@id='pay-connection']/button[@type='submit']");

    By FRAME_ELEMENT_TO_WAIT = By.className("payment-page");
    By FRAME_LOCATOR = By.className("bepaid-iframe");

    By FRAME_SUM_LABEL = By.xpath("//div[@class='pay-description__cost']/span[not(@class='pay-description__cost_converted')]");
    By FRAME_BUTTON_WITH_SUM = By.xpath("//div[@class='card-page__card']/button[@type='submit']");

    By FRAME_PHONE_LABEL = By.xpath("//div[@class='pay-description__text']/span");

    String PHONE_TEXT = "297777777";
    String PHONE_FRAME_TEXT="375"+PHONE_TEXT;

    double SUM_NUM= 50.0 + 100.0*Math.random();
    String SUM_TEXT = String.format("%.2f", SUM_NUM).replace(',','.');

    static Stream<Arguments> provideFrameFormFields(){
        return Stream.of(
            Arguments.of(By.xpath("//input[@formcontrolname='creditCard']/../label"), "Номер карты"),
            Arguments.of(By.xpath("//input[@formcontrolname='expirationDate']/../label"), "Срок действия"),
            Arguments.of(By.xpath("//input[@formcontrolname='cvc']/../label"), "CVC"),
            Arguments.of(By.xpath("//input[@formcontrolname='holder']/../label"), "Имя держателя (как на карте)")
        );
    }

    By FRAME_FIXED_IMAGES = By.xpath("//div[contains(@class, 'cards-brands__container')]/img");
    By FRAME_TOGGLING_IMG_1 = By.xpath("//div[contains(@class, 'cards-brands_random')]/img[1]");
    By FRAME_TOGGLING_IMG_2 = By.xpath("//div[contains(@class, 'cards-brands_random')]/img[2]");
}
