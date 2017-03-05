import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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

        assertThat(i.toString(), is(Integer.toString(i.hashCode())));
        assertThat(ii.toString(),is(Integer.toString(ii.hashCode())));
        assertThat(s.toString(), is(Integer.toString(s.hashCode())));
        assertThat(ss.toString(),is(Integer.toString(ss.hashCode())));
        assertThat(b.toString(), is(Integer.toString(b.hashCode())));
        assertThat(bb.toString(), is(Integer.toString(bb.hashCode())));

        assertThat(i.toString(), not(i.hashCode()));
        assertThat(ii.toString(),not(i.hashCode()));
        assertThat(s.toString(), not(i.hashCode()));
        assertThat(ss.toString(),not(i.hashCode()));
        assertThat(b.toString(), not(i.hashCode()));
        assertThat(bb.toString(), not(i.hashCode()));

        assertFalse(i.toString() == new String(Integer.toString(i.hashCode())));
        assertFalse(ii.toString() == new String(Integer.toString(ii.hashCode())));
        assertFalse(s.toString() == new String(Integer.toString(s.hashCode())));
        assertFalse(ss.toString() == new String(Integer.toString(ss.hashCode())));
        assertFalse(b.toString() == new String(Integer.toString(b.hashCode())));
        assertFalse(bb.toString() == new String(Integer.toString(bb.hashCode())));


    }

}
