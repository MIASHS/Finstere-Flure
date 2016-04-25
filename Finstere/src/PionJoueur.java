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

        public PionJoueur(int x , int y){
            this.abscisse=x;
            this.ordonnee=y;
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
        
        public void deplacer(int num,Plateau monPlateau){
            //On retire la case du tableau en plaçant le booleen occupe à faux
            
            
            Cases c =monPlateau.getCase(this.getX(),this.getY());
            if(!c.isFlaque()){
                
                c.setOccupee(false);
                c.setPioncase(null);
                monPlateau.getPlateau().remove(c);
                
            }else{
                c.setPioncase(c.getFlaque());
            }
            
            
            
            //On estime les coups possibles depuis la position du joueur en 
            //fonction de num et des barrières du plateau de jeu
            
            
            
            //On sort la liste des coups possibles.
            //En fonction de la case choisie, on place la case choisie dans le tableau
        }

    @Override
    public void deplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
