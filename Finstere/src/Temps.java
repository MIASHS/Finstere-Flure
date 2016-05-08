
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
    private int nbTours; // indique le nombre de tour
    private int numManche=1;
    private int nbToursJoueur; // indique ? ce serait bien de sans servir pour le nombre de coup joué par pions 
    private boolean debuterTour; // variable pour bloquer la bloquer de deplacement des pionjoueur
    private boolean finirTour; // variable pour sortir en temps que joueur de la petite boucle

    public Temps(int nbTours, int nbToursJoueur, boolean debuterTour, boolean finirTour) {
        this.nbTours = nbTours;
        this.nbToursJoueur = nbToursJoueur;
        this.debuterTour = debuterTour;
        this.finirTour = finirTour;
    }
    
    // méthode de debut de jeu, initialisation non nécessaire
    public void debutGame(){
        this.nbTours = 0;
        this.nbToursJoueur = 0;
    }
    
    // méthode de gestion des tours, il s'agit là d'un seul tour 
    // les joueurs bougent leurs pions chacun leur tour puis le monstre bouge
    // le chemin emprunté par le monstre est retourné
    public ArrayList<Cases> gestionTourGros(Monstre m,Jeu g){
        debuterTour=true;
        boolean b=false;
        g.getJ_list().get(0).setPionUtilisé(0);
        g.getJ_list().get(1).setPionUtilisé(0);
        //TestConsole.testPlateau(g.getMonPlateau());
        while(debuterTour){
            while((g.getJ_list().get(0).getPionUtilisé()!= g.getJ_list().get(0).getPionTotal()||g.getJ_list().get(1).getPionUtilisé()!= g.getJ_list().get(1).getPionTotal())&&!b){
                for(int i=0; i < g.getJ_list().size(); i++){
                    TestConsole.testPlateau(g.getMonPlateau());
                    this.gestionTourPetit(g.getJ_list().get(i),g);
                    if(!g.getJ_list().get(i).isFinirTour()){
                        g.getJ_list().get(i).setPionUtilisé(g.getJ_list().get(i).getPionUtilisé()+1);
                    }
                    
                    if(g.getJ_list().get(i).getPionUtilisé()== g.getJ_list().get(i).getPionTotal()){    
                        g.getJ_list().get(i).setFinirTour(true);
                    }
                    this.nbToursJoueur +=1;
                }
                for(Joueurs j: g.getJ_list()){
                    if(j.isGagner()){
                        b=true;
                    }
                }
            }
            this.debuterTour= false;
            this.nbTours +=1;
        }
        for(Joueurs j: g.getJ_list()){
            j.setFinirTour(false);
        }
        m.deplacer(m.getListeCarte().donnerUneCarte());
        if(m.getListeCarte().getNbCarte()==1){
            this.numManche=2;
        }
        return m.getChemin();
    }
    
    // méthode de gestion des joueurs, chacun leurs tours les joueurs bougent leurs pions
    // ici on permet au joueur de bouger un pion
    public void gestionTourPetit(Joueurs j,Jeu p){
        boolean arret=false;// condition d'arret si le joueur veut s'arreter... hum où l'appliquée ?? 
        boolean deplacement=false; // indique si le déplacement a été effectue
        Scanner sc=new Scanner(System.in);
        
        this.nbToursJoueur=0; // Indique le nombre de déplacement utilisé
        if(!j.getTabPion().get(j.getPionUtilisé()).isOnBoard()&&j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel())!=1){
            this.nbToursJoueur+=1;
            }else if(j.getTabPion().get(j.getPionUtilisé()).isOnBoard()){
                p.getMonPlateau().getPlateau().remove(p.getMonPlateau().getCase(j.getTabPion().get(j.getPionUtilisé()).getX(),j.getTabPion().get(j.getPionUtilisé()).getY()));
            }
        
        while((!deplacement||!arret)&&this.nbToursJoueur<j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel())){
            //TEST///////
            //System.out.println("nbTourJoueur :"+this.nbToursJoueur+" et n ="+j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel()));
                //System.out.println("("+j.getTabPion().get(j.getPionUtilisé()).getX()+";"+j.getTabPion().get(j.getPionUtilisé()).getY()+")");
                //TestConsole.testPlateau(p.getMonPlateau());
                if(this.nbToursJoueur<j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel())&&this.nbToursJoueur>1){
                    Outils.afficherTexte("Souhaitez vous vous arrêter ici ?");
                    if(Outils.conversionBoolean(Outils.verification(sc.next(), 1))){
                        arret=true;
                    }else{
                        System.out.println("["+j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel())+"J"+j.getTabPion().get(j.getPionUtilisé()).getNumjoueur()+"] Case actuelle ("+j.getTabPion().get(j.getPionUtilisé()).getX()+";"+j.getTabPion().get(j.getPionUtilisé()).getY()+")");
                        Outils.afficherTexte("Sur quelle cases souhaitez vous vous déplacer ?(Vous pouvez vous déplacer sur "+(j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel())-this.nbToursJoueur)+" cases  )");
                        Outils.afficherTexte("Abscisse ?");
                        int a=Outils.convertToInt(sc.next());
                        Outils.afficherTexte("Ordonnée ?");
                        int o=Outils.convertToInt(sc.next());
                        boolean b=false;
                        ArrayList<Cases> c=j.getTabPion().get(j.getPionUtilisé()).searchCoupPossible(p.getMonPlateau(), j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel()));
                        for(int i=0; i<c.size();i++){
                            //System.out.println(i+" :("+c.get(i).getAbscisse()+":"+c.get(i).getOrdonnee()+")");
                            if(c.get(i).getAbscisse()==a&&c.get(i).getOrdonnee()==o){
                                b=true;
                            }
                        }
                        if(b){
                    
                            j.getTabPion().get(j.getPionUtilisé()).deplacer(p.getMonPlateau(),p.getMonPlateau().getCase(a, o));
                            
                            int k=(j.getTabPion().get(j.getPionUtilisé()).getCasePrecedente().getAbscisse()-j.getTabPion().get(j.getPionUtilisé()).getX())-(j.getTabPion().get(j.getPionUtilisé()).getCasePrecedente().getOrdonnee()-j.getTabPion().get(j.getPionUtilisé()).getY());

                            if(k<0){
                                this.nbToursJoueur+=(-1)*k;
                            }else if(k>0){
                                this.nbToursJoueur+=k;
                            }else{
                                this.nbToursJoueur+=1;
                            }
                                deplacement=true;

                        }else{
                            Outils.afficherTexte("Déplacement impossible\n");
                        }
                    }
            }else{
                //Outils.afficherTexte((j.getTabPion().get(j.getPionUtilisé()).searchCoupPossible(p.getMonPlateau(), j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel()))).toString());
               //p.getMonPlateau().getPlateau().remove(p.getMonPlateau().getCase(j.getTabPion().get(j.getPionUtilisé()).getX(),j.getTabPion().get(j.getPionUtilisé()).getY()));
               System.out.println("["+j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel())+"J"+j.getTabPion().get(j.getPionUtilisé()).getNumjoueur()+"] Case actuelle :("+j.getTabPion().get(j.getPionUtilisé()).getX()+";"+j.getTabPion().get(j.getPionUtilisé()).getY()+")");
                Outils.afficherTexte("Sur quelle cases souhaitez vous vous déplacer ?(Vous pouvez vous déplacer sur "+(j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel())-this.nbToursJoueur)+" cases )\n");
                Outils.afficherTexte("Abscisse ?");
                int a=Outils.convertToInt(sc.next());
                Outils.afficherTexte("Ordonnée ?");
                int o=Outils.convertToInt(sc.next());
                boolean b=false;
                ArrayList<Cases> c=j.getTabPion().get(j.getPionUtilisé()).searchCoupPossible(p.getMonPlateau(), j.getTabPion().get(j.getPionUtilisé()).getNum(j.getTabPion().get(j.getPionUtilisé()).getNumActuel()));
                for(int i=0; i<c.size();i++){
                    //System.out.println(i+" :("+c.get(i).getAbscisse()+":"+c.get(i).getOrdonnee()+")");
                    if(c.get(i).getAbscisse()==a&&c.get(i).getOrdonnee()==o){
                        b=true;
                    }
                }
                
                if(b){
                    j.getTabPion().get(j.getPionUtilisé()).deplacer(p.getMonPlateau(),p.getMonPlateau().getCase(a, o));
                    int k=(j.getTabPion().get(j.getPionUtilisé()).getCasePrecedente().getAbscisse()-j.getTabPion().get(j.getPionUtilisé()).getX())-(j.getTabPion().get(j.getPionUtilisé()).getCasePrecedente().getOrdonnee()-j.getTabPion().get(j.getPionUtilisé()).getY());
                    if(k<0){
                        this.nbToursJoueur+=(-1)*k;
                    }else if(k>0){
                        this.nbToursJoueur+=k;
                    }else{
                        this.nbToursJoueur+=1;
                    }
                    deplacement=true;
                     
                }else{
                    Outils.afficherTexte("Déplacement impossible\n");
                }
            }
            
        }
        
      if(j.getTabPion().get(j.getPionUtilisé()).getX()==0 && j.getTabPion().get(j.getPionUtilisé()).getY()==0){
          j.setGagner(true);
      }
      j.getTabPion().get(j.getPionUtilisé()).setNumActuel();
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
    
    public int getNumManche(){
        return this.numManche;
    }
    
    public void setNumManche(int m){
        this.numManche=m;
    
    }
    
   
        
    
}
