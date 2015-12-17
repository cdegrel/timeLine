import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Darkbattor on 17/12/2015.
 */
public class carteUnitTest {

    @Test
    public void testCarte() {
        Carte carte = new Carte("choucroute", 1800);
        Assert.assertEquals(carte.getDate(), 1800);
        Assert.assertEquals(carte.getNom(), "choucroute");
    }

    @Test
    public void testRetourner() {
        Carte carte = new Carte("choucroute", 1800);

        Assert.assertFalse(carte.getRetourner());
        carte.retourner();
        Assert.assertTrue(carte.getRetourner());
        carte.recacher();
        Assert.assertFalse(carte.getRetourner());
    }
}
