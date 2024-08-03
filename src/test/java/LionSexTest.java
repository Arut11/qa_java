import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSexTest {

    public static final String MALE = "Самец";
    public static final String FEMALE = "Самка";
    private final boolean expected;
    private final String sex;

    private Feline feline = Mockito.mock(Feline.class);

    public LionSexTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.expected = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false}
        };
    }


    @Test
    public void testLionSex() throws Exception {
            Lion lion;
            lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);

    }

}
