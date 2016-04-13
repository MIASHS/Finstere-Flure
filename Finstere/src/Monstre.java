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
    private int x;
    private int y;
    private int orientation; // 1=haut 3=droite 4=bas 2=gauche
    private boolean chgmtOrientation=false;
    private Paquet listeCarte = new Paquet();
    int nbPionsTues=0;
    

    public Monstre(int x, int y, int orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
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

    public Paquet getListeCarte() {
        return listeCarte;
    }

    public void setListeCarte(Paquet listeCarte) {
        this.listeCarte = listeCarte;
    }

    
    // méthode
    
    public void deplacement(Cartes c){
        if(c.getNumeroCarte()!=11&&c.getNumeroCarte()!=12){
            int nbCasesRestantes = c.getNumeroCarte();
            while(nbCasesRestantes!=0){
                
                
                   this.regarder(this.getOrientation());
                

                switch(this.getOrientation()){
                    case 1:
                            this.setX(this.getX()+1);
                            break;
                    case 2:
                            this.setY(this.getY()-1);
                            break;
                    case 3:
                            this.setY(this.getY()+1);
                            break;
                    case 4:
                            this.setX(this.getX()-1);
                            break;
                }
                this.verifierCase();
                nbCasesRestantes-=0;
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
                   this.regarder(j);
                }

                switch(this.getOrientation()){
                    case 1:
                            this.setX(this.getX()+1);
                            break;
                    case 2:
                            this.setY(this.getY()-1);
                            break;
                    case 3:
                            this.setY(this.getY()+1);
                            break;
                    case 4:
                            this.setX(this.getX()-1);
                            break;
                }
                this.verifierCase();
                nbCasesParcourues+=1;
            }
        }
        
    }
    
    public boolean changementO(){
        return false;
    }
    public boolean regarder(int o){
        switch(o){
            case 1: 
                    break;
            case 2:
                    break;
            case 3:
                    break;
            case 4:
                    break;
        }
        
        return false;
    }
    public void seTeleporter(char c){
    
    }
    public void tuer(Pions p){
    
    }
    
    public void verifierCase(){
    
    }
   

    
    
    
    
}
