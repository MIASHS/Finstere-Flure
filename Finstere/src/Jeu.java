
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
   private ArrayList<Joueurs> j_list;
   // liste de pions perdu
   private ArrayList<Pions> pions_perdu;
   // liste de block de pierres
   private ArrayList<Pierre> blocsPierre;
   // liste de flaques
   private ArrayList<Flaque> flaque;
   // plateau de jeu
   private Plateau monPlateau;
   //nombre de tours
   private int tour;
   // coups restant par joueur
   private int coupRestantJoueur;
   // pseudo du joueur en train de jouer
   private String pseudoJoueurCourant;
   
   public Jeu(){
       j_list = new ArrayList<>();
       pions_perdu = new ArrayList<>();
       blocsPierre = new ArrayList <>();
       flaque = new ArrayList <>();
   }
   
   public void init(Plateau plateauVide) {
       // mise en place des bloques de pierres 
       
        for(int i = 0; i < 5; i++ ){
            this.placementBlocPierre(plateauVide);
       }
        for(int i = 0; i < 2; i++ ){
            this.placementFlaque(plateauVide,i);
        }
        
        plateauVide.placerObstacle();
     
       Joueurs joueur1 = new Joueurs("Gab");
       
       joueur1.ajouterPion(new PionJoueur(1));
       joueur1.ajouterPion(new PionJoueur(4));
       joueur1.ajouterPion(new PionJoueur(3));
       joueur1.ajouterPion(new PionJoueur(2));
       j_list.add(joueur1);
       
        Joueurs joueur2 = new Joueurs("Valère");
       
       joueur2.ajouterPion(new PionJoueur(1));
       joueur2.ajouterPion(new PionJoueur(4));
       joueur2.ajouterPion(new PionJoueur(3));
       joueur2.ajouterPion(new PionJoueur(2));
       
       j_list.add(joueur2);
   }
   
    public void placementFlaque(Plateau plateauVide,int i){
        Random ra = new Random();
        int X = ra.nextInt(15);
        int Y = ra.nextInt(11);
        Cases c = plateauVide.getCase(X,Y);
        Cases c1;
        Cases c2;
        Cases c3;
        if(i==0){
            c1 = plateauVide.getCase(X+1,Y);
            c2 = plateauVide.getCase(X,Y-1);
            c3 = plateauVide.getCase(X+1,Y-1);
        while (c.isOccupee()||c1.isOccupee()||c2.isOccupee()||c3.isOccupee() || (X > 8 && Y==0) || (X > 9 && Y==-1) || (X > 10 && Y==-2)|| (X > 11 && Y==-3)|| (X > 12 && Y>=-4) || (X == 0 && Y==0)){
                Y = ra.nextInt(11);
                X = ra.nextInt(15);
                c = plateauVide.getCase(X,Y);
                c1 = plateauVide.getCase(X+1,Y);
                c2 = plateauVide.getCase(X,Y-1);
                c3 = plateauVide.getCase(X+1,Y-1);
        }
        }else{
            c1 = plateauVide.getCase(X+1,Y);
            c2 = plateauVide.getCase(X+2,Y);
            c3 = plateauVide.getCase(X+3,Y);
        while (c.isOccupee() || c1.isOccupee()||c2.isOccupee()||c3.isOccupee() || ( Y==10) || (Y==9)|| (X == 0 && Y==0) || (X == 10 && Y==0)|| (X == 11 && Y==-1)|| (X == 12 && Y==-2)|| (X == 13 && Y==-3)|| (X == 14 && Y>=-4)|| (X == 15 && Y==-10)|| (X == 0 && Y==-6)|| (X == 1 && Y==-7)|| (X == 2 && Y==-8)){
                Y = ra.nextInt(11);
                X = ra.nextInt(15);
                c = plateauVide.getCase(X,Y);
                c1 = plateauVide.getCase(X+1,Y);
            c2 = plateauVide.getCase(X+2,Y);
            c3 = plateauVide.getCase(X+3,Y);
        }
        }
        
        
        Flaque f= new Flaque(X,Y,i);
        plateauVide.ajouterList(f);
    }
    
    public void placementBlocPierre(Plateau plateauVide){
        Random ra = new Random();
        int placementX = ra.nextInt(15);
        int placementY = ra.nextInt(11);
        Cases c = plateauVide.getCase(placementX,placementY);
        while (c.isOccupee() || (placementX == 0 && placementY==1) || (placementX == 1 && placementY==1)|| (placementX == 0 && placementY==0) || (placementX == 1 && placementY==0)|| (placementX == 11 && placementY==15)|| (placementX == 11 && placementY==14)|| (placementX == 10 && placementY==14)|| (placementX == 10 && placementY==15)){
                placementY = ra.nextInt(11);
                placementX = ra.nextInt(15);
                c = plateauVide.getCase(placementX,placementY);
        }
       Pierre p = new Pierre(placementX,placementY);
       // ajout dans la liste
       plateauVide.ajouterList(p);
       
       
    }

    

}   
        

    
