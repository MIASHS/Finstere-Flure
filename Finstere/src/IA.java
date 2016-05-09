
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel, Valère, Sébastien
 */

/*
        Cette classe permet de gérer l'IA du joueur du.
*/
public class IA extends Joueurs {
    //Attributs 
    private Jeu game;
    //Constructors 
    public IA(Jeu g, String pseudo) {
       super(pseudo);
       game = g ;
    }
    //Methods
    public ArrayList<Cases> CoupPossibleIA(Plateau monPlateau, Joueurs j ){
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
