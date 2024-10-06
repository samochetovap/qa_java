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
                {"Не существующий пол"},
        };
    }

    public LionParameterizedTest(String sex) {
        this.sex = sex;
    }

    @Test
    public void doesHaveMane() {
        try {
            Lion lion = new Lion(sex, feline);
            if ("Самец".equals(sex)) {
                Assert.assertTrue(lion.doesHaveMane());
            } else if ("Самка".equals(sex)) {
                Assert.assertFalse(lion.doesHaveMane());
            }
        } catch (Exception e) {
            Assert.fail("Объект не создался с sex = " + sex);
        }
    }
}
