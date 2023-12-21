import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformanceComparison {

    public static void main(String[] args) {
        int listSize = 100000;
        int elementsToInsert = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        measureFill(arrayList, listSize, "ArrayList");
        measureFill(linkedList, listSize, "LinkedList");

        measureRandomAccess(arrayList, "ArrayList");
        measureRandomAccess(linkedList, "LinkedList");

        measureSequentialAccess(arrayList, "ArrayList");
        measureSequentialAccess(linkedList, "LinkedList");

        measureInsertAtBeginning(arrayList, elementsToInsert, "ArrayList");
        measureInsertAtBeginning(linkedList, elementsToInsert, "LinkedList");

        measureInsertAtEnd(arrayList, elementsToInsert, "ArrayList");
        measureInsertAtEnd(linkedList, elementsToInsert, "LinkedList");

        measureInsertInMiddle(arrayList, elementsToInsert, "ArrayList");
        measureInsertInMiddle(linkedList, elementsToInsert, "LinkedList");
    }

    private static void measureFill(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt());
        }
        System.out.printf("Fill %s: %d%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureRandomAccess(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int value = list.get(i);
        }
        System.out.printf("Random access in %s: %d%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureSequentialAccess(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        for (int value : list) {
            // Access elements sequentially
        }
        System.out.printf("Sequential access in %s: %d%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureInsertAtBeginning(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        System.out.printf("Insert at the beginning of %s: %d%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureInsertAtEnd(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < count; i++) {
            list.add(size + i);
        }
        System.out.printf("Insert at the end of %s: %d%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureInsertInMiddle(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < count; i++) {
            list.add(size / 2, i);
        }
        System.out.printf("Insert in the middle of %s: %d%n", listType, System.currentTimeMillis() - time);
    }
}
