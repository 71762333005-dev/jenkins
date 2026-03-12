

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger =
            Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        // Read API key from environment variable
        String apiKey = System.getenv("API_KEY");

        try {
            int x = 10 / 2; // safe division
            logger.info("Result: " + x);

        } catch (Exception e) {
            // Proper logging instead of System.out
            logger.log(Level.SEVERE, "Error occurred", e);
        }

        logger.info("Hello World");
    }

    // Method used by test case
    public String getMessage() {
        return "Hello World";
    }
}
