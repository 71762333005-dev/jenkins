import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testMessage() {
        App app = new App();
        assertEquals("Hello World", app.getMessage());
    }

    @Test
    void testDivision() {
        int result = 10 / 2;
        assertEquals(5, result);
    }
}
