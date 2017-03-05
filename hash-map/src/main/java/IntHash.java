import lombok.SneakyThrows;

public class IntHash {
    @SneakyThrows
    public static int hashCode(int x){
        if (x < 1)
            throw new Exception("out of range");
        if (x > 1000000)
            throw new Exception("out of range");

        x--;
        x %= 1000;
        return x + 1;
    }
}
