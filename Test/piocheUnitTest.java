import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Darkbattor on 09/11/2015.
 */
public class piocheUnitTest {

    @Test
    public void testPioche() {

    }

    @Test
    public void testTirerUneCarte() {
        Pioche pioche = new Pioche();
        Carte carte = new Carte("choucroute", 1800);
        pioche.ajouterUneCarte(carte);

        Assert.assertEquals(pioche.tirerUneCarte(), carte);
    }
}
