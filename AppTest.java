import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testDivision() {
        int result = 10 / 2;
        assertEquals(5, result);
    }

    @Test
    void testMessage() {
        String message = "Hello World";
        assertNotNull(message);
    }
}
