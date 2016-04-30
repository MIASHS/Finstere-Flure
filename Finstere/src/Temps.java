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
    
    // méthode de debut de jeu
    public void debutGame(){
        this.nbTours = 0;
        this.nbToursJoueur = 0;
    }
    
    // méthode de gestion des tours
    public void gestionTourGros(Monstre m, Joueurs j, Jeu g){
        
        while(debuterTour = true){
            while(g.getJ_list().get(0).getPionUtilisé()== g.getJ_list().get(0).getPionTotal()&& g.getJ_list().get(1).getPionUtilisé()== g.getJ_list().get(1).getPionTotal()){
            for(int i=0; i < g.getJ_list().size(); i++){
               this.gestionTourPetit(g.getJ_list().get(i));
               g.getJ_list().get(i).setPionUtilisé(g.getJ_list().get(i).getPionUtilisé()+1);
                if(g.getJ_list().get(i).getPionUtilisé()== g.getJ_list().get(i).getPionTotal()){    
                    this.finirTour = true;
                    this.debuterTour= false;
                }
                i+=1;
                this.nbToursJoueur +=1;
            }
        this.nbTours +=1;
    }
    }
        m.deplacer();
    }
    
    public void gestionTourPetit(Joueurs j){
        
        while(debuterTour = true){
            this.finirTour=false;
            this.nbToursJoueur +=1;
        }if (debuterTour = false && j.getPionUtilisé()!= j.getPionTotal()){
            this.finirTour=true;
            
                 
        }
        this.nbTours+=1;
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
