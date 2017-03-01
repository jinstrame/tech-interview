import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortUtilityTest {
    @Test
    void recursiveBubbleTest() {
        Integer[] array = {6, 11, 67, 22, 1, -20, 45, 29, -100, 55};

        SortUtility.recursiveBubble(array);

        Integer[] expected = {-100, -20, 1, 6, 11, 22, 29, 45, 55, 67};
        assertArrayEquals(expected, array);
        System.out.println("sorted array = " + Arrays.toString(array));
    }
}