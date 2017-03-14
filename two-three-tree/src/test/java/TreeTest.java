import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void test(){
        Tree<Integer> tree = new Tree<>();
        tree.put(10);
        tree.put(5);
        tree.put(15);
        tree.put(7);

        System.out.println(tree.search(10));
        System.out.println(tree.search(5));
        System.out.println(tree.search(15));
        System.out.println(tree.search(7));
    }

}