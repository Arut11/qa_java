import com.example.Animal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnimalTests {

    public static final String EXPECTED_GET_FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    Animal animal = new Animal();

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();
        assertEquals(EXPECTED_GET_FAMILY, actual);
    }

}
