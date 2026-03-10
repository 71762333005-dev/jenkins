public class App {

    public static String checkApiKey() {
        String apiKey = System.getenv("API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            return "API key not found.";
        } else {
            return "API key loaded securely.";
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {

        System.out.println(checkApiKey());

        try {
            int x = divide(10, 2);
            System.out.println("Result: " + x);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        System.out.println("Application executed successfully.");
    }
}
