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
    public void deplacerPion(Pions p){
    
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
