/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public abstract class Pions implements Deplacements {
    protected int abscisse ; // 
    protected int ordonnee; //
    
    public void deplacer(int o){
    
    }
    public void deplacerPion(Pions p){// 1=haut 3=droite 4=bas 2=gauche
        if(p instanceof Monstre){
            if (((Monstre)p).getCasePrecedente().getAbscisse() - ((Monstre)p).getX() == 0) {
                if (((Monstre)p).getCasePrecedente().getOrdonnee() - ((Monstre)p).getY() < 0) {
                    ((Monstre)p).setY(((Monstre)p).getY() + 1);
                    ((Monstre)p).setOrientation(1);
                    ((Monstre)p).verifierCase(((Monstre)p).getOrientation());
                } else {
                    ((Monstre)p).setY(((Monstre)p).getY() - 1);
                    ((Monstre)p).setOrientation(4);
                    ((Monstre)p).verifierCase(((Monstre)p).getOrientation());
                }

            } else {
                if (((Monstre)p).getCasePrecedente().getAbscisse() - ((Monstre)p).getX() < 0) {
                    ((Monstre)p).setX(((Monstre)p).getX() + 1);
                    ((Monstre)p).setOrientation(3);
                    ((Monstre)p).verifierCase(((Monstre)p).getOrientation());
                } else {
                    ((Monstre)p).setX(((Monstre)p).getX() - 1);
                    ((Monstre)p).setOrientation(2);
                    ((Monstre)p).verifierCase(((Monstre)p).getOrientation());
                }

            }
        }else if(p instanceof PionJoueur){
            //System.out.println(" 1  = Case Precedente: ("+((PionJoueur)p).getCasePrecedente().getAbscisse()+";"+((PionJoueur)p).getCasePrecedente().getOrdonnee()+") Case Actuel: ("+this.getX()+";"+this.getY()+")");
            if (((PionJoueur)p).getCasePrecedente().getAbscisse() - this.getX() == 0) {
                if (((PionJoueur)p).getCasePrecedente().getOrdonnee() - this.getY() < 0) {
                    ((PionJoueur)p).setCasePrecedente(((Plateau)((PionJoueur)p).getMonPlateau()).getCase(((PionJoueur)p).getX(), ((PionJoueur)p).getY()));
                    ((PionJoueur)p).setY(((PionJoueur)p).getY() + 1);
                    ((PionJoueur)p).verifierCase(((PionJoueur)p).getMonPlateau(), ((Plateau)((PionJoueur)p).getMonPlateau()).getCase(((PionJoueur)p).getX(), ((PionJoueur)p).getY()));
                } else {
                    ((PionJoueur)p).setCasePrecedente(((Plateau)((PionJoueur)p).getMonPlateau()).getCase(((PionJoueur)p).getX(), ((PionJoueur)p).getY()));
                    ((PionJoueur)p).setY(((PionJoueur)p).getY() - 1);
                                        ((PionJoueur)p).verifierCase(((PionJoueur)p).getMonPlateau(), ((Plateau)((PionJoueur)p).getMonPlateau()).getCase(((PionJoueur)p).getX(), ((PionJoueur)p).getY()));
                }

            } else {
                if (((PionJoueur)p).getCasePrecedente().getAbscisse() - this.getX() < 0) {
                    ((PionJoueur)p).setCasePrecedente(((Plateau)((PionJoueur)p).getMonPlateau()).getCase(((PionJoueur)p).getX(), ((PionJoueur)p).getY()));
                    ((PionJoueur)p).setX(((PionJoueur)p).getX() + 1);
                                        ((PionJoueur)p).verifierCase(((PionJoueur)p).getMonPlateau(), ((Plateau)((PionJoueur)p).getMonPlateau()).getCase(((PionJoueur)p).getX(), ((PionJoueur)p).getY()));
                } else {
                    ((PionJoueur)p).setCasePrecedente(((Plateau)((PionJoueur)p).getMonPlateau()).getCase(((PionJoueur)p).getX(), ((PionJoueur)p).getY()));
                    ((PionJoueur)p).setX(((PionJoueur)p).getX() - 1);
                                        ((PionJoueur)p).verifierCase(((PionJoueur)p).getMonPlateau(), ((Plateau)((PionJoueur)p).getMonPlateau()).getCase(((PionJoueur)p).getX(), ((PionJoueur)p).getY()));
                }
            }
            //System.out.println(" 2  = Case Precedente: ("+((PionJoueur)p).getCasePrecedente().getAbscisse()+";"+((PionJoueur)p).getCasePrecedente().getOrdonnee()+") Case Actuel: ("+((PionJoueur)p).getX()+";"+((PionJoueur)p).getY()+")");
        }else if(p instanceof Pierre){
            if (((Pierre)p).getX() - this.getX() == 0) {
                if (((Pierre)p).getX() - this.getY() < 0) {
                    //((Pierre)p).setCasePrecedente(((Plateau)((Pierre)p).getMonPlateau()).getCase(((Pierre)p).getX(), ((Pierre)p).getY()));
                    //((Pierre)p).setY(((Pierre)p).getY() + 1);
                    ((Pierre)p).deplacer(1,((Pierre)p).getMonPlateau(),this);//verifierCase(((Pierre)p).getMonPlateau(), ((Plateau)((Pierre)p).getMonPlateau()).getCase(((Pierre)p).getX(), ((Pierre)p).getY()));
                } else {
                    //((Pierre)p).setCasePrecedente(((Plateau)((Pierre)p).getMonPlateau()).getCase(((Pierre)p).getX(), ((Pierre)p).getY()));
                    //((Pierre)p).setY(((Pierre)p).getY() - 1);
                    ((Pierre)p).deplacer(4,((Pierre)p).getMonPlateau(),this);//.verifierCase(((Pierre)p).getMonPlateau(), ((Plateau)((Pierre)p).getMonPlateau()).getCase(((Pierre)p).getX(), ((Pierre)p).getY()));
                }

            } else {
                if (((Pierre)p).getX() - this.getX() < 0) {
                    //((Pierre)p).setCasePrecedente(((Plateau)((Pierre)p).getMonPlateau()).getCase(((Pierre)p).getX(), ((Pierre)p).getY()));
                    //((Pierre)p).setX(((Pierre)p).getX() + 1);
                    ((Pierre)p).deplacer(3, ((Pierre) p).getMonPlateau(), this);//.verifierCase(((Pierre)p).getMonPlateau(), ((Plateau)((Pierre)p).getMonPlateau()).getCase(((Pierre)p).getX(), ((Pierre)p).getY()));
                } else {
                    //((Pierre)p).setCasePrecedente(((Plateau)((Pierre)p).getMonPlateau()).getCase(((Pierre)p).getX(), ((Pierre)p).getY()));
                    //((Pierre)p).setX(((Pierre)p).getX() - 1);
                    ((Pierre)p).deplacer(2, ((Pierre) p).getMonPlateau(), this);//.verifierCase(((Pierre)p).getMonPlateau(), ((Plateau)((Pierre)p).getMonPlateau()).getCase(((Pierre)p).getX(), ((Pierre)p).getY()));
                }
            }
        }
    }
    
    public int hashCode(){
    
        return ((this.getX()*17)+(this.getY()*13));
    }
    
    public int getX(){
        return abscisse;
    }
    public int getY(){
        return ordonnee;
    }
    public boolean setX(int x){
        abscisse = x;
        return true;
        
    }
    public boolean setY(int y){
        ordonnee = y;
        return true;
    }
    
    
            
    
}
