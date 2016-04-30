
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaby
 */
public class IA {

    
    
    public void CoupPossibleIA(Plateau monPlateau, Jeu game, int num){
        
        ArrayList<Cases> listProvisoireIA = new ArrayList<>();
        
            for(int j=0;j<num;j++){
                        for(int i=1;i<(num-j);i++){
                           listProvisoireIA.add(new Cases(game.getMonstre().getX()+i,game.getMonstre().getY()+j,false));
                        }
                }
                
                for(int j=0;j<num;j++){
                        for(int i=-1;i<(j-num);i--){
                           listProvisoireIA.add(new Cases(game.getMonstre().getX()+i,game.getMonstre().getY()+j,false));
                        }
                }
                
                for(int j=0;j<-num;j--){
                        for(int i=-1;i<(j-num);i--){
                           listProvisoireIA.add(new Cases(game.getMonstre().getX()+i,game.getMonstre().getY()+j,false));
                        }
                }
                
                for(int j=0;j<-num;j--){
                        for(int i=1;i<(num-j);i++){
                           listProvisoireIA.add(new Cases(game.getMonstre().getX()+i,game.getMonstre().getY()+j,false));
                        }
                }
    
    
    }
    
}
