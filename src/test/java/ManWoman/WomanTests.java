package ManWoman;

import com.bobak.people.Man;
import com.bobak.people.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WomanTests {

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

    @Test
    public void testRegisterPartnership(){
        woman.registerPartnership(man);

        Assert.assertEquals(woman.getPartner(), man);
        Assert.assertEquals(woman.getLastName(), man.getLastName());
    }

    @Test
    public void testDeregisterPartnership_ReturnToPreviousLastName(){
        woman.registerPartnership(man);

        Assert.assertEquals(woman.getLastName(), man.getLastName());

        woman.deregisterPartnership(true);

        Assert.assertNull(woman.getPartner());
        Assert.assertNull(man.getPartner());
        Assert.assertEquals(woman.getLastName(), "Langmore");
    }

    @Test
    public void testDeregisterPartnership_DoNotReturnToPreviousLastName(){
        woman.registerPartnership(man);

        Assert.assertEquals(woman.getLastName(), man.getLastName());

        woman.deregisterPartnership(false);

        Assert.assertNull(woman.getPartner());
        Assert.assertNull(man.getPartner());
        Assert.assertEquals(woman.getLastName(), "Brooks");

    }

}
