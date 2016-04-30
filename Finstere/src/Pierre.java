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
        
        if(((cas.getAbscisse()>=0&&cas.getOrdonnee()<=0&&cas.getAbscisse()<=10&&cas.getOrdonnee()>=-6)||(cas.getAbscisse()<=15&&cas.getOrdonnee()>=-10&&cas.getAbscisse()>=4&&cas.getOrdonnee()<=-4)||(cas.getAbscisse()<=14&&cas.getOrdonnee()>=-9&&cas.getAbscisse()>=3&&cas.getOrdonnee()<=-3)||(cas.getAbscisse()<=13&&cas.getOrdonnee()>=-8&&cas.getAbscisse()>=2&&cas.getOrdonnee()<=-2)||(cas.getAbscisse()<=12&&cas.getOrdonnee()>=-7&&cas.getAbscisse()>=1&&cas.getOrdonnee()<=-1))&&!(cas.getPioncase() instanceof Monstre)&&!(cas.getPioncase() instanceof PionJoueur)&&!(cas.getPioncase() instanceof Pierre)){
            return true;
            
        }else{
            return false;
        }
        
    }
}
