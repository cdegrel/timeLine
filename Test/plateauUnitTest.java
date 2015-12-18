import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Darkbattor on 14/11/2015.
 */
public class plateauUnitTest {

    @Test
    public void testAjouterUneCarte() {
        Plateau plateau = new Plateau();
        Carte carte = new Carte("choucroute", 1900);
        Carte carte1 = new Carte("raclette", 2000);

        plateau.ajouterUneCarte(carte);
        plateau.ajouterUneCarte(carte1);

        Assert.assertTrue(plateau.verifierChronologie());

        plateau.ajouterUneCarte(carte);

        Assert.assertTrue(plateau.verifierChronologie());
    }

    @Test
    public void testSelectionnerJoueur() {
        Plateau plateau = new Plateau();
        plateau.setNbJoueurs(3);

        Assert.assertEquals(plateau.getNbJoueurs(), 3);

        Assert.assertEquals(plateau.getTourJoueur(), 1);
        plateau.selectionnerJoueur();
        Assert.assertEquals(plateau.getTourJoueur(), 2);
        plateau.selectionnerJoueur();
        plateau.selectionnerJoueur();
        Assert.assertEquals(plateau.getTourJoueur(), 1);
    }
}
