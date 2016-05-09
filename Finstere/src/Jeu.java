
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
   // monstre
   private Monstre m;
   //Temps du jeu
   private Temps monTemps;
   //nombre de tours
   private int tour;
   //numero de manche
   private int manche;
   // coups restant par joueur
   private int coupRestantJoueur;
   // pseudo du joueur en train de jouer
   private String pseudoJoueurCourant;
   // Permet de savoir si la partie est finie
   private boolean fini=false;
   // menu du jeu
   private Menu monMenu;
   
   public Jeu(Menu m){
       this.j_list = new ArrayList<>();
       this.pions_perdu = new ArrayList<>();
       this.blocsPierre = new ArrayList <>();
       this.flaque = new ArrayList <>();
       this.monTemps=new Temps(0,0,false,false);
       this.monMenu=m;
   }
   
   public void init(Plateau plateauVide) {
       // mise en place des bloques de pierres 
       monPlateau=plateauVide;
        for(int i = 0; i < 10; i++ ){
            this.placementBlocPierre(monPlateau);
       }
        monPlateau.placerObstacle();
        for(int i = 0; i < 2; i++ ){
            this.placementFlaque(monPlateau,i);
        }
        
        monPlateau.placerObstacle();
        m= new Monstre(0,0,3,this);
        monPlateau.placerMonstre(this.m);
        Scanner sc=new Scanner(System.in);
        Outils.afficherTexte("Veuillez entrer le nom du joueur 1:");
        String pseudo= sc.nextLine(); 
        
        Joueurs joueur1 = new Joueurs(pseudo);
       
       
       joueur1.ajouterPion(new PionJoueur(1,1));       
       joueur1.ajouterPion(new PionJoueur(4,1));
       joueur1.ajouterPion(new PionJoueur(3,1));
       joueur1.ajouterPion(new PionJoueur(2,1));
       j_list.add(joueur1);
       
       Joueurs joueur2;
       
       if(this.monMenu.getIAJoueur()){
           joueur2 = this.monMenu.getJoueur2();
       }else{
           
           Outils.afficherTexte("Veuillez entrer le nom du joueur 2:");
           pseudo= sc.nextLine(); 
           joueur2 = new Joueurs(pseudo);
       }
       
       
       joueur2.ajouterPion(new PionJoueur(6,2));
       joueur2.ajouterPion(new PionJoueur(3,2));
       joueur2.ajouterPion(new PionJoueur(4,2));
       joueur2.ajouterPion(new PionJoueur(5,2));
       
       j_list.add(joueur2);
       
   }
   
    public void placementFlaque(Plateau plateauVide,int i){
        Random ra = new Random();
        int X = ra.nextInt(15);
        int Y = (-1)*ra.nextInt(11);
        Cases c = plateauVide.getCase(X,Y);
        Cases c1;
        Cases c2;
        Cases c3;
        if(i==0){
            c1 = plateauVide.getCase(X+1,Y);
            c2 = plateauVide.getCase(X,Y-1);
            c3 = plateauVide.getCase(X+1,Y-1);
        while (c.isOccupee()||c1.isOccupee()||c2.isOccupee()||c3.isOccupee() || (X > 8 && Y==0) || (X > 9 && Y==-1) || (X > 10 && Y==-2)|| (X > 11 && Y==-3)|| (X > 12 && Y>=-4) || (X == 0 && Y==0) || (X==3 && Y<-8) || (X == 0 && Y<-5) || (X == 1 && Y<-6) || (X == 2 && Y<-7) || (X>3 &&Y<-8) ){
                Y = (-1)*ra.nextInt(11);
                X = ra.nextInt(15);
                c = plateauVide.getCase(X,Y);
                c1 = plateauVide.getCase(X+1,Y);
                c2 = plateauVide.getCase(X,Y-1);
                c3 = plateauVide.getCase(X+1,Y-1);
        }
        Flaque f= new Flaque(X,Y,i);
        plateauVide.ajouterList(f);
        plateauVide.placerObstacle();
        }else{
            c1 = plateauVide.getCase(X+1,Y);
            c2 = plateauVide.getCase(X+2,Y);
            c3 = plateauVide.getCase(X+3,Y);
        while (c.isOccupee() || c1.isOccupee()||c2.isOccupee()||c3.isOccupee() || ( Y==-10) || (Y==-9)|| (X == 0 && Y==0) || (X > 8 && Y==0)|| (X > 9 && Y==-1)|| (X > 10 && Y==-2)|| (X > 11 && Y==-3)|| (X >12)|| (X == 0 && Y<-6)|| (X == 1 && Y<-7)|| (X == 2 && Y<-8)){
                Y = (-1)*ra.nextInt(11);
                X = ra.nextInt(15);
                c = plateauVide.getCase(X,Y);
                c1 = plateauVide.getCase(X+1,Y);
            c2 = plateauVide.getCase(X+2,Y);
            c3 = plateauVide.getCase(X+3,Y);
        }
        Flaque f= new Flaque(X,Y,i);
        plateauVide.ajouterList(f);
        plateauVide.placerObstacle();
        }
        
        
        
    }
    
    public void placementBlocPierre(Plateau plateauVide){
        Random ra = new Random();
        int placementX = ra.nextInt(15);
        int placementY = (-1)*ra.nextInt(11);
        Cases c = plateauVide.getCase(placementX,placementY);
        while (c.isOccupee() || (placementX == 0 && placementY==-1) || (placementX == 1 && placementY==-1)|| (placementX == 0 && placementY==0) || (placementX == 1 && placementY==0)|| (placementX == 15 && placementY==-10)|| (placementX == 14 && placementY==-10)|| (placementX == 14 && placementY==-9)|| (placementX == 15 && placementY==-9)|| (placementX > 11 && placementY==0)|| (placementX > 12 && placementY==-1)|| (placementX > 13 && placementY==-2)|| (placementX > 14 && placementY==-3)|| (placementX == 0 && placementY<-6)|| (placementX == 1 && placementY<-7)|| (placementX == 2 && placementY<-8)|| (placementX == 3 && placementY<-9)){
                placementY = (-1)*ra.nextInt(11);
                placementX = ra.nextInt(15);
                c = plateauVide.getCase(placementX,placementY);
        }
       Pierre p = new Pierre(placementX,placementY);
       // ajout dans la liste
       plateauVide.ajouterList(p);
       
       
    }

    public Monstre getMonstre(){
        return this.m;
    }
    public ArrayList<Joueurs> getJ_list() {
        return j_list;
    }

    public void setJ_list(ArrayList<Joueurs> j_list) {
        this.j_list = j_list;
    }

    public ArrayList<Pions> getPions_perdu() {
        return pions_perdu;
    }

    public void setPions_perdu(ArrayList<Pions> pions_perdu) {
        this.pions_perdu = pions_perdu;
    }

    public ArrayList<Pierre> getBlocsPierre() {
        return blocsPierre;
    }

    public void setBlocsPierre(ArrayList<Pierre> blocsPierre) {
        this.blocsPierre = blocsPierre;
    }

    public ArrayList<Flaque> getFlaque() {
        return flaque;
    }

    public void setFlaque(ArrayList<Flaque> flaque) {
        this.flaque = flaque;
    }

    public Plateau getMonPlateau() {
        return monPlateau;
    }

    public void setMonPlateau(Plateau monPlateau) {
        this.monPlateau = monPlateau;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getCoupRestantJoueur() {
        return coupRestantJoueur;
    }

    public void setCoupRestantJoueur(int coupRestantJoueur) {
        this.coupRestantJoueur = coupRestantJoueur;
    }

    public String getPseudoJoueurCourant() {
        return pseudoJoueurCourant;
    }

    public void setPseudoJoueurCourant(String pseudoJoueurCourant) {
        this.pseudoJoueurCourant = pseudoJoueurCourant;
    }
    
    public boolean isFini(){
        return but();
    }
    
    public int getManche(){
        return this.monTemps.getNumManche();
    }
    
    public void setManche(int i){
        this.manche=i;
    }
    
    public boolean but(){
        boolean b=false;
        for(Joueurs j: this.j_list){
            if(j.getPionTotal()==0 || j.isGagner()){
                b=true;
            }
        }
        return b;
    }
    public Temps getTemps(){
        return this.monTemps;
    }

    

}   
        

    
