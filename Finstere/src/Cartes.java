/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valère, Gabriel, Sébastien
 */

/*
        Cette classe permet la création et l'utilisation de carte individuellement
        Les Cartes sont ce qui indique aux monstres que faire.
        Il n'y a rien d'autre à savoir cette classe, elle a été récupérée du TD8
        du cours de Java et adapter pour l'occasion.
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
                return "X" ; // le monstre doit tuer un pion
            case 12:
                return "XX" ; // le monstre doit tuer deux pions.
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
