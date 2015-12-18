import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Darkbattor on 14/11/2015.
 */
public class CartesPlateauUnitTest {

    @Test
    public void testCartesPlateau() {

    }

    @Test
    public void testGetCarte() {
        Carte carte = new Carte("choucroute", 1800);
        Carte carte1 = new Carte("raclette", 1900);
        CartesPlateau cplateau = new CartesPlateau();
        cplateau.ajouterCarte(carte);
        cplateau.ajouterCarte(carte1, 1);

        Assert.assertEquals(cplateau.getCarte(0), carte);
        Assert.assertEquals(cplateau.getCarte(1), carte1);
    }

    @Test
    public void testVerifierChronologie() {
        Carte carte = new Carte("choucroute", 1800);
        Carte carte1 = new Carte("raclette", 1900);
        Carte carte2 = new Carte("polenta", 2000);
        CartesPlateau cplateau = new CartesPlateau();

        cplateau.ajouterCarte(carte);cplateau.ajouterCarte(carte1);
        cplateau.ajouterCarte(carte2);

        Assert.assertTrue(cplateau.verifierChronologie());

        cplateau.ajouterCarte(carte);

        Assert.assertFalse(cplateau.verifierChronologie());
    }

    @Test
    public void testCompareDate() {
        Carte carte = new Carte("choucroute", 1800);
        Carte carte1 = new Carte("raclette", 1900);
        Carte carte2 = new Carte("polenta", 2000);
        CartesPlateau cplateau = new CartesPlateau();

        cplateau.ajouterCarte(carte);cplateau.ajouterCarte(carte1);
        cplateau.ajouterCarte(carte2);

        Assert.assertTrue(cplateau.compareDate(carte2, 2));
    }
}
