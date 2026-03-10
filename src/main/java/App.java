public class App {

    public static void main(String[] args) {

        // Fix 1: Read API key from environment variable
        String apiKey = System.getenv("API_KEY");

        try {
            int x = 10 / 2; // Fix 2: avoid division by zero
            System.out.println("Result: " + x);

        } catch (Exception e) {
            // Fix 3: handle exception properly
            System.out.println("Error occurred: " + e.getMessage());
        }

        System.out.println("Hello World");
    }

    // Method added so test case works
    public String getMessage() {
        return "Hello World";
    }
}
