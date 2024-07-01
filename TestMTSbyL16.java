import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

@DisplayName("Продолжение проверки блока «Онлайн пополнение без комиссии» на mts.by")
public class TestMTSbyL16 extends SeleniumHelper implements ConfigL16{
    @BeforeAll
    static void beforeAll(){
        prepareDriver(CHROME_CONFIG);
        loadURL(URL);
        waitDisplayed(By.id("pay-section"));
    }

    @BeforeEach
    void beforeEach(){
        //закрываю попап, если появился
        checkAndClick(By.className("cookie__cancel"));
    }

    @DisplayName("1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг")
    @ParameterizedTest(name="На форме \"{0}\" плейсхолдер \"{2}\"")
    @CsvSource({
            "pay-connection,    connection-phone,   Номер телефона",
            "pay-connection,    connection-sum,     Сумма",
            "pay-connection,    connection-email,   E-mail для отправки чека",

            "pay-internet,  internet-phone, Номер абонента",
            "pay-internet,  internet-sum,   Сумма",
            "pay-internet,  internet-email, E-mail для отправки чека",

            "pay-instalment,    score-instalment,   Номер счета на 44",
            "pay-instalment,    instalment-sum,     Сумма",
            "pay-instalment,    instalment-email,   E-mail для отправки чека",

            "pay-arrears,   score-arrears,  Номер счета на 2073",
            "pay-arrears,   arrears-sum,    Сумма",
            "pay-arrears,   arrears-email,  E-mail для отправки чека"

    })
    public void testFormInputPlaceholders(String formId, String inputId, String expText){
        WebElement form=get(By.id(formId));
        WebElement input=get(form, By.id(inputId));
        Assertions.assertEquals(expText, input.getAttribute("placeholder"));
    }

    @Nested
    @DisplayName("2. Проверить фрейм оплаты для варианта «Услуги связи»")
    public class testPaymentFrame{
        @BeforeEach
        public void openForm(){
            By payment=By.className("payment-page");

            if (!has(payment)) {
                By phone= By.id("connection-phone");
                By sum= By.id("connection-sum");
                By submit= By.xpath("//form[@id='pay-connection']/button[@type='submit']");

                doSendKeys(phone, PHONE_TEXT);
                doSendKeys(sum, SUM_TEXT);
                doClick(submit);

                waitForFrameThatHas(payment);
            }
        }

        @Test
        @DisplayName("Корректность отображения суммы")
        public void testSum(){
            By sumLabel=By.xpath("//div[@class='pay-description__cost']/span[not(@class='pay-description__cost_converted')]");
            By sumButton=By.xpath("//div[@class='card-page__card']/button[@type='submit']");

            waitDisplayed(sumLabel);
            Assertions.assertTrue(get(sumLabel).getText().contains(SUM_TEXT),
                    "Сумма в тексте отличается");
            Assertions.assertTrue(get(sumButton).getText().contains(SUM_TEXT),
                    "Сумма на кнопке отличается");
        }

        @Test
        @DisplayName("Корректность отображения номера телефона")
        public void testPhone(){
            By phoneLabel =By.xpath("//span[@class='pay-description__text']");

            waitDisplayed(phoneLabel);
            Assertions.assertTrue(get(phoneLabel).getText().contains(PHONE_EXP));
        }

        @DisplayName("Корректность надписей в незаполненных полях формы оплаты")
        @ParameterizedTest(name="Плейсхолдер \"{1}\"")
        @CsvSource({
                "//input[@formcontrolname='creditCard'],        Номер карты",
                "//input[@formcontrolname='expirationDate'],    Срок действия",
                "//input[@formcontrolname='cvc'],               CVC",
                "//input[@formcontrolname='holder'],            Имя держателя (как на карте)"
        })
        public void testPlaceholders(String xpath, String exp){
            By label=By.xpath(xpath + "/../label");

            waitDisplayed(label);
            Assertions.assertEquals(exp, get(label).getText());
        }

        @DisplayName("Наличие иконок платёжных систем")
        @Test
        public void testPayIcons(){
            By fixedImgs=By.xpath("//div[contains(@class, 'cards-brands__container')]/img");
            By toggleImg1=By.xpath("//div[contains(@class, 'cards-brands_random')]/img[1]");
            By toggleImg2=By.xpath("//div[contains(@class, 'cards-brands_random')]/img[2]");

            List<WebElement> imgs=getAll(fixedImgs);
            Assertions.assertEquals(3, imgs.size(), "Неподвижных иконок не 3");
            for (WebElement img: imgs){
                Assertions.assertTrue(img.isDisplayed());
            }

            try{
                waitAttribute(toggleImg2, "style", "opacity: 1");
            } catch (TimeoutException e){
                Assertions.fail("Второй кадр анимации не отобразился");
            }
            try{
                waitAttribute(toggleImg1, "style", "opacity: 1");
            } catch (TimeoutException e){
                Assertions.fail("Первый кадр анимации не отобразился");
            }
        }
    }

    @AfterAll
    public static void afterAll(){
        quit();
    }
}
