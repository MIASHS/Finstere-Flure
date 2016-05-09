
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaby
 */
public class IA extends Joueurs {
    
    private Jeu game;

    public IA(Jeu g, String pseudo) {
       super(pseudo);
       game = g ;
    }
 
    public ArrayList<Cases> CoupPossibleIA(Plateau monPlateau, Joueurs j ){
        //monPlateau.getPlateau().remove(monPlateau.getCase(j.getTabPion().get(j.getPionUtilisé()).getX(),j.getTabPion().get(j.getPionUtilisé()).getY()));
        if(!j.getTabPion().get(j.getPionUtilisé()).isOnBoard()){
            j.getTabPion().get(j.getPionUtilisé()).setX(15);
            j.getTabPion().get(j.getPionUtilisé()).setY(-10);
            j.getTabPion().get(j.getPionUtilisé()).setOnBoard(true);
        }
        return j.getTabPion().get(j.getPionUtilisé()).searchCoupPossible(monPlateau, j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel()));
    }
    
    public Cases choisirCoupIA(ArrayList<Cases> cp,Jeu g){
        Cases cf=new Cases(0,0,false);
        int memoire=100;

        for(Cases c : cp){
            if(c.getAbscisse()-c.getOrdonnee()<memoire){
                memoire=(c.getAbscisse()-c.getOrdonnee());
                cf=c;
            }
        }
        this.getTabPion().get(this.getPionUtilisé()).deplacer(g.getMonPlateau(), cf);
        return cf;
    }
}
