
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oneiroi
 */
public class Paquet {
     private Cartes[] sabot = new Cartes[52];
    private int nbCarte = 52;
    private int numeroSerie = 0;
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

    private void setCarte(Cartes carte, int a) {
        this.sabot[a] = carte;
    }

    public Cartes getCarte(int a) {
        return this.sabot[a];
    }

    /**
     * **************
     */
    /**
     * **Méthode***
     */
    public Paquet() {
        this.init();
        this.melanger(1000);
    }

    private void init() {
        int compteur = 0;
        Random ra = new Random();
        this.setNumeroSerie(ra.nextInt(2000));
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                this.setCarte(new Cartes(j, i, this.getNumeroSerie()), compteur);
                compteur++;
            }
        }
    }

    public void melanger(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                this.echanger();
            }
        } else {
            System.out.println("Erreur dans l'appel de la méthode melanger()");
        }
    }

    private void echanger() {
        Random ra = new Random();
        int carte1 = ra.nextInt(51);
        int carte2 = ra.nextInt(51);
        Cartes carteMemoire;
        carteMemoire = this.getCarte(carte1);
        this.setCarte(this.getCarte(carte2), carte1);
        this.setCarte(carteMemoire, carte2);
    }

    public Cartes donnerUneCarte() {
        Cartes c;
        if (this.getNbCarte() <= 0) {
            System.out.println("Il n'y a plus de carte à distribuer");
            return null;
        } else {
            this.setNbCarte(this.getNbCarte() - 1);
            c = this.getCarte(0);
            for (int i = 1; i < 52; i++) {
                this.setCarte(this.getCarte(i), i - 1);
            }
            //this.mettreCarteEnDessous(c);
            return c;
        }
    }

    public void mettreCarteEnDessous(Cartes c) {

        if (c.isNumeroJeu(this.getNumeroSerie())) {
            for (int i = 0; i <= this.getNbCarte(); i++) {
                if (this.getCarte(i) == c) {
                    this.setPresent(true);
                }
            }
            if (!this.getPresent()) {
                this.setCarte(c, 51);
                this.setNbCarte(this.getNbCarte() + 1);
            }
        }
    }

    public int comparer(Cartes carte1, Cartes carte2) {
        int resultat;
        
            if (carte1.getNumeroCarte() == carte2.getNumeroCarte()) {
                resultat = 0;
            } else if (carte2.getNumeroCarte() == 1) {
                resultat = -1;
            } else if(carte1.getNumeroCarte() == 1) {
                resultat = 1;
            } else if (carte1.getNumeroCarte() < carte2.getNumeroCarte()) {
                resultat = -1;
            } else {
                resultat = 1;
            }
            return resultat;
    }
}
