
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Joueurs {
    private String pseudo ;

    private ArrayList<PionJoueur> tabPion=new ArrayList<>()  ;
    private boolean gagner=false ;
    private int pionTotal=4;
    private int pionUtilisé=0;
    private boolean finirTour=false;


    public Joueurs(String pseudo, ArrayList<PionJoueur> tabPion, boolean gagner, int pionTotal, int pionUtilisé) {
        this.pseudo = pseudo;
        this.tabPion = tabPion;
        this.gagner = gagner;
        this.pionTotal = pionTotal;
        this.pionUtilisé = pionUtilisé;
    }
    public Joueurs(String pseudo){
        this.pseudo = pseudo;
    }
    
    public boolean isFinirTour(){
        return finirTour;
    } 
    
    public void setFinirTour(boolean b){
        finirTour=b;
    }

    public void ajouterPion(PionJoueur p){
        this.tabPion.add(p);
    }    
   // ***** GETTERS & SETTERS   ***** /*

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ArrayList<PionJoueur> getTabPion() {
        return tabPion;
    }

    public void setTabPion(ArrayList<PionJoueur> tabPion) {
        this.tabPion = tabPion;
    }

    public boolean isGagner() {
        return gagner;
    }

    public void setGagner(boolean gagner) {
        this.gagner = gagner;
    }

    public int getPionTotal() {
        return pionTotal;
    }

    public void setPionTotal(int pionTotal) {
        this.pionTotal = pionTotal;
    }

    public int getPionUtilisé() {
        return pionUtilisé;
    }

    public void setPionUtilisé(int pionUtilisé) {
        this.pionUtilisé = pionUtilisé;
    }
        
    

}
