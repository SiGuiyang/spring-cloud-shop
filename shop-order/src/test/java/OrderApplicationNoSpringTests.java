import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class OrderApplicationNoSpringTests {


    @Test
    public void testArrays() {

        String temp = null;
        List<String> strings = Arrays.asList("1", "2", "3", "4", Optional.ofNullable(temp).orElseGet(() -> ""));
        System.out.println(strings);
    }

}
