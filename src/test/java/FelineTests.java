
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    @Spy
    Feline feline;


    @Test
    public void testEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);


    }

    @Test
    public void testGetFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittens() {
        int expected = 1;
        Mockito.when(feline.getKittens(1)).thenReturn(expected);
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensConstructor() {
        int expected = 3;
        int actual = feline.getKittens(3);
        assertEquals(expected, actual);
    }

}
