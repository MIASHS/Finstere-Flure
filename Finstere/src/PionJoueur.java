
import java.util.ArrayList;

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
        private ArrayList<Cases> coupPossible=new ArrayList<>();
        private Cases casePrecedente;
        
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
        
        public ArrayList<Cases> getCoupPossible(){
            return this.coupPossible;
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
        
        public void searchCoupPossible(int num){
        
            
            ArrayList<Cases> listProvisoire=new ArrayList<>();
            
                for(int j=0;j<num;j++){
                        for(int i=1;i<(num-j);i++){
                           listProvisoire.add(new Cases(this.getX()+i,this.getY()+j,false));
                        }
                }
                
                for(int j=0;j<num;j++){
                        for(int i=-1;i<(j-num);i--){
                           listProvisoire.add(new Cases(this.getX()+i,this.getY()+j,false));
                        }
                }
                
                for(int j=0;j<-num;j--){
                        for(int i=-1;i<(j-num);i--){
                           listProvisoire.add(new Cases(this.getX()+i,this.getY()+j,false));
                        }
                }
                
                for(int j=0;j<-num;j--){
                        for(int i=1;i<(num-j);i++){
                           listProvisoire.add(new Cases(this.getX()+i,this.getY()+j,false));
                        }
                }
                
                
                
                
            while(!listProvisoire.isEmpty()){
                if(((listProvisoire.get(0).getAbscisse()>=0&&listProvisoire.get(0).getOrdonnee()<=0&&listProvisoire.get(0).getAbscisse()<=10&&listProvisoire.get(0).getOrdonnee()>=-6)||(listProvisoire.get(0).getAbscisse()<=15&&listProvisoire.get(0).getOrdonnee()>=-10&&listProvisoire.get(0).getAbscisse()>=4&&listProvisoire.get(0).getOrdonnee()<=-4)||(listProvisoire.get(0).getAbscisse()<=14&&listProvisoire.get(0).getOrdonnee()>=-9&&listProvisoire.get(0).getAbscisse()>=3&&listProvisoire.get(0).getOrdonnee()<=-3)||(listProvisoire.get(0).getAbscisse()<=13&&listProvisoire.get(0).getOrdonnee()>=-8&&listProvisoire.get(0).getAbscisse()>=2&&listProvisoire.get(0).getOrdonnee()<=-2)||(listProvisoire.get(0).getAbscisse()<=12&&listProvisoire.get(0).getOrdonnee()>=-7&&listProvisoire.get(0).getAbscisse()>=1&&listProvisoire.get(0).getOrdonnee()<=-1))&&!(listProvisoire.get(0).getPioncase() instanceof Monstre)&&!(listProvisoire.get(0).getPioncase() instanceof PionJoueur)){
                        this.verifierCase(listProvisoire.get(0));
                       coupPossible.add(listProvisoire.get(0));
                    
                }
                listProvisoire.remove(0);
            }
        }
        
        public void deplacer(Plateau monPlateau,Cases cas){
            //On retire la case du tableau en plaçant le booleen occupe à faux
            
            
            Cases c =monPlateau.getCase(this.getX(),this.getY());
            casePrecedente=c;
            if(!c.isFlaque()){
                
                c.setOccupee(false);
                c.setPioncase(null);
                monPlateau.getPlateau().remove(c);
                
            }else{
                c.setPioncase(c.getFlaque());
            }
            
            
            
            //On estime les coups possibles depuis la position du joueur en 
            //fonction de num et des barrières du plateau de jeu
            //cf searchCoupPossible()
            
            
            //On sort la liste des coups possibles.
            //cf getCoupPossible()
            //En fonction de la case choisie, on place la case choisie dans le tableau
            cas.setOccupee(true);
            cas.setPioncase(this);
            monPlateau.ajouterCase(cas);
            this.verifierCase(cas);
        }

    public void verifierCase(Cases c){
        // verifier la case precedente switch en fonction de l'orientation
        // 
        // verifier si la case ne contient pas déjà objet :
        
            if((c.getPioncase() instanceof Flaque)&&(c.getPioncase() instanceof Pierre)){
                       switch(c.getPioncase().getClass().getName()){
                           case "Flaque":
                               if(this.casePrecedente.getAbscisse()-this.getX()==0){
                                   if(this.casePrecedente.getOrdonnee()-this.getY()<0){
                               
                                    }else{
                               
                                    }
                                   
                               }else {
                                   if(this.casePrecedente.getAbscisse()-this.getX()<0){
                               
                                    }else{
                               
                                    }
                                   
                               }
                               break;
                           case "Pierre":
                               if(this.casePrecedente.getAbscisse()-this.getX()==0){
                                   if(this.casePrecedente.getOrdonnee()-this.getY()<0){
                                       
                                    }else{
                                       
                                    }
                                   
                               }else {
                                   if(this.casePrecedente.getAbscisse()-this.getX()<0){
                                       
                                    }else{
                                       
                                    }
                                   
                               }
                               break;
                       }
                   }
        //      - type monstre, PionJoueur cases interdite
        //      - type obstacle switch en fonction du type
        //          - deplacer PionJoueur ou obstacle
    }
    
    @Override
    public void deplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
