import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DisplayName("Проверка плейсхолдеров элементов форм оплаты услуг")
public class Task1PlaceholdersTest extends WebDriverHelper implements MtsByConfig, Task1Config{
    @BeforeAll
    static void beforeAll(){
        initDriver();
        loadURL(URL);
        get(ELEMENT_TO_WAIT);
        checkAndClick(POPUP_CANCEL_BUTTON);
    }

    @DisplayName("Плейсхолдеры формы \"Услуги связи\"")
    @ParameterizedTest(name="Плейсхолдер \"{1}\"")
    @MethodSource("provideConnectionFormFields")
    public void testConnectionFormFields(By inputBy, String expText){
        WebElement form=get(CONNECTION_FORM);
        WebElement input=get(form, inputBy);
        Assertions.assertEquals(expText, input.getAttribute("placeholder"));
    }

    @DisplayName("Плейсхолдеры формы \"Домашний интернет\"")
    @ParameterizedTest(name="Плейсхолдер \"{1}\"")
    @MethodSource("provideInternetFormFields")
    public void testInternetFormFields(By inputBy, String expText){
        WebElement form=get(INTERNET_FORM);
        WebElement input=get(form, inputBy);
        Assertions.assertEquals(expText, input.getAttribute("placeholder"));
    }

    @DisplayName("Плейсхолдеры формы \"Рассрочка\"")
    @ParameterizedTest(name="Плейсхолдер \"{1}\"")
    @MethodSource("provideInstalmentFormFields")
    public void testInstalmentFormFields(By inputBy, String expText){
        WebElement form=get(INSTALMENT_FORM);
        WebElement input=get(form, inputBy);
        Assertions.assertEquals(expText, input.getAttribute("placeholder"));
    }

    @DisplayName("Плейсхолдеры формы \"Задолжность\"")
    @ParameterizedTest(name="Плейсхолдер \"{1}\"")
    @MethodSource("provideArrearsFormFields")
    public void testArrearsFormFields(By inputBy, String expText){
        WebElement form=get(ARREARS_FORM);
        WebElement input=get(form, inputBy);
        Assertions.assertEquals(expText, input.getAttribute("placeholder"));
    }

    @AfterAll
    static void afterAll(){
        quit();
    }
}
