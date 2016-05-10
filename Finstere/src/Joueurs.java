
import java.util.ArrayList;

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
        Cette classe permet la création et la gestion d'un joueur individuellement
*/
public class Joueurs {
    //Attribut
    //nom du joueur
    private String pseudo ;
    //les pions qu'il possède
    private ArrayList<PionJoueur> tabPion=new ArrayList<>()  ;
    //s'il a gagné ou non
    private boolean gagner=false ;
    // le nombre de pion qu'il possède
    private int pionTotal=4;
    // le numéro du pion utilisé et le nombre de pion utilisé dans le tour
    private int pionUtilisé=0;
    // savoir si il a fini le tour ou non 
    private boolean finirTour=false;

    // Constructors
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
   
   // ***** GETTERS & SETTERS   ***** /*
 
    public boolean isFinirTour(){
        return finirTour;
    } 
    
    public void setFinirTour(boolean b){
        finirTour=b;
    }

    public void ajouterPion(PionJoueur p){
        this.tabPion.add(p);
    }    
    
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
