/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel, Valère, Sébastien
 */
/*
        Cette classe permet de créer et gérer les cases du plateau individuellement
*/
public class Cases {
    //Attribut
    //coordonnée de la cases
    private int abscisse ;
    private int ordonnee;
    //Permet de savoir si la casse est occupée par un autre pion ou non.
    boolean occupee=false;
    //Permet de savoir si le pion sur la case est un objet Flaque ou non.
    boolean cflaque=false;
    //Si le pion sur la case est un objet Flaque il est conservé ici.
    Flaque laFlaque=null;
    //Le pion de la case est stocké ici si elle est occupée. 
    Pions pioncase=null;
    //Constructor
    public Cases(int abscisse, int ordonnee, boolean occupee, Pions pioncase) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.occupee = occupee;
        this.pioncase = pioncase;
    }
    public Cases(int abscisse, int ordonnee, boolean occupee, Pions pioncase,boolean isf,Flaque f) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.occupee = occupee;
        this.pioncase = pioncase;
        this.cflaque=isf;
        this.laFlaque=f;
    }
    public Cases(int abscisse, int ordonnee, boolean occupee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.occupee = occupee;
    }
    //getter setter
    public int getAbscisse() {
        return abscisse;
    }
    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }
    public int getOrdonnee() {
        return ordonnee;
    }
    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }
    public boolean isOccupee() {
        return occupee;
    }
    public void setOccupee(boolean occupee) {
        this.occupee = occupee;
    }
    public Pions getPioncase() {
        return pioncase;
    }
    public void setPioncase(Pions pioncase) {
        this.pioncase = pioncase;
    }
    
    public boolean isPionHere(){
        if(this.pioncase instanceof PionJoueur){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isFlaque(){
        return this.cflaque;
    }
    
    public Flaque getFlaque(){
        return this.laFlaque;
    }
    
    public void setFlaque(boolean b){
        this.cflaque=b;
    }
    
    
}
