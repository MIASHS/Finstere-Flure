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
    private int x ;
    private int y;
    private int orientation;
    private int[] listeCarte = new int[7];
    private boolean changementO;

    public Monstre(int x, int y, int orientation, boolean changementO) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.changementO = changementO;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int[] getListeCarte() {
        return listeCarte;
    }

    public void setListeCarte(int[] listeCarte) {
        this.listeCarte = listeCarte;
    }

    public boolean isChangementO() {
        return changementO;
    }

    public void setChangementO(boolean changementO) {
        this.changementO = changementO;
    }
    
    

    
    
    
    
}
