import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalGetFoodTest {

    public static final String HERBIVORE = "Травоядное";
    public static final String PREDATOR = "Хищник";
    public static final List<String> EXPECTED_HERBIVORE = List.of("Трава", "Различные растения");
    public static final List<String> EXPECTED_PREDATOR = List.of("Животные", "Птицы", "Рыба");
    private final String animalKind;
    private final List<String> expected;


    private Animal animal = new Animal();


    public AnimalGetFoodTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.expected = food;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {HERBIVORE, EXPECTED_HERBIVORE},
                {PREDATOR, EXPECTED_PREDATOR}
        };
    }

    @Test
    public void testLionSex() throws Exception {
            List<String> actual = animal.getFood(animalKind);
            assertEquals(expected, actual);
    }

}



