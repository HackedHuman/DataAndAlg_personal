public class Main {
    public static void main(String[] args) {
        // Завдання 1 та 2
        RecursionTask recursionTask = new RecursionTask();
        int n = 5;

        int recursionFactorialResult = recursionTask.recursionExecuteFactorial(n);
        int cycleFactorialResult = recursionTask.cycleExecuteFactorial(n);
        assert recursionFactorialResult == cycleFactorialResult : "Different values for factorial";

        int recursionFibonacciResult = recursionTask.recursionExecuteFibonacci(n);
        int cycleFibonacciResult = recursionTask.cycleExecuteFibonacci(n);
        assert recursionFibonacciResult == cycleFibonacciResult : "Different values for Fibonacci";

        System.out.println("Factorial of " + n + ": " + recursionFactorialResult);
        System.out.println("Fibonacci of " + n + ": " + recursionFibonacciResult);

        // Завдання 3 та 4
        RecursiveSumTask recursiveSumTask = new RecursiveSumTask();
        recursiveSumTask.execute();
    }
}