
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Plateau {
    
    //à compléter
    private ArrayList<Cases> monPlateau;
    private ArrayList<Pions> tabPionsAPlacer;
    
    public Plateau(){
        monPlateau=new ArrayList<>();
        tabPionsAPlacer=new ArrayList<>();
        //this.init(partie);
    }
    
    public void ajouterList(Pions p){
        tabPionsAPlacer.add(p);
    }
    
    /*public void init(Jeu partie){
        
    }*/
    
    public ArrayList<Cases> getPlateau(){
        return monPlateau;
    }
    
    public void placerObstacle(){
        while(!tabPionsAPlacer.isEmpty()){
            
            if(tabPionsAPlacer.get(0).getClass().getName()=="Flaque"){
                Flaque f=(Flaque)tabPionsAPlacer.get(0);
                switch(f.getType()){
                    case 0:
                        this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY(),true,tabPionsAPlacer.get(0),true,(Flaque)tabPionsAPlacer.get(0)));
                        this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX()+1,tabPionsAPlacer.get(0).getY(),true,new Flaque(tabPionsAPlacer.get(0).getX()+1,tabPionsAPlacer.get(0).getY(),0,false),true,new Flaque(tabPionsAPlacer.get(0).getX()+1,tabPionsAPlacer.get(0).getY(),0,false)));
                        this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY(),true,new Flaque(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY()-1,0,false),true,new Flaque(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY()-1,0,false)));
                        this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY(),true,new Flaque(tabPionsAPlacer.get(0).getX()+1,tabPionsAPlacer.get(0).getY()-1,0,false),true,new Flaque(tabPionsAPlacer.get(0).getX()+1,tabPionsAPlacer.get(0).getY()-1,0,false)));
                        break;
                    case 1:
                        this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY(),true,tabPionsAPlacer.get(0),true,(Flaque)tabPionsAPlacer.get(0)));
                        this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX()+1,tabPionsAPlacer.get(0).getY(),true,new Flaque(tabPionsAPlacer.get(0).getX()+1,tabPionsAPlacer.get(0).getY(),1,false),true,new Flaque(tabPionsAPlacer.get(0).getX()+1,tabPionsAPlacer.get(0).getY(),1,false)));
                        this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY(),true,new Flaque(tabPionsAPlacer.get(0).getX()+2,tabPionsAPlacer.get(0).getY(),1,false),true,new Flaque(tabPionsAPlacer.get(0).getX()+2,tabPionsAPlacer.get(0).getY(),1,false)));
                        this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY(),true,new Flaque(tabPionsAPlacer.get(0).getX()+3,tabPionsAPlacer.get(0).getY(),1,false),true,new Flaque(tabPionsAPlacer.get(0).getX()+3,tabPionsAPlacer.get(0).getY(),1,false)));
                        break;
                }
                
            }else if(tabPionsAPlacer.get(0).getClass().getName()=="Pierre"){
                this.ajouterCase(new Cases(tabPionsAPlacer.get(0).getX(),tabPionsAPlacer.get(0).getY(),true,tabPionsAPlacer.get(0)));
            }
            
            tabPionsAPlacer.remove(0);
        }
    }
    
    public void ajouterCase(Cases c){
        monPlateau.add(c);
    }
    
    public Cases getCase(int a,int o){
        boolean trouve=false;
        int i=0;
        Cases c=null;
        while(!trouve&&i>monPlateau.size()){
            if(monPlateau.get(i).getOrdonnee()==o&&monPlateau.get(i).getAbscisse()==a){
                trouve=true;
                c=monPlateau.get(i);
            }
            i++;
        }
        if(c==null){
            c=new Cases(a,o,false,null);
        }
        return c;
    }
    
    
}
