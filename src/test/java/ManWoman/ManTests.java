package ManWoman;

import com.bobak.people.Man;
import com.bobak.people.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManTests {

    private Man man;
    private Woman woman;

    @BeforeMethod
    public void setUp() {
        man = new Man("John", "Smith", 23);
        woman = new Woman("Lily", "Brown", 25);
    }

    @Test
    public void testGetPartner(){
        Assert.assertNull(man.getPartner());

        man.registerPartnership(woman);

        Assert.assertEquals(man.getPartner(), woman);

        man.deregisterPartnership(false);

        Assert.assertNull(man.getPartner());
    }

    @Test
    public void testSetPartner(){
        Woman womanSarah = new Woman("Sarah", "Johnson", 21);

        Assert.assertNull(man.getPartner());

        man.setPartner(woman);

        Assert.assertEquals(man.getPartner(), woman);

        man.setPartner(womanSarah);

        Assert.assertEquals(man.getPartner(), womanSarah);
        Assert.assertNull(woman.getPartner());
    }

    @Test
    public void testRegisterPartnership(){
        man.registerPartnership(woman);

        Assert.assertEquals(man.getPartner(), woman);
        Assert.assertEquals(man.getLastName(), woman.getLastName());
    }

    @Test
    public void testDeregisterPartnership_ReturnToPreviousLastName(){
        man.registerPartnership(woman);
        Assert.assertEquals(woman.getLastName(), man.getLastName());

        man.deregisterPartnership(true);

        Assert.assertNull(man.getPartner());
        Assert.assertNull(woman.getPartner());
        Assert.assertEquals(woman.getLastName(), "Brown");
    }

    @Test
    public void testDeregisterPartnership_DoNotReturnToPreviousLastName(){
        man.registerPartnership(woman);
        Assert.assertEquals(woman.getLastName(), man.getLastName());

        man.deregisterPartnership(false);

        Assert.assertNull(man.getPartner());
        Assert.assertNull(woman.getPartner());
        Assert.assertEquals(woman.getLastName(), "Smith");
    }

}
