import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@DisplayName("Проверка блока «Онлайн пополнение без комиссии» на mts.by")
@TestMethodOrder(MethodOrderer.Random.class)
public class TestMTSbyL15 extends SeleniumHelper{
    final static String URL="https://www.mts.by/";

    @BeforeAll
    static void beforeAll(){
        prepareDriver();
    }

    @BeforeEach
    void beforeEach(){
        loadURL(URL);
        defaultFrame();
        waitDisplayed(By.id("pay-section"));

        //закрываю попап, если появился
        checkAndClick(By.className("cookie__cancel"));
    }

    @DisplayName("1. Проверить название указанного блока")
    @Test
    void testBlockTitle(){
        final String EXP_TEXT="Онлайн пополнение\nбез комиссии";
        WebElement title= get(By.xpath("//div[@class='pay__wrapper']/h2"));
        Assertions.assertEquals(EXP_TEXT, title.getText(),
                "Название блока не " + EXP_TEXT);
    }

    @DisplayName("2. Проверить наличие логотипов платёжных систем")
    @Test
    void testPayLogos(){
        final int LOGO_COUNT=5;

        List<WebElement> logosList= getAll(By.xpath("//div[@class='pay__partners']/ul/li"));
        Assertions.assertEquals(LOGO_COUNT, logosList.size(), "Количество лого не "+LOGO_COUNT);

        By img=By.tagName("img");
        for (int i=0; i<logosList.size(); i++) {
            WebElement logo = get(logosList.get(i), img);
            Assertions.assertTrue(logo.isDisplayed(), "Лого №"+(i+1)+" не отображается");
        }
    }

    @DisplayName("3. Проверить работу ссылки «Подробнее о сервисе»")
    @Test
    void testLearnMoreLink(){
        final String EXP_TITLE="Порядок оплаты и безопасность интернет платежей";

        By link= By.xpath("//div[@class='pay__wrapper']/a[text()='Подробнее о сервисе']");
        doClick(link);
        waitDisplayed(By.xpath("//h3[contains(text(), 'Оплата банковской картой')]"));
        Assertions.assertEquals(EXP_TITLE, getTitle(),
                "Ссылка не привела на страницу '" + EXP_TITLE +"'");
    }

    @DisplayName("4. Заполнить поля и проверить работу кнопки «Продолжить»")
    @Test
    void testFillFieldsAndContinue() {
        final String PHONE_TEXT = "297777777";
        final String SUM_TEXT = "100";

        By phone= By.id("connection-phone");
        By sum= By.id("connection-sum");
        By submit= By.xpath("//form[@id='pay-connection']/button[@type='submit']");

        //цикл нужен, т.к. попап может вылезти c задержкой или повторно, поля при этом очищаются
        do {
            doSendKeys(phone, PHONE_TEXT);
            doSendKeys(sum, SUM_TEXT);
            doClick(submit);
        } while (checkAndClick(By.className("cookie__cancel")));

        boolean find=waitForFrameThatHas(By.className("payment-page"));
        Assertions.assertTrue(find, "Фрейм оплаты счёта мобильного не появился");

        By close=By.className("header__close-button");
        waitDisplayed(close);
        doClick(close);
    }

    @AfterAll
    public static void afterAll(){
        quit();
    }
}