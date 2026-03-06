public class App {

    public static void main(String[] args) {

        // Load API key securely instead of hardcoding
        String apiKey = System.getenv("API_KEY");

        if (apiKey == null) {
            System.out.println("API key not found.");
        } else {
            System.out.println("API key loaded securely.");
        }

        try {
            int x = 10 / 2; // Fixed division
            System.out.println("Result: " + x);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        System.out.println("Hello World");
    }
}
