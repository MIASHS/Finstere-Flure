/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel, Sébastien, Valère 
 */

/*
    Cette classe permet de créer et gérer les pions Flaque inviduellement.
*/
public class Flaque extends Obstacle {
    //attribut
    private int type; // Tache hémoglobine carré ou allongé
    private boolean premiereC=true; // Si la flaque correspond à la flaque de référence ou non  
    //Constructors
    public Flaque(int x, int y, int i) {
        super(x, y);
        type= i;
    }
    public Flaque(int x, int y, int i,boolean pC) {
        super(x, y);
        type= i;
        premiereC=pC;
    }
    //Getter Setter
    public void modifmorpho(int i){
        this.type=i;
    }
    
    public int getType(){
        return type;
    }
    public boolean getPremiereC(){
    return premiereC;
    }
    
}
