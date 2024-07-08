import org.openqa.selenium.By;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public interface Task1Config {
    By CONNECTION_FORM = By.id("pay-connection");
    By INTERNET_FORM = By.id("pay-internet");
    By INSTALMENT_FORM = By.id("pay-instalment");
    By ARREARS_FORM = By.id("pay-arrears");

    static Stream<Arguments> provideConnectionFormFields(){
        return Stream.of(
            Arguments.of(By.id("connection-phone"),   "Номер телефона"),
            Arguments.of(By.id("connection-sum"),     "Сумма"),
            Arguments.of(By.id("connection-email"),   "E-mail для отправки чека")
        );
    }

    static Stream<Arguments> provideInternetFormFields(){
        return Stream.of(
            Arguments.of(By.id("internet-phone"),   "Номер абонента"),
            Arguments.of(By.id("internet-sum"),     "Сумма"),
            Arguments.of(By.id("internet-email"),   "E-mail для отправки чека")
        );
    }

    static Stream<Arguments> provideInstalmentFormFields(){
        return Stream.of(
            Arguments.of(By.id("score-instalment"),   "Номер счета на 44"),
            Arguments.of(By.id("instalment-sum"),     "Сумма"),
            Arguments.of(By.id("instalment-email"),   "E-mail для отправки чека")
        );
    }

    static Stream<Arguments> provideArrearsFormFields(){
        return Stream.of(
            Arguments.of(By.id("score-arrears"),   "Номер счета на 2073"),
            Arguments.of(By.id("arrears-sum"),     "Сумма"),
            Arguments.of(By.id("arrears-email"),   "E-mail для отправки чека")
        );
    }
}
