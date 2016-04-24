/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Flaque extends Obstacle {
    
    private int type;
    private boolean premiereC=true;
    
    public Flaque(int positionX, int positionY, int i) {
        super(positionX, positionY);
        type= i;
    }
    public Flaque(int positionX, int positionY, int i,boolean pC) {
        super(positionX, positionY);
        type= i;
        premiereC=pC;
    }
    
    public void modifmorpho(int i){
    
    }
    
    public int getType(){
        return type;
    }
    public boolean getPremiereC(){
    return premiereC;
    }
    
}
