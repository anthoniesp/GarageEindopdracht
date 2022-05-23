import com.example.garageeindopdracht.Models.Part;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartTest {

    @Test
    public void getPartNameTest() {
        Part part = new Part("Bougie", "25,00");
        part.setPartName("Bougie");
        assertEquals("Bougie", part.getPartName());
    }

    @Test
    public void getPartPriceTest() {
        Part part = new Part("Bougie", "25,00");
        part.setPartPrice("25,00");
        assertEquals("25,00", part.getPartPrice());
    }
}
