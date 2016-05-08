
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seb
 */
public class TestConsole {


    //Test initialisation du jeu
    public static void testInit() {      
        Menu m = new Menu();
        
        //Premier menu
        m.menuNiveauZero(Outils.conversionCaractere(Outils.afficher(0,m.getPartieActuelle())));
       
        //Test du plateau de jeu
        //testPlateau(m.getPartieActuelle().getMonPlateau()); 
       
        testTour(m.getPartieActuelle(),m);
        
        
    }

    public static void testPlateau(Plateau p) {
        Outils.afficherTexte("   ");
        for(int k=0;k<16;k++){
            if(k>9){
                Outils.afficherTexte("  "+k+" ");
            }else{
                Outils.afficherTexte("  "+k+"  ");
            }
        }
  
        Outils.afficherTexte("\n");
        for (int j = 0; j > -11; j--) {
            if(j==0){
                System.out.print(" "+j+" ");
            }else{
                if(j==-10){
                    System.out.print(j);
                }else{
                    System.out.print(j+" ");
                }
            }
            
 
            for (int i = 0; i < 16; i++) {
                
                if (p.getCase(i,j).isOccupee() != false) {
                    switch (p.getCase(i, j).getPioncase().getClass().getName()) {
                        case "Pierre":
                            Outils.afficherTexte("[ P ]");
                            break;
                        case "Flaque":
                            Outils.afficherTexte("[ F ]");
                            break;
                        case "Monstre":
                            Outils.afficherTexte("[ M ]");
                            break;
                        case "PionJoueur":
                            PionJoueur pj=(PionJoueur)p.getCase(i,j).getPioncase();
                            pj.getNumActuel();
                            Outils.afficherTexte("["+pj.getNum(pj.getNumActuel())+"J"+pj.getNumjoueur()+"]");
                            break;
                        default:
                            Outils.afficherTexte("[ B ]");
                            break;
                    }
                } else {
                    if(!((i>=0&&j<=0&&i<=11&&j>=-6)||(i<=15&&j>=-10&&i>=4&&j<=-4)||(i<=14&&j>=-9&&i>=3&&j<=-3)||(i<=13&&j>=-8&&i>=2&&j<=-2)||(i<=12&&j>=-7&&i>=1&&j<=-1))){
                        Outils.afficherTexte("[XXX]");
                    }else if(p.getCase(i, j).getPioncase() instanceof Flaque){
                         Outils.afficherTexte("[ F ]");
                    }else{
                        Outils.afficherTexte("[   ]");
                    }
                       
                    }
                }
            
            Outils.afficherTexte("\n");
        }
        
    }
    
    
    //////TEST
    //System.out.println("Cp =("+this.casePrecedente.getAbscisse()+";"+this.casePrecedente.getOrdonnee()+") ; J =("+this.getX()+";"+this.getY()+")");
    
    public static void testTour(Jeu p,Menu m){
         
        //On instancie un objet temps
        Temps t = new Temps(0,0,false,false);
         
        ArrayList<Cases> cheminMonstre;  
        t.debutGame();
         //on appelle la méthode qui gère les tours
        Outils.afficherTexte("\nDébut du tour...\n");
        while(!p.isFini()){
            cheminMonstre = t.gestionTourGros(p.getMonstre(),p);
            //for(Cases c2 :cheminMonstre){
            //    System.out.println("Cas: ("+c2.getAbscisse()+";"+c2.getOrdonnee()+")");
            //}
        }
         
        testPlateau(m.getPartieActuelle().getMonPlateau());
        Outils.afficherTexte("test");
       
    }
}
