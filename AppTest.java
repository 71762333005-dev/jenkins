import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testDivide() {
        assertEquals(5, App.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> App.divide(10, 0)
        );

        assertEquals("Denominator cannot be zero", exception.getMessage());
    }
}
