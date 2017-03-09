import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    @Test
    void test(){
        Tree<Integer> tree = new Tree<>(0);
        tree.getRoot().addChild(1).addChild(2);
        val child3 =  tree.getRoot().addChild(3);
        child3.addChild(4);
        child3.addChild(5);
        //tree.postOrderDFS().forEach(System.out::println);
        System.out.println(tree.getRoot().getSize());

    }
}