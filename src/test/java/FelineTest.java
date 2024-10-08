import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline = new Feline();

    @Test
    public void eatMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of());
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(1);
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(Mockito.anyInt());
    }

    @Test
    public void getKittensWithIntArg() {
        Random random = new Random();
        int randKitten = random.nextInt();
        int kittensCount = feline.getKittens(randKitten);
        Assert.assertEquals(randKitten, kittensCount);
    }

}
