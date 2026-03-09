public class App {

    public static void main(String[] args) {

        String apiKey = "123456SECRETKEY"; // Hardcoded secret (security issue)

        try {
            int x = 10 / 0;
        } catch (Exception e) {
        } // Empty catch block (Code Smell)

        System.out.println("Hello World");
    }
}
