import org.junit.Assert;
import org.junit.Test;

public class BSTTest {

    @Test
    public void testBST() {
        BST bst = new BST();
        // Test case 1
        for (int i = 0; i < 20; i++) {
            int key = 5 + i; // Assuming N = 5
            String value = "Value" + key;
            bst.insert(key, value);
        }

        // Test case 2
        bst.traverse();
        Assert.assertEquals(20, countNodes(bst));

        // Test case 3
        for (int i = 5; i < 15; i++) {
            int key = 5 + i;
            String expectedValue = "Value" + key;
            String actualValue = bst.search(key);
            Assert.assertEquals(expectedValue, actualValue);
        }
        Assert.assertNull(bst.search(100));

        // Test case 4
        bst.delete(15);
        bst.traverse();
        Assert.assertEquals(19, countNodes(bst));
        bst.insert(15, "NewValue15");
        bst.insert(18, "UpdatedValue18");
        bst.traverse();
        Assert.assertEquals(20, countNodes(bst));
        Assert.assertEquals("NewValue15", bst.search(15));
        Assert.assertEquals("UpdatedValue18", bst.search(18));

        // Test case 5
        bst.delete(10);
        bst.traverse();
        Assert.assertEquals(19, countNodes(bst));
        Assert.assertNull(bst.search(10));
    }

    private int countNodes(BST bst) {
        CountNodesVisitor visitor = new CountNodesVisitor();
        bst.traverse(visitor);
        return visitor.getCount();
    }

    private static class CountNodesVisitor implements BSTVisitor {
        private int count;

        @Override
        public void visit(BSTNode node) {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}