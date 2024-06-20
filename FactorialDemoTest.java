import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Тест метода рассчёта факториала")
class FactorialDemoTest {

    @DisplayName("Позитивные тесты: неотрицательные параметры")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "3, 6", "5, 120"})
    void testFactorialPositive(int n, long nf){
        Assertions.assertEquals(FactorialDemo.factorial(n), nf);
    }

    @DisplayName("Негативный тест: отрицательный параметр")
    @Test
    void testFactorialNegative(){
        Assertions.assertAll("Отрицательные параметры",
                () -> Assertions.assertEquals(FactorialDemo.factorial(-1),-1),
                () -> Assertions.assertEquals(FactorialDemo.factorial(-2),-1)
        );
    }
}