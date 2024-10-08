import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LionTests {

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(LionSexTest.MALE, feline);
    }

    @Test
    public void testGetKittens() {
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        assertEquals(expected, actual);
        }


    @Test
    public void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

    @Test
    public void testLionException() {
        Exception exception = null;
        try {
            new Lion("unknown", feline);
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull("Ожидалось исключение, но оно не было выброшено.", exception);
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
