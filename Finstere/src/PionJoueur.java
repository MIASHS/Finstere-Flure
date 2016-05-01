
import java.util.ArrayList;
import java.util.HashSet;

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

        
        
        private boolean mort=false; //booléen indiquant si un pion d'un joueur est mort
        private boolean utilise=false;
        private boolean onBoard=false;
        private int[] tabNumDispo= new int[2];
        private int numActuel=0;
        private HashSet<Cases> coupPossible=new HashSet<>();
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
        public int getNum(int i){
        return tabNumDispo[i];
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
        
        public HashSet<Cases> getCoupPossible(){
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
        // num = numéro actuel sur le pion joueur 
        
        public boolean isOnBoard(){
            return onBoard;
        }
        
        public ArrayList<Cases> searchCoupPossible(Plateau monPlateau, int num){
            
        
            
            ArrayList<Cases> listProvisoire=new ArrayList<>();
            if(!this.isOnBoard()){
                num-=1;
                this.setX(15);
                this.setY(-10);
                if(!monPlateau.getCase(15, -10).isOccupee()){
                    listProvisoire.add(new Cases(this.getX(),this.getY(),false,null));
                }
                
            }
                for(int j=0;j<num;j++){
                        int numcopie=num-j;
                        for(int i=1;i<numcopie;i++){
                           listProvisoire.add(new Cases(this.getX()+i,this.getY()+j,false));
                        }
                }
                
                for(int j=0;j<num;j++){
                        int numcopie=j-num;
                        for(int i=0;i>numcopie;i--){
                           listProvisoire.add(new Cases(this.getX()+i,this.getY()+j,false));
                        }
                }
                
                for(int j=0;j>-num;j--){
                        int numcopie=j-num;
                        
                        for(int i=-1;i>numcopie;i--){
                            
                           listProvisoire.add(new Cases(this.getX()+i,this.getY()+j,false));
                        }
                }
                
                for(int j=0;j>-num;j--){
                        int numcopie=num-j;
                        for(int i=0;i<numcopie;i++){
                           listProvisoire.add(new Cases(this.getX()+i,this.getY()+j,false));
                        }
                }
                
                
                
            
            while(!listProvisoire.isEmpty()){
                if(((listProvisoire.get(0).getAbscisse()>-1&&listProvisoire.get(0).getOrdonnee()<1&&listProvisoire.get(0).getAbscisse()<12&&listProvisoire.get(0).getOrdonnee()>-7)||(listProvisoire.get(0).getAbscisse()<16&&listProvisoire.get(0).getOrdonnee()>-11&&listProvisoire.get(0).getAbscisse()>5&&listProvisoire.get(0).getOrdonnee()<-5)||(listProvisoire.get(0).getAbscisse()<15&&listProvisoire.get(0).getOrdonnee()>-10&&listProvisoire.get(0).getAbscisse()>4&&listProvisoire.get(0).getOrdonnee()<-4)||(listProvisoire.get(0).getAbscisse()<14&&listProvisoire.get(0).getOrdonnee()>-9&&listProvisoire.get(0).getAbscisse()>3&&listProvisoire.get(0).getOrdonnee()<-3)||(listProvisoire.get(0).getAbscisse()<13&&listProvisoire.get(0).getOrdonnee()>-8&&listProvisoire.get(0).getAbscisse()>2&&listProvisoire.get(0).getOrdonnee()<-2))&&!(listProvisoire.get(0).getPioncase() instanceof Monstre)&&!(listProvisoire.get(0).getPioncase() instanceof PionJoueur)){
                        this.verifierCase(monPlateau, listProvisoire.get(0));
                       coupPossible.add(listProvisoire.get(0));
                       
                }
                listProvisoire.remove(0);
            }
            ArrayList<Cases> listFinal=new ArrayList<>();
            listFinal.addAll(coupPossible);
            
        
            return listFinal;
        }
        public Cases getCasePrecedente(){
            return this.casePrecedente;
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
            this.verifierCase(monPlateau, cas);
            monPlateau.ajouterCase(cas);
            
        }

    public void verifierCase(Plateau monPlateau, Cases c){
        // verifier la case precedente switch en fonction de l'orientation
        // 
        // verifier si la case ne contient pas déjà objet :
        
            if((c.getPioncase() instanceof Flaque)&&(c.getPioncase() instanceof Pierre)){
                       switch(c.getPioncase().getClass().getName()){
                           case "Flaque":
                               if(this.casePrecedente.getAbscisse()-this.getX()==0){
                                   if(this.casePrecedente.getOrdonnee()-this.getY()<0){
                                       this.setY(this.getY()+1);
                                       this.deplacer(monPlateau,monPlateau.getCase(this.getX(), this.getY()));
                                    }else{
                                       this.setY(this.getY()-1);
                                       this.deplacer(monPlateau,monPlateau.getCase(this.getX(), this.getY()));
                                    }
                                   
                               }else {
                                   if(this.casePrecedente.getAbscisse()-this.getX()<0){
                                       this.setX(this.getX()+1);
                                       this.deplacer(monPlateau,monPlateau.getCase(this.getX(), this.getY()));
                                    }else{
                                       this.setX(this.getX()+1);
                                       this.deplacer(monPlateau,monPlateau.getCase(this.getX(), this.getY()));
                                    }
                                   
                               }
                               break;
                           case "Pierre":
                               if(this.casePrecedente.getAbscisse()-this.getX()==0){
                                   if(this.casePrecedente.getOrdonnee()-this.getY()<0){
                                       
                                       if(c.getPioncase().verifier(monPlateau.getCase(c.getPioncase().getX(),c.getOrdonnee()+1))){
                                           c.getPioncase().setY(c.getPioncase().getY()+1);
                                           this.setY(this.getY()+1);
                                           this.deplacer(monPlateau,monPlateau.getCase(this.getX(), this.getY()));
                                       }
                                       
                                    }else{
                                       
                                       if(c.getPioncase().verifier(monPlateau.getCase(c.getPioncase().getX(),c.getOrdonnee()-1))){
                                       c.getPioncase().setY(c.getPioncase().getY()-1);
                                           this.setY(this.getY()-1);
                                           this.deplacer(monPlateau,monPlateau.getCase(this.getX(), this.getY()));
                                       }
                                       
                                    }
                                   
                               }else {
                                   if(this.casePrecedente.getAbscisse()-this.getX()<0){
                                       
                                       if(c.getPioncase().verifier(monPlateau.getCase(c.getPioncase().getX()+1,c.getOrdonnee()))){
                                       c.getPioncase().setX(c.getPioncase().getX()+1);
                                           this.setX(this.getX()+1);
                                           this.deplacer(monPlateau,monPlateau.getCase(this.getX(), this.getY()));
                                       }
                                       
                                    }else{
                                       
                                       if(c.getPioncase().verifier(monPlateau.getCase(c.getPioncase().getX()-1,c.getOrdonnee()))){
                                       c.getPioncase().setX(c.getPioncase().getX()-1);
                                           this.setX(this.getX()-1);
                                           this.deplacer(monPlateau,monPlateau.getCase(this.getX(), this.getY()));
                                       }
                                       
                                    }
                                  
                               }
                               break;
                       }
                    }else{
                        this.setX(c.getAbscisse());
                        this.setY(c.getOrdonnee());
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
