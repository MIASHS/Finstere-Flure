
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Monstre extends Pions{
    private int orientation; // 1=haut 3=droite 4=bas 2=gauche
    private boolean chgmtOrientation=false;
    private Paquet listeCarte = new Paquet();
    private Plateau monPlateau;
    int nbPionsTues=0;
    private ArrayList<Cases> chemin=new ArrayList<>();
    private Cases casePrecedente;
    
    // Constructeur
    public Monstre(int x, int y, int orientation,Jeu partie) {
        this.setX(x);
        this.setY(y);
        this.orientation = orientation;
        this.monPlateau=partie.getMonPlateau();
    }

    public void makeChemin(Cases c){
        chemin.add(c);
    }

    public ArrayList<Cases> getChemin() {
        return chemin;
    }

    public void setChemin(ArrayList<Cases> chemin) {
        this.chemin = chemin;
    }
    
    public Cases getCasePrecedente(){
        return casePrecedente;
    }
    
    public void setCasePrecedente(Cases c){
        this.casePrecedente=c;
    }
    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Paquet getListeCarte() {
        return listeCarte;
    }

    public void setListeCarte(Paquet listeCarte) {
        this.listeCarte = listeCarte;
    }

    
    // méthodes
    
    public void deplacer(Cartes c){
        casePrecedente=monPlateau.getCase(this.getX(), this.getY());
        this.makeChemin(monPlateau.getCase(this.getX(), this.getY()));
        monPlateau.getPlateau().remove(monPlateau.getCase(this.getX(), this.getY()));
        if(c.getNumeroCarte()!=11&&c.getNumeroCarte()!=12){
            int nbCasesRestantes = c.getNumeroCarte();
            while(nbCasesRestantes!=0){
                
                
                   this.regarder(this.getOrientation(),monPlateau);

                switch(this.getOrientation()){
                    case 1:
                            this.setY(this.getY()+1);
                            break;
                    case 2:
                            this.setX(this.getX()-1);
                            break;
                    case 3:
                            this.setX(this.getX()+1);
                            break;
                    case 4:
                            this.setY(this.getY()-1);
                            break;
                }
                this.verifierCase(this.getOrientation());
                this.makeChemin(monPlateau.getCase(this.getX(), this.getY()));
                nbCasesRestantes-=1;
            }
        }else{
            int i;
            if(c.getNumeroCarte()==11){
                i=1;
            }else{
                i=2;
            }
            int nbCasesParcourues=0;
            while(nbPionsTues!=i||nbCasesParcourues==20){
                for(int j=1;j<4;j++){
                   this.regarder(j, monPlateau);
                }
                switch(this.getOrientation()){
                    case 1:
                            this.setY(this.getY()+1);
                            break;
                    case 2:
                            this.setX(this.getX()-1);
                            break;
                    case 3:
                            this.setX(this.getX()+1);
                            break;
                    case 4:
                            this.setY(this.getY()-1);
                            break;
                }
                this.verifierCase(this.getOrientation());
                this.makeChemin(monPlateau.getCase(this.getX(), this.getY()));
                nbCasesParcourues+=1;
            }
        }
        
        Cases c1=monPlateau.getCase(this.getX(), this.getY());
        c1.setPioncase(this);
        c1.setOccupee(true);
        
        monPlateau.ajouterCase(c1);
        ///TEST////
        /*for(Cases c2: monPlateau.getPlateau()){
            System.out.println(c2.getPioncase().getClass().getName()+": ("+c2.getAbscisse()+";"+c2.getOrdonnee()+") > ("+c2.getPioncase().getX()+";"+c2.getPioncase().getY()+")");
        }*/
    }
    
    public boolean changementO(int o){
        return false;
    }
    public boolean regarder(int o,Plateau monPlateau){
        int memoire=0;
        boolean trouve=false;
        boolean chg=false;
        switch(o){
            case 1: 
                    for(int i= this.ordonnee;i>-1;i--){
                        if(monPlateau.getCase(this.abscisse,i).isPionHere()&&!trouve){
                            memoire = this.ordonnee - i;
                            trouve=true;
                        }
                    }
                    trouve=false;
                    for(int i= this.ordonnee;i<11;i++){
                        if(monPlateau.getCase(this.abscisse,i).isPionHere()&&!trouve){
                            if(memoire - (i - this.ordonnee)<0){
                                chg=this.changementO(2);
                            }else if(memoire - (i - this.ordonnee)>0){
                                chg=this.changementO(3);
                            }
                            trouve=true;
                        }
                    }
                    break;
            case 2:
                    for(int i= this.abscisse;i>-1;i--){
                        if(monPlateau.getCase(i,this.ordonnee).isPionHere()&&!trouve){
                            memoire = this.abscisse - i;
                            trouve=true;
                        }
                    }
                    trouve=false;
                    for(int i= this.abscisse;i<16;i++){
                        if(monPlateau.getCase(i,this.ordonnee).isPionHere()&&!trouve){
                            if(memoire - (i - this.abscisse)<0){
                                chg=this.changementO(4);
                            }else if(memoire - (i - this.abscisse)>0){
                                chg=this.changementO(1);
                            }
                            trouve=true;
                        }
                    }
                    break;
            case 3:
                    for(int i= this.abscisse;i<16;i++){
                        if(monPlateau.getCase(i,this.ordonnee).isPionHere()&&!trouve){
                            memoire = this.abscisse - i;
                            trouve=true;
                        }
                    }
                    trouve=false;
                    for(int i= this.abscisse;i>-1;i--){
                        if(monPlateau.getCase(i,this.ordonnee).isPionHere()&&!trouve){
                            if(memoire - (i - this.abscisse)<0){
                                chg=this.changementO(4);
                            }else if(memoire - (i - this.abscisse)>0){
                                chg=this.changementO(1);
                            }
                            trouve=true;
                        }
                    }
                    break;
            case 4:
                    for(int i= this.ordonnee;i<11;i++){
                        if(monPlateau.getCase(this.abscisse,i).isPionHere()&&!trouve){
                            memoire = this.ordonnee - i;
                            trouve=true;
                        }
                    }
                    trouve=false;
                    for(int i= this.ordonnee;i>-1;i--){
                        if(monPlateau.getCase(this.abscisse,i).isPionHere()&&!trouve){
                            if(memoire - (i - this.ordonnee)<0){
                                chg=this.changementO(2);
                            }else if(memoire - (i - this.ordonnee)>0){
                                chg=this.changementO(3);
                            }
                            trouve=true;
                        }
                    }
                    break;
        }
        
        return false;
    }
    public void seTeleporter(char c){
        Outils.convertChartoCoor(c,this);
    }
    public void tuer(PionJoueur p){
        p.mourir(true);
    }
    public Plateau getMonPlateau(){
        return monPlateau;
    }
    
    public void verifierCase(int o){
        if(monPlateau.getCase(this.abscisse,this.ordonnee).isOccupee()){
            switch(monPlateau.getCase(this.abscisse,this.ordonnee).getPioncase().getClass().getName()){
                case "Pierre":
                        ((Pierre)monPlateau.getCase(this.abscisse,this.ordonnee).getPioncase()).deplacer(o,monPlateau);
                    break;
                case "Flaque":
                        monPlateau.getCase(this.abscisse,this.ordonnee).getPioncase().deplacerPion(this);
                    break;
                case "PionJoueur":
                    if( monPlateau.getCase(this.abscisse,this.ordonnee).getPioncase() instanceof PionJoueur) {
                        this.tuer((PionJoueur)monPlateau.getCase(this.abscisse,this.ordonnee).getPioncase());
                    }
                    break;
                //default: this.seTeleporter(Outils.convertCoorToChar(this.abscisse,this.ordonnee,this.orientation));
                  //  break;
            }
        }else if(!((this.getX() > -1 && this.getY() < 1 && this.getX() < 12 && this.getY() > -7) || (this.getX() < 16 && this.getY() > -11 && this.getX() > 3 && this.getY() < -3) || (this.getX() < 15 && this.getY() > -10 && this.getX() > 2 && this.getY() < -2) || (this.getX() < 14 && this.getY() > -9 && this.getX() > 1 && this.getY() < -1) || (this.getX() < 13 && this.getY() > -8 && this.getX() > 0 && this.getY() < 0))){
            this.seTeleporter(Outils.convertCoorToChar(this.abscisse,this.ordonnee,this.orientation));
            
        }
    }

    @Override
    public void deplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    
    
    
    
}
