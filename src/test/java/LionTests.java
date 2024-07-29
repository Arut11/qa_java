import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class LionTests {

    private static final String MALE = "Самец";
    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetKittens() throws Exception {
        int expected = 1;

        try {
            lion = new Lion(MALE, feline);
            Mockito.when(feline.getKittens()).thenReturn(expected);
            int actual = lion.getKittens();
            assertEquals(expected, actual);
        } catch (Exception e) {
            System.out.println("Произошло исключение");
        }
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        try {
            lion = new Lion(MALE, feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
            List<String> actual = lion.getFood();
            assertEquals(expected, actual);
        } catch (Exception e) {
            System.out.println("Произошло исключение");
        }
    }

}
