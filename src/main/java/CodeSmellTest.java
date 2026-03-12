public class App {

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        return a / b;
    }

    public static void main(String[] args) {

        int denominator = 2;

        try {
            int result = divide(10, denominator);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        String apiKey = System.getenv("API_KEY");

        if (apiKey != null && !apiKey.isEmpty()) {
            System.out.println("API Key loaded");
        } else {
            System.out.println("API Key missing");
        }
    }
}
