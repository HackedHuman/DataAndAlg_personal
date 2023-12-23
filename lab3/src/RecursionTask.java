public class RecursionTask {

    public static int recursionExecuteFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * recursionExecuteFactorial(n - 1);
    }

    public static int recursionExecuteFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recursionExecuteFibonacci(n - 1) + recursionExecuteFibonacci(n - 2);
    }

    public static int cycleExecuteFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int cycleExecuteFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 5;

        int recursionFactorialResult = recursionExecuteFactorial(n);
        int cycleFactorialResult = cycleExecuteFactorial(n);
        assert recursionFactorialResult == cycleFactorialResult : "Different values for factorial";

        int recursionFibonacciResult = recursionExecuteFibonacci(n);
        int cycleFibonacciResult = cycleExecuteFibonacci(n);
        assert recursionFibonacciResult == cycleFibonacciResult : "Different values for Fibonacci";

        System.out.println("Factorial of " + n + ": " + recursionFactorialResult);
        System.out.println("Fibonacci of " + n + ": " + recursionFibonacciResult);
    }
}