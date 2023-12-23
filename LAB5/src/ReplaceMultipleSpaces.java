public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String inputString = "Я хочу    бути     програмістом";
        String regex = "\\s+";

        String result = inputString.replaceAll(regex, " ");
        System.out.println(result);
    }
}