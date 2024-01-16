import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class catKataTests {
    @Test
    public void BasicTests() {
        System.out.println("Only one cat is in the yard");
        assertEquals(true, catKata.isPeaceful(new String[] {"------------", "------------", "-L----------", "------------", "------------", "------------"}, 10));
        System.out.println("There are two cats in the yard, and they are closer than the minimum distance");
        assertEquals(false, catKata.isPeaceful(new String[] {"------------", "---M--------", "------------", "------------", "-------R----", "------------"}, 6));
        System.out.println("All three cats are in the yard, all further apart than or equal to the minimum distance");
        assertEquals(true, catKata.isPeaceful(new String[] {"-----------L", "--R---------", "------------", "------------", "------------", "--M---------"}, 4));
    }
}
