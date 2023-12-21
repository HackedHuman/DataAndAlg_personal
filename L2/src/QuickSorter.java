import java.util.ArrayList;

public class QuickSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input == null || input.size() <= 1) {
            return input;
        }

        quickSort(input, 0, input.size() - 1);
        return input;
    }

    private void quickSort(ArrayList<Integer> input, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(input, low, high);

            quickSort(input, low, pivotIndex - 1);
            quickSort(input, pivotIndex + 1, high);
        }
    }

    private int partition(ArrayList<Integer> input, int low, int high) {
        int pivot = input.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (input.get(j) < pivot) {
                i++;
                swap(input, i, j);
            }
        }

        swap(input, i + 1, high);
        return i + 1;
    }

    private void swap(ArrayList<Integer> input, int i, int j) {
        int temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }
}