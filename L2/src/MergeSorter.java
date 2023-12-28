import java.util.ArrayList;

public class MergeSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> array = new ArrayList<>(input);

        if (array.size() <= 1) {
            return array;
        }

        int middle = array.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(array.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(array.subList(middle, array.size()));

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }
}
