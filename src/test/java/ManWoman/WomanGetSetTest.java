package ManWoman;

import com.bobak.people.Man;
import com.bobak.people.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WomanGetSetTest {
    private Woman woman;
    private Man man;

    @BeforeMethod
    public void setUp() {
        woman = new Woman("Jessica", "Langmore", 35);
        man = new Man("Stan", "Brooks", 69);
    }

    @Test
    public void testGetPartner(){
        Assert.assertNull(woman.getPartner());

        woman.registerPartnership(man);

        Assert.assertEquals(woman.getPartner(), man);

        woman.deregisterPartnership(false);

        Assert.assertNull(woman.getPartner());
    }

    @Test
    public void testSetPartner(){
        Man manJack = new Man("Jack", "Jones", 45);

        Assert.assertNull(woman.getPartner());

        woman.setPartner(man);

        Assert.assertEquals(woman.getPartner(), man);

        woman.setPartner(manJack);

        Assert.assertEquals(woman.getPartner(), manJack);
        Assert.assertNull(man.getPartner());
    }
}
