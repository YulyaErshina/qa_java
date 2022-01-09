import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(6);
        int actual = lion.getKittens();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void doesHaveManeException() throws Exception {
        Lion lion = new Lion("Чужой", feline);
        lion.doesHaveMane();
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Мясо", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Мясо", "Рыба");
        assertEquals(expected, actual);
    }

}
