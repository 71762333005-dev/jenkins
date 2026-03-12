

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testGetMessage() {
        App app = new App();
        assertEquals("Hello World", app.getMessage());
    }

    @Test
    void testAppCreation() {
        App app = new App();
        assertNotNull(app);
    }
}
