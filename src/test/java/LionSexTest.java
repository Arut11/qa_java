import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSexTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String UNKNOWN = "unknown";
    private final boolean expected;
    private final String sex;

    Feline feline = Mockito.mock(Feline.class);


    public LionSexTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.expected = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false},
                {UNKNOWN, false}
        };
    }

    @Test
    public void testLionSex() throws Exception {
        try {
            Lion lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        } catch (Exception e) {
            System.out.println("Произошло исключение");
        }
    }

}
