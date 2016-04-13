
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
     
       
       
       // mise en place des flaques
       this.flaque = new ArrayList<Flaque>();
       Flaque flaque1 = new Flaque(100,90);
       Flaque flaque2 = new Flaque (60,80);
       // ajout dans la liste
       this.flaque.add(flaque1);
       this.flaque.add(flaque2);
       
       // mise en place des bloques de pierres
       this.blocsPierre = new ArrayList<Pierre>();
       Pierre p1 = new Pierre(108,100);
       Pierre p2 = new Pierre(10,11);
       Pierre p3 = new Pierre(30,55);
       Pierre p4 = new Pierre(80,66);
       Pierre p5 = new Pierre(120,100);
       // ajout dans la liste
       this.blocsPierre.add(p1);
       this.blocsPierre.add(p2);
       this.blocsPierre.add(p3);
       this.blocsPierre.add(p4);
       this.blocsPierre.add(p5);
       
       Joueurs joueur1 = new Joueurs("Gab");
       
       joueur1.ajouterPion(new PionJoueur(12,0));
       joueur1.ajouterPion(new PionJoueur(15,0));
       joueur1.ajouterPion(new PionJoueur(14,0));
       
       j_list.add(joueur1);
       
        Joueurs joueur2 = new Joueurs("Valére");
       
       joueur2.ajouterPion(new PionJoueur(12,1));
       joueur2.ajouterPion(new PionJoueur(15,1));
       joueur2.ajouterPion(new PionJoueur(14,1));
       
       j_list.add(joueur2);
   }
   
    
}
