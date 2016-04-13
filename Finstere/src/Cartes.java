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
    //Attributs

    private int numeroCarte;
    private int numeroJeu;
   
    //Getter Setter
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
    
     //Méthodes
    public String toTuile(int valeurTuile) {
        
        switch (valeurTuile) {
            case 11:
                return "X" ;
            case 12:
                return "XX" ;
        }
        return null;
    }
    
    //Constructor
    
    public Cartes(int numeroInit) {
        this.setNumeroCarte(numeroInit);
    }
    public Cartes(int numeroInit, int numeroJeu) {
        this.setNumeroCarte(numeroInit);
        this.setNumeroJeu(numeroJeu);
    }
}
