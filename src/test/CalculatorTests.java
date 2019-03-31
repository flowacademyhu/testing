import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    @Test
    public void multiplicationWorks() {
        Calculator calc = new Calculator();
        assertEquals(50, calc.multiply(10, 5), "10x5 should be 50");
    }
}