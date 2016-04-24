/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seb
 */
public class PionJoueur extends Pions {
    
   
    //Attributs

        public PionJoueur(int abscisse , int ordonnee){
            this.abscisse=abscisse;
            this.ordonnee=ordonnee;
        }
        
        private boolean mort=false; //booléen indiquant si un pion d'un joueur est mort
        private boolean utilise=false;
        private int[] tabNumDispo= new int[2];
        private int numActuel=0;
        
        public PionJoueur(int coupFace){
            tabNumDispo[0]=coupFace;
            tabNumDispo[1]=7- coupFace;
        }
        
        public void setNumActuel(){
            if(numActuel==0){
                numActuel+=1;
            }else{
                numActuel=0;
            }
        }
    
       
        
        
        
    //Getters Setters
        
        public boolean isMort() {
            return mort;
        }

        public void setMort(boolean mort) {
            this.mort = mort;
        }

        public boolean isUtilise() {
            return utilise;
        }

        public void setUtilise(boolean utilise) {
            this.utilise = utilise;
        }

        public int[] getTabNumDispo() {
            return tabNumDispo;
        }

        public void setTabNumDispo(int[] tabNumDispo) {
            this.tabNumDispo = tabNumDispo;
        }

        public int getNumActuel() {
            return numActuel;
        }
        public void setNumActuel(int i){
            if(i==0||i==1){
                numActuel=i;
            }
        }
        
    //Constructeur

        public PionJoueur(boolean mort, boolean utilise, int[] tabNumDispo, int numActuelle) {
            this.mort = mort;
            this.utilise = utilise;
            this.tabNumDispo =  tabNumDispo;
            this.numActuel = numActuelle;
        }

    //Méthodes
        
        //Méthode permettant de faire mourir un pion d'un joueur
        public void mourir(boolean b){
            this.setMort(b);
        }
        
        public void deplacement(int num){
            
        }
}
