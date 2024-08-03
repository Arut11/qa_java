import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void testGetFood() throws Exception {
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.eatMeat()).thenReturn(expected);
            List<String> actual = cat.getFood();
            assertEquals(expected, actual);

    }

}
