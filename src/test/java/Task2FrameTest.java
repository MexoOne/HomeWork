import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

@Owner("Поликарпов Михаил")
@DisplayName("Проверка фрейма оплаты услуг связи")
public class Task2FrameTest extends WebDriverHelper implements MtsByConfig, Task2Config{
    @BeforeAll
    static void beforeAll(){
        initDriver();
        loadURL(URL);
        waitDisplayed(ELEMENT_TO_WAIT);

        checkAndClick(POPUP_CANCEL_BUTTON);

        sendKeys(PHONE_FIELD, PHONE_TEXT);
        sendKeys(SUM_FIELD, SUM_TEXT);
        doClick(SUBMIT_BUTTON);

        switchToFrame(FRAME_LOCATOR);
        waitDisplayed(FRAME_ELEMENT_TO_WAIT);
    }

    @Test
    @Description("Проверка отображения суммы в тексте и на кнопке во фрейме оплаты услуг")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Сумма во фрейме оплаты услуг отображается корректно")
    public void testSumInFrame(){
        WebElement sumLabel = waitDisplayed(FRAME_SUM_LABEL);
        Assertions.assertTrue(sumLabel.getText().contains(SUM_TEXT),
                    "Сумма в тексте отличается");

        WebElement sumButton = waitDisplayed(FRAME_BUTTON_WITH_SUM);
        Assertions.assertTrue(sumButton.getText().contains(SUM_TEXT),
                    "Сумма на кнопке отличается");
    }

    @Test
    @Description("Проверка отображения номера телефона во фрейме оплаты услуг")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Телефон во фрейме оплаты услуг отображается корректно")
    public void testPhoneInFrame(){
        WebElement phoneLabel = waitDisplayed(FRAME_PHONE_LABEL);
        Assertions.assertTrue(phoneLabel.getText().contains(PHONE_FRAME_TEXT));
    }

    @Description("Проверка плейсхолдеров формы во фрейме оплаты услуг")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка плейсхолдеров формы во фрейме оплаты услуг")
    @ParameterizedTest(name="Плейсхолдер \"{1}\"")
    @MethodSource("provideFrameFormFields")
    public void testFrameFormPlaceholders(By inputBy, String expText){
        WebElement input = waitDisplayed(inputBy);
        Assertions.assertEquals(expText, input.getText());
    }

    @Test
    @Description("Проверка иконок платёжных систем")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Иконки платёжных систем отображаются")
    public void testPaymentIcons(){
        List<WebElement> fixedImgs = getAll(FRAME_FIXED_IMAGES);
        Assertions.assertEquals(3, fixedImgs.size(), "Неподвижных иконок не 3");
        for (int i=0; i<3; i++){
            Assertions.assertTrue(fixedImgs.get(i).isDisplayed(),
                    "Статичная иконка №"+i+" не отображается");
        }

        try {
            waitDisplayed(FRAME_TOGGLING_IMG_1);
        } catch (TimeoutException e){
            Assertions.fail("Первый кадр анимации не отобразился");
        }
        try {
            waitDisplayed(FRAME_TOGGLING_IMG_2);
        } catch (TimeoutException e){
            Assertions.fail("Второй кадр анимации не отобразился");
        }
    }

    @AfterAll
    static void afterAll(){
        quit();
    }
}
