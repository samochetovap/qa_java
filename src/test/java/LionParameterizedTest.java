import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
        }else {
            Assert.assertThrows("Исключение не пробросилось на конструктор с не ожидаемым sex", Exception.class, () -> new Lion(sex, feline));
        }
    }
}
