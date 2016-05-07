
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
 * @author oneiroi
 */
public class Paquet {
     private Cartes[] sabot = new Cartes[8];
    private int nbCarte = 8;
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
        Random ra = new Random();
        Map valeur=new HashMap();
        valeur.put(1, 5);
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
            System.out.println("k :"+k);
            while((int) valeur.get(k) ==0){
                k=1+ra.nextInt(8);
            }
            this.setCarte(new Cartes((int) valeur.get(k),this.getNumeroSerie()), i);
            valeur.put(k, 0);
        }
        
    }

    public void melanger(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                this.echanger();
            }
            if((sabot[0].getNumeroCarte()==11)||(sabot[0].getNumeroCarte()==12)){
                if((sabot[1].getNumeroCarte()!=11)&&(sabot[1].getNumeroCarte()!=12)){
                    Cartes carteMemoire;
                    carteMemoire = this.getCarte(0);
                    this.setCarte(this.getCarte(1), 0);
                    this.setCarte(carteMemoire, 1);
                }else{
                    Cartes carteMemoire;
                    carteMemoire = this.getCarte(0);
                    this.setCarte(this.getCarte(2), 0);
                    this.setCarte(carteMemoire, 2);
                }
            }
        } else {
            System.out.println("Erreur dans l'appel de la méthode melanger()");
        }
    }

    private void echanger() {
        Random ra = new Random();
        int carte1 = ra.nextInt(8);
        int carte2 = ra.nextInt(8);
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
            for (int i = 1; i < this.getNbCarte(); i++) {
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
                this.setCarte(c, this.getNbCarte());
                this.setNbCarte(this.getNbCarte() + 1);
            }else{
                this.setPresent(false);
            }
        }
    }
}
