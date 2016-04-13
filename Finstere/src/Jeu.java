
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
   
    
   private ArrayList<Joueurs> j_list = new ArrayList<Joueurs>();
   
   private ArrayList<Pions> pions_perdu = new ArrayList<Pions>();
   
   private ArrayList<Pierre> blocsPierre = new ArrayList <Pierre>();
   
   private ArrayList<Flaque> flaque = new ArrayList <Flaque>();
   
   private int tour;
   
   private int coupRestantJoueur;
   
   private String pseudoJoueurCourant;
   
   public void init() {
     
       
       
       // mise en place des flaques
       this.flaque = new ArrayList<Flaque>();
       Flaque flaque1 = new Flaque(100,90);
       Flaque flaque2 = new Flaque (60,80);
       this.flaque.add(flaque1);
       this.flaque.add(flaque2);
       
       this.blocsPierre = new ArrayList<Pierre>();
       Pierre p1 = new Pierre(108,100);
       Pierre p2 = new Pierre(10,11);
       Pierre p3 = new Pierre(30,55);
       Pierre p4 = new Pierre(80,66);
       Pierre p5 = new Pierre(120,100);
       this.blocsPierre.add(p1);
       this.blocsPierre.add(p2);
       this.blocsPierre.add(p3);
       this.blocsPierre.add(p4);
       this.blocsPierre.add(p5);
       
   }
   
    
}
