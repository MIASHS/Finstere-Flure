/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oneiroi
 */
public class Cartes {
    
    private int numeroCarte;
    private int numeroCouleur;
    private String[] couleurCarte = {"pique", "trefle", "carreau", "coeur"};
    private int numeroJeu;
    //Méthodes

    public int getNumeroCarte() {
        return this.numeroCarte;
    }
    
    private void setNumeroCarte(int a) {
        this.numeroCarte = a;
    }
    
    public boolean isNumeroJeu(int a) {
        if(a==this.getNumeroJeu()){
            return true;
        }else{
            return false;    
        }
    }
    
    private int getNumeroJeu(){
        return this.numeroJeu;
    }
    
    private void setNumeroJeu(int a) {
        this.numeroJeu = a;
    }
    
    private void setCouleurCarte(int a) {
        this.numeroCouleur = a;
    }

    public String getCouleurCarte() {
        return this.couleurCarte[this.getNumeroCouleur()];
    }

    public int getNumeroCouleur(){
        return this.numeroCouleur;
    }

    public String toTete(int valeurTete) {
        
        switch (valeurTete) {
            case 1:
                return "As" ;
            case 11:
                return "Valet" ;
            case 12:
                return "Dame" ;
            case 13:
                return "Roi" ;
        }
        return null;
    }

    public Cartes(int numeroInit, int couleurInit) {
        this.setCouleurCarte(couleurInit);
        this.setNumeroCarte(numeroInit);
    }
    
    
    public Cartes(int numeroInit, int couleurInit, int numeroJeu) {
        this.setCouleurCarte(couleurInit);
        this.setNumeroCarte(numeroInit);
        this.setNumeroJeu(numeroJeu);
    }
    

    public String toString() {

        String resultat;
        if (this.getNumeroCarte() == 1 || this.getNumeroCarte() > 10) {
            resultat = "" + this.toTete(this.getNumeroCarte()) + " de " + this.getCouleurCarte();
        } else {
            resultat = "" + this.getNumeroCarte() + " de " + this.getCouleurCarte();
        }
        
        return resultat;
    }
    public String getFileName(){
    return this.numeroCarte+this.couleurCarte[this.numeroCouleur]+".jpg";
    }
}
