import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    @Test
    void test(){
        MyMap<Integer, String> map = new ChainMap<>(10);
        map.put(0, "this is 0");
        map.put(113, "this is 113");
        map.put(598614, "this is 598614");

        assertThat(map.get(3), is(nullValue()));
        assertThat(map.get(113), is("this is 113"));

        assertThat(map.remove(0), is("this is 0"));
        assertThat(map.remove(0), is(nullValue()));
    }
}