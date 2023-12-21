import java.util.ArrayList;
import java.util.Arrays;

public class SortingBenchmark {

    public static void main(String[] args) {
        for (int count : new int[]{10, 1000, 10000, 1000000}) {
            System.out.println("Number of elements: " + count);

            ArrayList<Integer> array = generateArray(count);

            for (SortingType type : SortingType.values()) {
                System.out.println("Sorting type: " + type);

                Sorter sorter = getSorter(type);

                long startTime = System.currentTimeMillis();
                ArrayList<Integer> sortedArray = sorter.sort(new ArrayList<>(array));
                long endTime = System.currentTimeMillis();

                System.out.println("Time taken: " + (endTime - startTime) + " ms");

                // Print the first 50 elements of the sorted array
                System.out.println("Sorted array: " + Arrays.toString(sortedArray.subList(0, Math.min(50, count)).toArray()));
            }
        }
    }

    private static ArrayList<Integer> generateArray(int count) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            array.add((int) (Math.random() * count));
        }
        return array;
    }

    private static Sorter getSorter(SortingType type) {
        switch (type) {
            case BUBBLE:
                return new BubbleSorter();
            case SHELL:
                return new ShellSorter();
            case MERGE:
                return new MergeSorter();
            case QUICK:
                return new QuickSorter();
            default:
                throw new IllegalArgumentException("Unsupported sorting type: " + type);
        }
    }
}