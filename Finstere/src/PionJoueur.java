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

        private boolean mort; //booléen indiquant si un pion d'un joueur est mort
        private boolean utilise;
        private int[] tabNumDispo;
        private int numActuelle;
        
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

        public int getNumActuelle() {
            return numActuelle;
        }
        
        public void setNumActuelle(int numActuelle) {
            this.numActuelle = numActuelle;
    }
        
    //Constructeur

        public PionJoueur(boolean mort, boolean utilise, int[] tabNumDispo, int numActuelle) {
            this.mort = mort;
            this.utilise = utilise;
            this.tabNumDispo =  tabNumDispo;
            this.numActuelle = numActuelle;
        }

    //Méthodes
        
        //Méthode permettant de faire mourir un pion d'un joueur
        public void mourir(boolean b){
            this.setMort(b);
        }
        
        //Méthode permettant de changer le numéro d'un pion d'un joueur
        public void changerNum(){
            if (this.numActuelle == tabNumDispo[0])
                this.numActuelle = tabNumDispo[1];
            else
                this.numActuelle = tabNumDispo[0];
        }
        
        public void deplacement(int num){
            
        }
}
