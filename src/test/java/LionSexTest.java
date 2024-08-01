import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class LionSexTest {

    public static final String MALE = "Самец";
    public static final String FEMALE = "Самка";
    public static final String UNKNOWN = "unknown";
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
        Lion lion;
        if ("unknown".equals(sex)) {
            Exception exception = null;
            try {
                new Lion(sex, feline);
            } catch (Exception e) {
                exception = e;
            }
            assertNotNull("Ожидалось исключение, но оно не было выброшено.", exception);
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        } else {
            lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        }
    }

}
