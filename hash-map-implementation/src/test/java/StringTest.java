import org.junit.jupiter.api.Test;

/**
 * Created by jinst on 07.03.2017.
 */
public class StringTest {
    @Test
    void test(){
        String a = "10";
        String b = "100";

        int aa = Integer.valueOf(a);
        int bb = Integer.valueOf(b);

        System.out.println(aa);
        System.out.println(a.hashCode());
        System.out.println(bb);
        System.out.println(b.hashCode());


        for (int i = Integer.MIN_VALUE; i != Integer.MA  X_VALUE; i++){
            String s = String.valueOf(i);
            if (s.hashCode() == Integer.valueOf(s)){
                System.out.println(s);
                break;
            }
        }
    }
}
