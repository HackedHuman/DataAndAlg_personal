public class RecursiveSumTask {

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    public static int sumOfNumbers(int a, int b) {
        if (b == 0) {
            return a;
        }
        return sumOfNumbers(a ^ b, (a & b) << 1);
    }

    public static void execute() {
        int number = 12345;
        int sumOfDigitsResult = sumOfDigits(number);
        System.out.println("Input number: " + number);
        System.out.println("Sum of digits: " + sumOfDigitsResult);

        int a = 7;
        int b = 5;
        int sumOfNumbersResult = sumOfNumbers(a, b);
        System.out.println("Sum of numbers " + a + " and " + b + ": " + sumOfNumbersResult);
    }

    public static void main(String[] args) {
        execute();
    }
}