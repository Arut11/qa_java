import com.example.Animal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnimalTests {

    public static final String EXPECTED_GET_FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    private Animal animal = new Animal();

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();
        assertEquals(EXPECTED_GET_FAMILY, actual);
    }

    @Test
    public void testGetFoodException() {
        Exception exception = null;
        try {
            animal.getFood("unknown");
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull("Ожидалось исключение, но оно не было выброшено.", exception);
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

}
