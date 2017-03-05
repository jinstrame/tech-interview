import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class ObjectHashTest {
    @Test
    public void test(){
        Integer i = 6;
        Integer ii = -6;
        Short s = 8;
        Short ss = -8;
        Byte b = 127;
        Byte bb = -128;
        assertThat(i.hashCode(), is(6));
        assertThat(ii.hashCode(), is(-6));
        assertThat(s.hashCode(), is(8));
        assertThat(ss.hashCode(), is(-8));
        assertThat(b.hashCode(), is(127));
        assertThat(bb.hashCode(), is(-128));
    }

}
