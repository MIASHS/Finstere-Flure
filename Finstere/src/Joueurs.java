
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
    private ArrayList <Pions> tabPion  ;
    private boolean gagner ;
    private int pionUtilisé;

    public Joueurs(String pseudo, ArrayList<Pions> tabPion, boolean gagner, int pionUtilisé) {
        this.pseudo = pseudo;
        this.tabPion = tabPion;
        this.gagner = gagner;
        this.pionUtilisé = pionUtilisé;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ArrayList<Pions> getTabPion() {
        return tabPion;
    }

    public void setTabPion(ArrayList<Pions> tabPion) {
        this.tabPion = tabPion;
    }

    public boolean isGagner() {
        return gagner;
    }

    public void setGagner(boolean gagner) {
        this.gagner = gagner;
    }
    
    public int getpionUtilisé(){
        return pionUtilisé;
    }
    
    public void setpionUtilisé(int pionUtilisé){
        this.pionUtilisé= pionUtilisé;
    }
}
