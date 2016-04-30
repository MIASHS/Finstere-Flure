
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oneiroi
 */
public class Outils {
    public static char convertCoorToChar(int a,int o,int k){
        char c=' ';
        if(o==0){
            switch(a){
                case 0:
                    c='*';
                    break;
                case -1:
                    c='z';
                    break;
                case -2:
                    c='y';
                    break;
                case -3:
                    c='x';
                    break;
                case -4:
                    c='w';
                    break;
                case -5:
                    c='v';
                    break;
                case -6:
                    c='u';
                    break;
                default:
                    break;
            }
        }else if(o==15){
            switch(a){
                case -4:
                    c='u';
                    break;
                case -5:
                    c='v';
                    break;
                case -6:
                    c='w';
                    break;
                case -7:
                    c='x';
                    break;
                case -8:
                    c='y';
                    break;
                case -9:
                    c='z';
                    break;
                case -10:
                    c='*';
                    break;
                default:
                    break;
        
            }
        }
        if(a==0&&c==' '){
            switch(o){
                case 0:
                    c='a';
                    break;
                case 1:
                    c='b';
                    break;
                case 2:
                    c='c';
                    break;
                case 3:
                    c='d';
                    break;
                case 4:
                    c='e';
                    break;
                case 5:
                    c='f';
                    break;
                case 6:
                    c='g';
                    break;
                case 7:
                    c='h';
                    break;
                case 8:
                    c='i';
                    break;
                case 9:
                    c='j';
                    break;
                case 10:
                    c='k';
                    break;
                case 11:
                    c='l';
                    break;
                default:
                    break;

            }
        }else if(a==10&&c==' '){
            switch(o){
                case 4:
                    c='l';
                    break;
                case 5:
                    c='k';
                    break;
                case 6:
                    c='j';
                    break;
                case 7:
                    c='i';
                    break;
                case 8:
                    c='h';
                    break;
                case 9:
                    c='g';
                    break;
                case 10:
                    c='f';
                    break;
                case 11:
                    c='e';
                    break;
                case 12:
                    c='d';
                    break;
                case 13:
                    c='c';
                    break;
                case 14:
                    c='b';
                    break;
                case 15:
                    c='a';
                    break;
                default:
                    break;
            }
        }
        if(c==' '){
            switch(convertCoorToInt(a,o)){
                case 13:
                    if(k==1){c='m';}else if(k==2){c='n';}
                    break;
                case 27:
                    if(k==1){c='o';}else if(k==2){c='p';}
                    break;
                case 41:
                    if(k==1){c='q';}else if(k==2){c='r';}
                    break;
                case 55:
                    if(k==1){c='s';}else if(k==2){c='t';}
                    break;
                case 112:
                    if(k==3){c='t';}else if(k==4){c='s';}
                    break;
                case 128:
                    if(k==3){c='r';}else if(k==4){c='q';}
                    break;
                case 145:
                    if(k==3){c='p';}else if(k==4){c='o';}
                    break;
                case 162:
                    if(k==3){c='n';}else if(k==4){c='m';}
                    break;      
            }
        }
        return c;
    }
    public static int convertCoorToInt(int a,int o){
        return (a*16 + o);
    }
    
    public static void convertChartoCoor(char c, Pions p){
        switch(c){
            case '*':
                if(p.getX()==0&&p.getY()==0){
                    p.setX(15);
                    p.setY(-10);
                }else{
                    p.setX(0);
                    p.setY(0);
                }
                break;
            case 'a':
                if(p.getX()==0&&p.getY()==0){
                    p.setX(15);
                    p.setY(-10);
                }else{
                    p.setX(0);
                    p.setY(0);
                }
                break;
            case 'b':
                if(p.getX()==1&&p.getY()==0){
                    p.setX(14);
                    p.setY(-10);
                }else{
                    p.setX(1);
                    p.setY(0);
                }
                break;
            case 'c':
                if(p.getX()==2&&p.getY()==0){
                    p.setX(13);
                    p.setY(-10);
                }else{
                    p.setX(2);
                    p.setY(0);
                }
                break;
            case 'd':
                if(p.getX()==3&&p.getY()==0){
                    p.setX(12);
                    p.setY(-10);
                }else{
                    p.setX(3);
                    p.setY(0);
                }
                break;
            case 'e':
                if(p.getX()==4&&p.getY()==0){
                    p.setX(11);
                    p.setY(-10);
                }else{
                    p.setX(4);
                    p.setY(0);
                }
                break;
            case 'f':
                if(p.getX()==5&&p.getY()==0){
                    p.setX(10);
                    p.setY(-10);
                }else{
                    p.setX(5);
                    p.setY(0);
                }
                break;
            case 'g':
                if(p.getX()==6&&p.getY()==0){
                    p.setX(9);
                    p.setY(-10);
                }else{
                    p.setX(6);
                    p.setY(0);
                }
                break;
            case 'h':
                if(p.getX()==7&&p.getY()==0){
                    p.setX(8);
                    p.setY(-10);
                }else{
                    p.setX(7);
                    p.setY(0);
                }
                break;
            case 'i':
                if(p.getX()==8&&p.getY()==0){
                    p.setX(7);
                    p.setY(-10);
                }else{
                    p.setX(8);
                    p.setY(0);
                }
                break;
            case 'j':
                if(p.getX()==9&&p.getY()==0){
                    p.setX(6);
                    p.setY(-10);
                }else{
                    p.setX(9);
                    p.setY(0);
                }
                break;
            case 'k':
                if(p.getX()==10&&p.getY()==0){
                    p.setX(5);
                    p.setY(-10);
                }else{
                    p.setX(10);
                    p.setY(0);
                }
                break;
            case 'l':
                if(p.getX()==11&&p.getY()==0){
                    p.setX(4);
                    p.setY(-10);
                }else{
                    p.setX(11);
                    p.setY(0);
                }
                break;
            case 'm':
                if(p.getX()==12&&p.getY()==0){
                    p.setX(3);
                    p.setY(-10);
                }else{
                    p.setX(12);
                    p.setY(0);
                }
                break;
            case 'n':
                if(p.getX()==12&&p.getY()==0){
                    p.setX(3);
                    p.setY(-10);
                }else{
                    p.setX(12);
                    p.setY(0);
                }
                break;
            case 'o':
                if(p.getX()==13&&p.getY()==-1){
                    p.setX(2);
                    p.setY(-9);
                }else{
                    p.setX(13);
                    p.setY(-1);
                }
                break;
            case 'p':
                if(p.getX()==13&&p.getY()==-1){
                    p.setX(2);
                    p.setY(-9);
                }else{
                    p.setX(13);
                    p.setY(-1);
                }
                break;
            case 'q':
                if(p.getX()==14&&p.getY()==-2){
                    p.setX(1);
                    p.setY(-8);
                }else{
                    p.setX(14);
                    p.setY(-2);
                }
                break;
            case 'r':
                if(p.getX()==14&&p.getY()==-2){
                    p.setX(1);
                    p.setY(-8);
                }else{
                    p.setX(14);
                    p.setY(-2);
                }
                break;
            case 's':
                if(p.getX()==15&&p.getY()==-3){
                    p.setX(0);
                    p.setY(-7);
                }else{
                    p.setX(15);
                    p.setY(-3);
                }
                break;
            case 't':
                if(p.getX()==15&&p.getY()==-3){
                    p.setX(0);
                    p.setY(-7);
                }else{
                    p.setX(15);
                    p.setY(-3);
                }
                break;
            case 'u':
                if(p.getX()==15&&p.getY()==-4){
                    p.setX(0);
                    p.setY(-6);
                }else{
                    p.setX(15);
                    p.setY(-4);
                }
                break;
            case 'v':
                if(p.getX()==15&&p.getY()==-5){
                    p.setX(0);
                    p.setY(-5);
                }else{
                    p.setX(15);
                    p.setY(-5);
                }
                break;
            case 'w':
                if(p.getX()==15&&p.getY()==-6){
                    p.setX(0);
                    p.setY(-4);
                }else{
                    p.setX(15);
                    p.setY(-6);
                }
                break;
            case 'x':
                if(p.getX()==15&&p.getY()==-7){
                    p.setX(0);
                    p.setY(-3);
                }else{
                    p.setX(15);
                    p.setY(-7);
                }
                break;
            case 'y':
                if(p.getX()==15&&p.getY()==-8){
                    p.setX(0);
                    p.setY(-2);
                }else{
                    p.setX(15);
                    p.setY(-8);
                }
                break;
            case 'z':
                if(p.getX()==15&&p.getY()==-9){
                    p.setX(0);
                    p.setY(-1);
                }else{
                    p.setX(15);
                    p.setY(-9);
                }
                break;
            default:
                break;
                
                
        }
    }
    
     public static char conversionCaractere(char lettre){
        return Character.toUpperCase(lettre);
    }
    
     
        public static char verification(String str, int choix){
        str = str.toUpperCase();
        Scanner sc=new Scanner(System.in);
        char[] lettres = str.toCharArray();
        if(choix==1) {
                    // tant que le joueur ne saisit pas une chaîne valide
                    while((str!="Y")||(str!="O")||(str!="YES")||(str!="OUI")||(str!="N")||(str!="NON")||(str!="NO")){
                        System.out.println("\nLa saisie est erronée veuillez réessayer. \n Entrez une réponse (O/N):");
                        Outils.verification(sc.next(),1);
                    }
                    return lettres[0];
                    
        }else{
                  //si les caractères entrés ne sont pas entre A et Z
                  while(lettres[0]<'A' && lettres[0]>'Z'){
                      System.out.println("\nLa saisie est erronée veuillez réessayer. \n Entrez votre choix:");    
                      Outils.verification(sc.next(),0);
                  }
                  return lettres[0];
                  
        }     
    }
    
     //Méthode qui affiche les différents menu et confirmations de choix.
    public static char afficher(int niveau, Jeu partieActuelle){
        Scanner sc=new Scanner(System.in);
        switch (niveau) {
            case 0:     System.out.println("\nDemarrer(D)\nQuitter(Q)\nMenu(S)");
                        System.out.println("\nQuel est votre choix ?\n");
                
                        return Outils.verification(sc.next(),0);
                
             case 1:    System.out.println("\nMenu 1(D)\nRetour(R)\nQuitter(Q)");
                        System.out.println("\nQuel est votre choix ?\n");
                
                        return Outils.verification(sc.next(),0);
        }
        return 'e';
    }
    
      public static void afficherTexte(String s){
           System.out.print(""+s+"");
    }
    
    
}
