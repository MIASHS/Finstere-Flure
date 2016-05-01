
import java.util.ArrayList;
import java.util.Scanner;

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
    public ArrayList<Cases> gestionTourGros(Monstre m,Jeu g){
        debuterTour=true;
        
        while(debuterTour){
            while(g.getJ_list().get(0).getPionUtilisé()!= g.getJ_list().get(0).getPionTotal()||g.getJ_list().get(1).getPionUtilisé()!= g.getJ_list().get(1).getPionTotal()){
                for(int i=0; i < g.getJ_list().size(); i++){
                    this.gestionTourPetit(g.getJ_list().get(i),g);
                    if(!g.getJ_list().get(i).isFinirTour()){
                        g.getJ_list().get(i).setPionUtilisé(g.getJ_list().get(i).getPionUtilisé()+1);
                    }
                    
                    if(g.getJ_list().get(i).getPionUtilisé()== g.getJ_list().get(i).getPionTotal()){    
                        g.getJ_list().get(i).setFinirTour(true);
                    }
                    this.nbToursJoueur +=1;
                }
        
            }
            this.debuterTour= false;
            this.nbTours +=1;
        }
        m.deplacer(m.getListeCarte().donnerUneCarte());
        return m.getChemin();
    }
    
    public void gestionTourPetit(Joueurs j,Jeu p){
        boolean arret=false;// condition d'arret si le joueur veut s'arreter... hum où l'appliquée ?? 
        boolean deplacement=false;
        while(!deplacement&&(arret||j.getPionUtilisé()==j.getPionTotal())){
            
            
            //Outils.afficherTexte((j.getTabPion().get(j.getPionUtilisé()).searchCoupPossible(p.getMonPlateau(), j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel()))).toString());
            Outils.afficherTexte("Sur quelle cases souhaitez vous vous déplacer ?(Vous pouvez vous déplacer sur "+j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel())+" cases  )");
            Outils.afficherTexte("Abscisse ?");
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            Outils.afficherTexte("Ordonnée ?");
            int o=sc.nextInt();
            boolean b=false;
            ArrayList<Cases> c=j.getTabPion().get(j.getPionUtilisé()).searchCoupPossible(p.getMonPlateau(), j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel()));
            for(int i=0; i<c.size();i++){
                if(c.get(i).getAbscisse()==a&&c.get(i).getOrdonnee()==o){
                    b=true;
                }
            }
            if(b){
                j.getTabPion().get(j.getPionUtilisé()).deplacer(p.getMonPlateau(),p.getMonPlateau().getCase(a, o));
                deplacement=true;
            }else{
                Outils.afficherTexte("Déplacement impossible");
            }
        
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
