import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Feline feline;

    private final String sex;

    @Parameterized.Parameters
    public static Object[][] getParamsData() {
        return new Object[][]{
                {"Самец"},
                {"Самка"},
                {"Самка1"},
        };
    }

    public LionParameterizedTest(String sex) {
        this.sex = sex;
    }

    @Test
    public void doesHaveMane() throws Exception {
        if ("Самец".equals(sex)) {
            Lion lion = new Lion(sex, feline);
            Assert.assertTrue(lion.doesHaveMane());
        } else if ("Самка".equals(sex)) {
            Lion lion = new Lion(sex, feline);
            Assert.assertFalse(lion.doesHaveMane());
        }
    }

    @Test
    public void lionConstructor() throws Exception {
        if ("Самец".equals(sex)) {
            new Lion(sex, feline);
        } else if ("Самка".equals(sex)) {
            new Lion(sex, feline);
        }else {
            Assert.assertThrows(Exception.class,() -> new Lion(sex, feline));
        }

    }

}
