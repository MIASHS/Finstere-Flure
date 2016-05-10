
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel, Sébastien, Valère 
 */

/*
    Cette classe permet la création et la gestion d'un conteneur de Carte.
    Cette classe a été reprise du TD 8 et adaptée pour ce projet.

*/
public class Paquet {
    // Attributs
    
    // Paquet de cartes par défaut du jeu
     private Cartes[] pioche = new Cartes[8];
     // Paquet de cartes mémoire du jeu
     private Cartes[] defausse = new Cartes[8];
     // nombre de carte de la défausse
     private int defausseNb=8;
     // nombre de carte actuellement dans la défausse
     private int nbActuel=0;
     // nombre de carte de la pioche
    private int nbCarte = 8;
    //numero de serie unique pour reconnaitre le jeu et eviter la triche.
    private int numeroSerie = 0;
    // si la carte est présente dans le paquet ou non
    private boolean present = false;

    /**
     * ********
     */
    /*Getters&Setters*/
    private void setPresent(boolean a) {
        this.present = a;
    }

    private boolean getPresent() {
        return present;
    }

    public int getNbCarte() {
        return this.nbCarte;
    }

    private void setNbCarte(int a) {
        this.nbCarte = a;
    }

    private int getNumeroSerie() {
        return this.numeroSerie;
    }

    private void setNumeroSerie(int a) {
        this.numeroSerie = a;
    }

    private void setCartep(Cartes carte, int a) {
        this.pioche[a] = carte;
    }

    public Cartes getCartep(int a) {
        return this.pioche[a];
    }
    private void setCarted(Cartes carte, int a) {
        this.defausse[a] = carte;
    }

    public Cartes getCarted(int a) {
        return this.defausse[a];
    }

    //Constructor
    public Paquet() {
        this.init();
        this.melanger(1000);
    }

    
    /**
     * **************
     */
    /**
     * **Méthode***
     */
    //Créer les cartes utilisées par le monstres  
    private void init() {
        Random ra = new Random();
        Map valeur=new HashMap();
        valeur.put(1, 5);//5 7 7 8 8 10
        valeur.put(2, 7);
        valeur.put(3, 7);
        valeur.put(4, 8);
        valeur.put(5, 8);
        valeur.put(6, 10);
        valeur.put(7, 11);
        valeur.put(8, 12);
        this.setNumeroSerie(ra.nextInt(2000));
        for (int i = 0; i < 8; i++) {
            int k=1+ra.nextInt(8);
            while((int) valeur.get(k) ==0){
                k=1+ra.nextInt(8);
            }
            this.setCartep(new Cartes((int) valeur.get(k),this.getNumeroSerie()), i);
            valeur.put(k, 0);
        }
        
    }
    // mélange de tas de carte de la pioche. 
    public void melanger(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                this.echanger();
            }
            if((pioche[0].getNumeroCarte()==11)||(pioche[0].getNumeroCarte()==12)){
                if((pioche[1].getNumeroCarte()!=11)&&(pioche[1].getNumeroCarte()!=12)){
                    Cartes carteMemoire;
                    carteMemoire = this.getCartep(0);
                    this.setCartep(this.getCartep(1), 0);
                    this.setCartep(carteMemoire, 1);
                }else{
                    Cartes carteMemoire;
                    carteMemoire = this.getCartep(0);
                    this.setCartep(this.getCartep(2), 0);
                    this.setCartep(carteMemoire, 2);
                }
            }
        } else {
            System.out.println("Erreur dans l'appel de la méthode melanger()");
        }
    }
    // principe de base du mélange des cartes
    private void echanger() {
        Random ra = new Random();
        int carte1 = ra.nextInt(8);
        int carte2 = ra.nextInt(8);
        Cartes carteMemoire;
        carteMemoire = this.getCartep(carte1);
        this.setCartep(this.getCartep(carte2), carte1);
        this.setCartep(carteMemoire, carte2);
    }
    //Donne une carte de la pioche et la met dans la défausse
    //Lorsqu'il n'y a plus de carte à donner on remet les cartes de défausse dans
    // la pioche. 
    public Cartes donnerUneCarte() {
        Cartes c;
        if (this.getNbCarte() <= 0) {
            
            for(Cartes c1:this.defausse){
                this.pioche[7-(nbActuel-1)]=c1;
                this.setNbCarte(this.getNbCarte() + 1);
                nbActuel-=1;
            }
            this.melanger(1000);
            
            return donnerUneCarte();
            
        } else {
            this.setNbCarte(this.getNbCarte() - 1);
            c = this.getCartep(0);
            for (int i = 1; i < this.getNbCarte(); i++) {
                this.setCartep(this.getCartep(i), i - 1);
            }
            
            this.defausse[nbActuel]=c;
            
            nbActuel+=1;
            
            return c;
        }
    }
    //inutile ici
    public void mettreCarteEnDessous(Cartes c) {

        if (c.isNumeroJeu(this.getNumeroSerie())) {
            for (int i = 0; i <= this.getNbCarte(); i++) {
                if (this.getCartep(i) == c) {
                    this.setPresent(true);
                }
            }
            if (!this.getPresent()) {
                this.setCartep(c, this.getNbCarte());
                this.setNbCarte(this.getNbCarte() + 1);
            }else{
                this.setPresent(false);
            }
        }
    }
}
