
import java.util.ArrayList;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oneiroi
 */
public class Menu {

    public Jeu getPartieActuelle() {
        return partieActuelle;
    }

    public void setPartieActuelle(Jeu partieActuelle) {
        this.partieActuelle = partieActuelle;
    }

    public Menu getMenuActuel() {
        return menuActuel;
    }

    public void setMenuActuel(Menu menuActuel) {
        this.menuActuel = menuActuel;
    }

    private Jeu partieActuelle; //Variable memoire pour conserver   le jeu 
    private Menu menuActuel; //Variable memoire pour conserver le menu  
    private Scanner sc = new Scanner(System.in);

    /**
     * ************Fonctions du menu de démarrage*******************
     */
    public void demarrer() {
        if (partieActuelle != null) {
            Outils.afficherTexte("Un jeu est déja lancé. Souhaitez vous recommencer ?");
            this.menuNiveauZero(Outils.conversionCaractere(Outils.afficher(0, partieActuelle)));
        } else {
            partieActuelle = new Jeu();
            partieActuelle.init(new Plateau());
            //this.menuNiveauZero(Outils.conversionCaractere(Outils.afficher(0,partieActuelle)));
        }

    }

    // Méthode qui permet de quitter le jeu
    public static void quitter() {
        //On quitte le jeu
        System.exit(0);
    }

    // permet d'appeler la méthode qui initialisera la partie
    public void outilInitPartie(Jeu partie) {
        //A compléter
    }

    //Méthode appelé quand le joueur se trouve dans le menu de niveau zero : C'est le menu de démarrage ou le joueur peut démarrer une partie  en quitter une ou continuer.
    public void menuNiveauZero(char choix) {
        switch (choix) {
            case 'Q':
                this.quitter();
                break;
            case 'D':   //this.getPartieActuelle().lancerJeu();
                this.demarrer();
                break;

            case 'S':
                this.menuNiveauUn(Outils.conversionCaractere(Outils.afficher(1, partieActuelle)));
                break;

        }
    }

    //C'est le menu disponible après le menu principal
    public void menuNiveauUn(char choix) {
        switch (choix) {
            case 'S':  // A compléter : permet de Sélectionner un pion

            case 'R':
                this.menuNiveauZero(Outils.conversionCaractere(Outils.afficher(0, partieActuelle)));
                break;

            case 'H':   // méthode à appeller pour afficher les scores
                Outils.afficherTexte("pas encore implémenté !");
                this.menuNiveauZero(Outils.conversionCaractere(Outils.afficher(0, partieActuelle)));
                break;
                
             case 'C':   // méthode à appeller pour afficher les scores
                Outils.afficherTexte("pas encore implémenté !");
                this.menuNiveauZero(Outils.conversionCaractere(Outils.afficher(0, partieActuelle)));
                break;
                 
             case 'O':
                this.menuNiveauDeux(Outils.conversionCaractere(Outils.afficher(2, partieActuelle)));
                break;

            case 'Q':
                this.quitter();
                break;
        }
    }
    
    public void menuNiveauDeux(char choix) {
        switch (choix) {
            
            case 'A':   // méthode à appeller pour afficher les scores
                Outils.afficherTexte("Configuration IA pas encore implémenté ! `\n");
                this.menuNiveauZero(Outils.conversionCaractere(Outils.afficher(0, partieActuelle)));
                break;
                
            case 'I':   // méthode à appeller pour afficher les scores
                Outils.afficherTexte("Configuration Interface  pas encore implémenté ! `\n");
                this.menuNiveauZero(Outils.conversionCaractere(Outils.afficher(0, partieActuelle)));
                break;
                
             case 'R':
                this.menuNiveauUn(Outils.conversionCaractere(Outils.afficher(0, partieActuelle)));
                break;
        }
    }
}
