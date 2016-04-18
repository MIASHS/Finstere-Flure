
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Jeu {
   
   // liste de joueurs 
   private ArrayList<Joueurs> j_list = new ArrayList<Joueurs>();
   // liste de pions perdu
   private ArrayList<Pions> pions_perdu = new ArrayList<Pions>();
   // liste de block de pierres
   private ArrayList<Pierre> blocsPierre = new ArrayList <Pierre>();
   // liste de flaques
   private ArrayList<Flaque> flaque = new ArrayList <Flaque>();
   //nombre de tours
   private int tour;
   // coups restant par joueur
   private int coupRestantJoueur;
   // pseudo du joueur en train de jouer
   private String pseudoJoueurCourant;
   
   
   public void init() {
       int i;
       // mise en place des bloques de pierres
       for(i = 0; i < 5; i++ ){
       this.placementBlocPierreHaut();
       }
       
       // mise en place des flaques
       this.flaque = new ArrayList<Flaque>();
       Flaque flaque1 = new Flaque(8,10);
       Flaque flaque2 = new Flaque (7,6);
       // ajout dans la liste
       this.flaque.add(flaque1);
       this.flaque.add(flaque2);
       
       
       

       
       Joueurs joueur1 = new Joueurs("Gab");
       
       joueur1.ajouterPion(new PionJoueur(12,0));
       joueur1.ajouterPion(new PionJoueur(15,0));
       joueur1.ajouterPion(new PionJoueur(14,0));
       
       j_list.add(joueur1);
       
        Joueurs joueur2 = new Joueurs("Valère");
       
       joueur2.ajouterPion(new PionJoueur(12,1));
       joueur2.ajouterPion(new PionJoueur(15,1));
       joueur2.ajouterPion(new PionJoueur(14,1));
       
       j_list.add(joueur2);
   }
   
    public void placementBlocPierreHaut(){
        Random ra = new Random();
        int placementX = ra.nextInt(15);
        int placementY = ra.nextInt(11);
        
        while ((placementX == 0 && placementY==1) || (placementX == 1 && placementY==1)|| (placementX == 0 && placementY==0) || (placementX == 1 && placementY==0)|| (placementX == 11 && placementY==15)|| (placementX == 11 && placementY==14)|| (placementX == 10 && placementY==14)|| (placementX == 10 && placementY==15)){
                placementY = ra.nextInt(11);
                placementX = ra.nextInt(15);
        }
       Pierre p = new Pierre(placementX,placementY);
       // ajout dans la liste
       this.blocsPierre.add(p);
    }

    

}   
        

    
