import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testDivision() {
        int result = App.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            App.divide(10, 0);
        });
    }

    @Test
    void testMessage() {
        String message = App.getMessage();
        assertEquals("Hello World", message);
    }

    @Test
    void testApiKeyCheck() {
        String message = App.checkApiKey();
        assertNotNull(message);
    }
}
