/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Cases {
    private int abscisse ;
    private int ordonnee;
    boolean occupee;
    boolean cflaque=false;
    Flaque laFlaque=null;
    Pions pioncase;

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
    // à corriger
    public boolean isPionHere(){
        return false;
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
