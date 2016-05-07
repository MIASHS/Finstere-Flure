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
        System.out.println("hello world");
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
        }
        System.out.println("the world is too big mum");
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
    
    public boolean verifier(Cases c){
        return false;
    }
            
    
}
