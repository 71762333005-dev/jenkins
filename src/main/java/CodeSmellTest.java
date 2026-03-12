public class CodeSmellTest {

    public static void main(String[] args) {

        int denominator = 2;

        if (denominator == 0) {
            System.out.println("Denominator cannot be zero");
        } else {
            int result = 10 / denominator;
            System.out.println("Result: " + result);
        }

        String apiKey = System.getenv("API_KEY");

        if (apiKey != null) {
            System.out.println("API Key loaded");
        } else {
            System.out.println("API Key missing");
        }
    }
}
