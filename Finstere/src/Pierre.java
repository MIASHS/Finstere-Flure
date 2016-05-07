/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Pierre extends Obstacle {
    
    public Pierre(int x, int y) {
        super(x, y);
    }
    public boolean verifier(Cases cas){
        
        if(((cas.getAbscisse()>-1&&cas.getOrdonnee()<1&&cas.getAbscisse()<12&&cas.getOrdonnee()>-7)||(cas.getAbscisse()<16&&cas.getOrdonnee()>-11&&cas.getAbscisse()>3&&cas.getOrdonnee()<-3)||(cas.getAbscisse()<15&&cas.getOrdonnee()>-10&&cas.getAbscisse()>2&&cas.getOrdonnee()<-2)||(cas.getAbscisse()<14&&cas.getOrdonnee()>-9&&cas.getAbscisse()>1&&cas.getOrdonnee()<-1)||(cas.getAbscisse()<13&&cas.getOrdonnee()>-8&&cas.getAbscisse()>0&&cas.getOrdonnee()<0))&&!(cas.getPioncase() instanceof Monstre)&&!(cas.getPioncase() instanceof PionJoueur)&&!(cas.getPioncase() instanceof Pierre)&&!(cas.getPioncase() instanceof Flaque)){
            return true;
            
        }else{
            return false;
        }
        
    }
    public void deplacer(int o,Plateau p){
        int i=0;
        switch(o){
            case 1:
                if(this.verifier(p.getCase(this.getX(),this.getY()+1))){
                    p.getCase(this.getX(),this.getY()).setOrdonnee(this.getY()+1);
                    this.setY(this.getY()+1);
                    
                }else{
                    if(!((p.getCase(this.getX(),this.getY()+1).getAbscisse()>-1&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()<1&&p.getCase(this.getX(),this.getY()+1).getAbscisse()<12&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()>-7)||(p.getCase(this.getX(),this.getY()+1).getAbscisse()<16&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()>-11&&p.getCase(this.getX(),this.getY()+1).getAbscisse()>3&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()<-3)||(p.getCase(this.getX(),this.getY()+1).getAbscisse()<15&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()>-10&&p.getCase(this.getX(),this.getY()+1).getAbscisse()>2&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()<-2)||(p.getCase(this.getX(),this.getY()+1).getAbscisse()<14&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()>-9&&p.getCase(this.getX(),this.getY()+1).getAbscisse()>1&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()<-1)||(p.getCase(this.getX(),this.getY()+1).getAbscisse()<13&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()>-8&&p.getCase(this.getX(),this.getY()+1).getAbscisse()>0&&p.getCase(this.getX(),this.getY()+1).getOrdonnee()<0))){
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                    }else if((p.getCase(this.getX(),this.getY()+1).getPioncase() instanceof Flaque)||p.getCase(this.getX()+1,this.getY()).getPioncase() instanceof Pierre){
                        i=2;
                        Cases c = p.getCase(this.getX(),this.getY()+i);
                        while(!this.verifier(c)&&((this.getY()+i<1)||(this.getY()+i<-1&&this.getX()==12)||(this.getY()+i<-2&&this.getX()==13)||(this.getY()+i<-3&&this.getX()==14)||(this.getY()+i<-4&&this.getX()==15))){
                            c.setOrdonnee(this.getY()+i);
                            i++;
                        }
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                        this.setY(this.getY()+(i));
                        c.setPioncase(this);
                        c.setOccupee(true);
                        p.ajouterCase(c);
                    }
                }
                break;
            case 2:
                if(this.verifier(p.getCase(this.getX()-1,this.getY()))){
                    p.getCase(this.getX(),this.getY()).setAbscisse(this.getX()-1);
                    this.setX(this.getX()-1);
                    
                }else{
                    if(!((p.getCase(this.getX()-1,this.getY()).getAbscisse()>-1&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()<1&&p.getCase(this.getX()-1,this.getY()).getAbscisse()<12&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()>-7)||(p.getCase(this.getX()-1,this.getY()).getAbscisse()<16&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()>-11&&p.getCase(this.getX()-1,this.getY()).getAbscisse()>3&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()<-3)||(p.getCase(this.getX()-1,this.getY()).getAbscisse()<15&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()>-10&&p.getCase(this.getX()-1,this.getY()).getAbscisse()>2&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()<-2)||(p.getCase(this.getX()-1,this.getY()).getAbscisse()<14&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()>-9&&p.getCase(this.getX()-1,this.getY()).getAbscisse()>1&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()<-1)||(p.getCase(this.getX()-1,this.getY()).getAbscisse()<13&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()>-8&&p.getCase(this.getX()-1,this.getY()).getAbscisse()>0&&p.getCase(this.getX()-1,this.getY()).getOrdonnee()<0))){
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                    }else if((p.getCase(this.getX()-1,this.getY()).getPioncase() instanceof Flaque)||p.getCase(this.getX()+1,this.getY()).getPioncase() instanceof Pierre){
                        i=2;
                        Cases c = p.getCase(this.getX()-i,this.getY());
                        while(!this.verifier(c)&&((this.getX()-i>-1)||(this.getX()-i>0&&this.getY()==-7)||(this.getX()-i>1&&this.getY()==-8)||(this.getX()-i>2&&this.getY()==-9)||(this.getX()-i>3&&this.getY()==-10))){
                            c.setAbscisse(this.getX()-i);
                            i++;
                        }
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                        this.setX(this.getX()-(i));
                        c.setPioncase(this);
                        c.setOccupee(true);
                        p.ajouterCase(c);
                    }
                }
                
                break;
            case 3:
                if(this.verifier(p.getCase(this.getX()+1,this.getY()))){
                    p.getCase(this.getX(),this.getY()).setAbscisse(this.getX()+1);
                    this.setX(this.getX()+1);
                    
                }else{
                    if(!((p.getCase(this.getX()+1,this.getY()).getAbscisse()>-1&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()<1&&p.getCase(this.getX()+1,this.getY()).getAbscisse()<12&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()>-7)||(p.getCase(this.getX()+1,this.getY()).getAbscisse()<16&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()>-11&&p.getCase(this.getX()+1,this.getY()).getAbscisse()>3&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()<-3)||(p.getCase(this.getX()+1,this.getY()).getAbscisse()<15&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()>-10&&p.getCase(this.getX()+1,this.getY()).getAbscisse()>2&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()<-2)||(p.getCase(this.getX()+1,this.getY()).getAbscisse()<14&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()>-9&&p.getCase(this.getX()+1,this.getY()).getAbscisse()>1&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()<-1)||(p.getCase(this.getX()+1,this.getY()).getAbscisse()<13&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()>-8&&p.getCase(this.getX()+1,this.getY()).getAbscisse()>0&&p.getCase(this.getX()+1,this.getY()).getOrdonnee()<0))){
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                    }else if((p.getCase(this.getX()+1,this.getY()).getPioncase() instanceof Flaque)||p.getCase(this.getX()+1,this.getY()).getPioncase() instanceof Pierre){
                        i=2;
                        Cases c = p.getCase(this.getX()+i,this.getY());
                        while(!this.verifier(c)&&((this.getX()+i<16)||(this.getX()+i<12&&this.getY()==0)||(this.getX()+i<13&&this.getY()==-1)||(this.getX()+i<14&&this.getY()==-2)||(this.getX()+i<15&&this.getY()==-3))){
                            c.setAbscisse(this.getX()+i);
                            i++;
                        }
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                        this.setX(this.getX()+(i));
                        c.setPioncase(this);
                        c.setOccupee(true);
                        p.ajouterCase(c);
                    }
                    
                    
                }
                break;
            case 4:
                if(this.verifier(p.getCase(this.getX(),this.getY()-1))){
                    p.getCase(this.getX(),this.getY()).setOrdonnee(this.getY()-1);
                    this.setY(this.getY()-1);
                    
                }else{
                    if(!((p.getCase(this.getX(),this.getY()-1).getAbscisse()>-1&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()<1&&p.getCase(this.getX(),this.getY()-1).getAbscisse()<12&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()>-7)||(p.getCase(this.getX(),this.getY()-1).getAbscisse()<16&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()>-11&&p.getCase(this.getX(),this.getY()-1).getAbscisse()>3&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()<-3)||(p.getCase(this.getX(),this.getY()-1).getAbscisse()<15&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()>-10&&p.getCase(this.getX(),this.getY()-1).getAbscisse()>2&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()<-2)||(p.getCase(this.getX(),this.getY()-1).getAbscisse()<14&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()>-9&&p.getCase(this.getX(),this.getY()-1).getAbscisse()>1&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()<-1)||(p.getCase(this.getX(),this.getY()-1).getAbscisse()<13&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()>-8&&p.getCase(this.getX(),this.getY()-1).getAbscisse()>0&&p.getCase(this.getX(),this.getY()-1).getOrdonnee()<0))){
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                    }else if((p.getCase(this.getX(),this.getY()-1).getPioncase() instanceof Flaque)||p.getCase(this.getX()+1,this.getY()).getPioncase() instanceof Pierre){
                        i=2;
                        Cases c = p.getCase(this.getX(),this.getY()-i);
                        while(!this.verifier(c)&&((this.getY()+i>-11)||(this.getY()+i>-7&&this.getX()==0)||(this.getY()+i>-8&&this.getX()==1)||(this.getY()+i>-9&&this.getX()==2)||(this.getY()+i>-10&&this.getX()==3))){
                            c.setOrdonnee(this.getY()-i);
                            i++;
                        }
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                        this.setY(this.getY()-(i));
                        c.setPioncase(this);
                        c.setOccupee(true);
                        p.ajouterCase(c);
                    }
                }
                break;
        
        }
        for(Cases c2: p.getPlateau()){
            System.out.println(c2.getPioncase().getClass().getName()+": ("+c2.getAbscisse()+";"+c2.getOrdonnee()+") > ("+c2.getPioncase().getX()+";"+c2.getPioncase().getY()+")");
        }
    }
}
