/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seb
 */
public class Temps {
    private int nbTours;
    private int nbToursJoueur;
    private boolean debuterTour;
    private boolean finirTour;

    public Temps(int nbTours, int nbToursJoueur, boolean debuterTour, boolean finirTour) {
        this.nbTours = nbTours;
        this.nbToursJoueur = nbToursJoueur;
        this.debuterTour = debuterTour;
        this.finirTour = finirTour;
    }
    
    
    public void debutGame(){
        this.nbTours =0;
        this.nbToursJoueur = 0;
    }
    
    public void gestionTour(Monstre m){
        
        while(debuterTour = true){
            this.finirTour = false;
            this.nbToursJoueur +=1;
            
        }if(this.debuterTour=false){
            this.finirTour= false;
            m.deplacer();
            
        }
    }
    
    

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }

    public int getNbToursJoueur() {
        return nbToursJoueur;
    }

    public void setNbToursJoueur(int nbToursJoueur) {
        this.nbToursJoueur = nbToursJoueur;
    }

    public boolean isDebuterTout() {
        return debuterTour;
    }

    public void setDebuterTout(boolean debuterTour) {
        this.debuterTour = debuterTour;
    }

    public boolean isFinirTour() {
        return finirTour;
    }

    public void setFinirTour(boolean finirTour) {
        this.finirTour = finirTour;
    }
    
    
   
        
    
}
