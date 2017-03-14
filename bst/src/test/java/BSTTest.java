import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void test(){
        BST<Integer> tree = new BST<>();

        tree.put(10);
        tree.put(15);
        tree.put(5);
        tree.put(7);

        System.out.println(tree.search(10));
        System.out.println(tree.search(15));
        System.out.println(tree.search(5));
        System.out.println(tree.search(7));

        tree.remove(10);

        System.out.println(tree.search(10));
        System.out.println(tree.search(15));
        System.out.println(tree.search(5));
        System.out.println(tree.search(7));
    }
}