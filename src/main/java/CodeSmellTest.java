public class CodeSmellTest {

    public static void main(String[] args) {

        try {
            int denominator = 2; // ensure it is not zero

            if (denominator != 0) {
                int result = 10 / denominator;
                System.out.println("Result: " + result);
            } else {
                System.out.println("Denominator cannot be zero.");
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        // Fix hardcoded API key
        String apiKey = System.getenv("API_KEY");
        System.out.println("API Key: " + apiKey);
    }
}
