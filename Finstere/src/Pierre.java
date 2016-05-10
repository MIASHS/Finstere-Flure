/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel, Sébastien, Valère
 */

/*
        Cette classe permet de créer et de gérer les Pierre individuellement et 
        même leur déplacements.
*/
public class Pierre extends Obstacle {
    //attributs
    // Conserve le plateau pour y avoir plus facilement assez
    private Plateau monPlateau;
    // Conserve la case précédente lors des déplacements
    private Cases casePrecedente;
    //Constructor
    public Pierre(int x, int y) {
        super(x, y);
    }
    //Methods
    //Vérifier que la case soit dans le plateau et non occupé.
    public boolean verifier(Cases cas){
        if(((cas.getAbscisse()>-1&&cas.getOrdonnee()<1&&cas.getAbscisse()<12&&cas.getOrdonnee()>-7)||(cas.getAbscisse()<16&&cas.getOrdonnee()>-11&&cas.getAbscisse()>3&&cas.getOrdonnee()<-3)||(cas.getAbscisse()<15&&cas.getOrdonnee()>-10&&cas.getAbscisse()>2&&cas.getOrdonnee()<-2)||(cas.getAbscisse()<14&&cas.getOrdonnee()>-9&&cas.getAbscisse()>1&&cas.getOrdonnee()<-1)||(cas.getAbscisse()<13&&cas.getOrdonnee()>-8&&cas.getAbscisse()>0&&cas.getOrdonnee()<0))&&!(cas.getPioncase() instanceof Monstre)&&!(cas.getPioncase() instanceof PionJoueur)&&!(cas.getPioncase() instanceof Pierre)&&!(cas.getPioncase() instanceof Flaque)){
            return true;
        }else{
            return false;
        }
        
    }
    //Déplace la pierre sur le plateau 
    public void deplacer(int o,Plateau p,Pions pion){
        this.casePrecedente=p.getCase(this.getX(), this.getY());
        // si premier déplacement, on stocke le plateau.
        if(monPlateau==null){
            monPlateau=p;
        }
        
        Cases c1;
        int i=0;
        // on supprime la case du plateau pour éviter les doublon 
        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
        // on déplace la pierre en fonction de l'orientation
        switch(o){
            case 1:
                c1 =p.getCase(this.getX(),this.getY()+1);
                if(this.verifier(c1)){
                    this.setY(c1.getOrdonnee());
                    c1.setPioncase(this);
                    c1.setOccupee(true);
                    p.ajouterCase(c1);
                }else{
                    if(!((c1.getAbscisse()>-1&&c1.getOrdonnee()<1&&c1.getAbscisse()<12&&c1.getOrdonnee()>-7)||(c1.getAbscisse()<16&&c1.getOrdonnee()>-11&&c1.getAbscisse()>3&&c1.getOrdonnee()<-3)||(c1.getAbscisse()<15&&c1.getOrdonnee()>-10&&c1.getAbscisse()>2&&c1.getOrdonnee()<-2)||(c1.getAbscisse()<14&&c1.getOrdonnee()>-9&&c1.getAbscisse()>1&&c1.getOrdonnee()<-1)||(c1.getAbscisse()<13&&c1.getOrdonnee()>-8&&c1.getAbscisse()>0&&c1.getOrdonnee()<0))){
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                    }else if((c1.getPioncase()!=null)){
                        switch(c1.getPioncase().getClass().getName()){
                        case "Monstre":
                                    
                                break;
                            case "Pierre":
                                if(pion instanceof Monstre){
                                    
                                    ((Pierre)c1.getPioncase()).deplacer(o, p, this);
                                    p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                }
                                break;
                            case "Flaque":
                                p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                this.setY(this.getY()+(1));
                                ((Flaque)c1.getPioncase()).deplacerPion(this);
                                break;
                            case "PionJoueur":
                                
                                if(pion instanceof Monstre){
                                    ((PionJoueur)c1.getPioncase()).deplacer(p, p.getCase(this.getX()+1,this.getY()));
                                    p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                }
                                
                                break;
                            default:
                                break;
                           
                        }
                    }
                }
                break;
            case 2:
                
                c1 = p.getCase(this.getX()-1,this.getY());
                if(this.verifier(c1)){
                    this.setX(c1.getAbscisse());
                    c1.setPioncase(this);
                    c1.setOccupee(true);
                    p.ajouterCase(c1);
                    
                }else{
                    if(!((c1.getAbscisse()>-1&&c1.getOrdonnee()<1&&c1.getAbscisse()<12&&c1.getOrdonnee()>-7)||(c1.getAbscisse()<16&&c1.getOrdonnee()>-11&&c1.getAbscisse()>3&&c1.getOrdonnee()<-3)||(c1.getAbscisse()<15&&c1.getOrdonnee()>-10&&c1.getAbscisse()>2&&c1.getOrdonnee()<-2)||(c1.getAbscisse()<14&&c1.getOrdonnee()>-9&&c1.getAbscisse()>1&&c1.getOrdonnee()<-1)||(c1.getAbscisse()<13&&c1.getOrdonnee()>-8&&c1.getAbscisse()>0&&c1.getOrdonnee()<0))){
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                    }else if((c1.getPioncase()!=null)){
                        switch(c1.getPioncase().getClass().getName()){
                            case "Monstre":
                                    
                                break;
                            case "Pierre":
                                if(pion instanceof Monstre){
                                    
                                    ((Pierre)c1.getPioncase()).deplacer(o, p, this);
                                    p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                }
                                break;
                            case "Flaque":
                                p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                this.setX(this.getX()-(1));
                                ((Flaque)c1.getPioncase()).deplacerPion(this);
                                break;
                            case "PionJoueur":
                                
                                if(pion instanceof Monstre){
                                    ((PionJoueur)c1.getPioncase()).deplacer(p, p.getCase(this.getX()-1,this.getY()));
                                    p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                }
                                
                                break;
                            default:
                                break;
                           
                        }
                    }
                }
                
                break;
            case 3:
                c1 = p.getCase(this.getX()+1,this.getY());
                if(this.verifier(c1)){
                    this.setX(c1.getAbscisse());
                    c1.setPioncase(this);
                    c1.setOccupee(true);
                    p.ajouterCase(c1);
                }else{
                    if(!((c1.getAbscisse()>-1&&c1.getOrdonnee()<1&&c1.getAbscisse()<12&&c1.getOrdonnee()>-7)||(c1.getAbscisse()<16&&c1.getOrdonnee()>-11&&c1.getAbscisse()>3&&c1.getOrdonnee()<-3)||(c1.getAbscisse()<15&&c1.getOrdonnee()>-10&&c1.getAbscisse()>2&&c1.getOrdonnee()<-2)||(c1.getAbscisse()<14&&c1.getOrdonnee()>-9&&c1.getAbscisse()>1&&c1.getOrdonnee()<-1)||(c1.getAbscisse()<13&&c1.getOrdonnee()>-8&&c1.getAbscisse()>0&&c1.getOrdonnee()<0))){
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                    }else if(c1.getPioncase()!=null){
                        switch(c1.getPioncase().getClass().getName()){
                            case "Monstre":
                                    
                                break;
                            case "Pierre":
                                if(pion instanceof Monstre){
                                    
                                    ((Pierre)c1.getPioncase()).deplacer(o, p, this);
                                    p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                }
                                break;
                            case "Flaque":
                                p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                this.setX(this.getX()+(1));
                                ((Flaque)c1.getPioncase()).deplacerPion(this);
                                break;
                            case "PionJoueur":
                                
                                if(pion instanceof Monstre){
                                    ((PionJoueur)c1.getPioncase()).deplacer(p, p.getCase(this.getX()+1,this.getY()));
                                    p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                }
                                
                                break;
                            default:
                                break;
                        }   
                    }
                }
                break;
            case 4:
                c1 = p.getCase(this.getX(),this.getY()-1);
                if(this.verifier(c1)){
                    this.setY(c1.getOrdonnee());
                    c1.setPioncase(this);
                    c1.setOccupee(true);
                    p.ajouterCase(c1);
                }else{
                    if(!((c1.getAbscisse()>-1&&c1.getOrdonnee()<1&&c1.getAbscisse()<12&&c1.getOrdonnee()>-7)||(c1.getAbscisse()<16&&c1.getOrdonnee()>-11&&c1.getAbscisse()>3&&c1.getOrdonnee()<-3)||(c1.getAbscisse()<15&&c1.getOrdonnee()>-10&&c1.getAbscisse()>2&&c1.getOrdonnee()<-2)||(c1.getAbscisse()<14&&c1.getOrdonnee()>-9&&c1.getAbscisse()>1&&c1.getOrdonnee()<-1)||(c1.getAbscisse()<13&&c1.getOrdonnee()>-8&&c1.getAbscisse()>0&&c1.getOrdonnee()<0))){
                        p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                    }else if((c1.getPioncase()!=null)){// instanceof Flaque)||p.getCase(this.getX()+1,this.getY()).getPioncase() instanceof Pierre){
                        switch(c1.getPioncase().getClass().getName()){
                            case "Monstre":
                                
                                break;
                            case "Pierre":
                                if(pion instanceof Monstre){
                                    ((Pierre)c1.getPioncase()).deplacer(o, p, this);
                                    p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                }
                                break;
                            case "Flaque":
                                
                                p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                this.setY(this.getY()-(1));
                                ((Flaque)c1.getPioncase()).deplacerPion(this);
                                break;
                            case "PionJoueur":
                                if(pion instanceof Monstre){
                                    ((PionJoueur)c1.getPioncase()).deplacer(p, p.getCase(this.getX(),this.getY()-1));
                                    p.getPlateau().remove(p.getCase(this.getX(),this.getY()));
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
            
            default:
                break;
        }
    }
    
    
    //Getter Setter
    
    public Plateau getMonPlateau(){
        return this.monPlateau;
    }
    
    public Cases getCasePrecedente(){
        return this.casePrecedente;
    }
}
