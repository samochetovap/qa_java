import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Random rand = new Random();
        Mockito.when(feline.getKittens()).thenReturn(rand.nextInt());
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Mockito.any());
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

}
