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
                {"Не существующий пол"},
                {"Самец"},
                {"Самка"},
                {"Еще один не существующий пол"},
        };
    }

    public LionParameterizedTest(String sex) {
        this.sex = sex;
    }

    @Test
    public void doesHaveMane(){
        try{
            Lion lion = new Lion(sex, feline);
            if ("Самец".equals(sex)) {
                Assert.assertTrue(lion.doesHaveMane());
            } else if ("Самка".equals(sex)) {
                Assert.assertFalse(lion.doesHaveMane());
            }
        }catch(Exception e){
            Assert.assertThrows("При создание конструктора с sex = " + sex + " возникла ошибка. ", Exception.class, () -> {
                System.out.println(e.getMessage());
            });
        }

    }
}
