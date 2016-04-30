/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seb
 */
public class TestConsole {

    public static void test() {
        testInit();

    }

    //Test initialisation du jeu
    public static void testInit() {
        
        Menu m = new Menu();
        m.demarrer();

        //Test du plateau de jeu
        testPlateau(m.getPartieActuelle().getMonPlateau());
    }

    public static void testPlateau(Plateau p) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j > -11; j--) {
                if (p.getCase(i,j).getPioncase() == null) {
                    Outils.afficherTexte("[  ]");
                } else {
                    
                    switch (p.getCase(i, j).getPioncase().getClass().getName()) {
                        case "Pierre":
                            Outils.afficherTexte("[ P ]");
                            break;
                        case "Flaque":
                            Outils.afficherTexte("[ F ]");
                            break;
                        case "Monstre":
                            Outils.afficherTexte("[ M ]");
                            break;
                        case "PionJoueur":
                            Outils.afficherTexte("[ J ]");
                            break;
                        default:
                            Outils.afficherTexte("[ B ]");
                            break;
                    }
                }
            }
            Outils.afficherTexte("\n");
        }
    }
}
