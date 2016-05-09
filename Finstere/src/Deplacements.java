/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel, Valère, Sébastien
 */

/*
    L'interface Déplacements est la seule interface du jeu. Elle sert à déplacer les pions sur le plateau.
    Elle est implémentée dans toutes les classes qui ont besoin de se déplacer.
*/
public interface Deplacements {
    public final int haut=1;
    public final int bas=4;
    public final int gauche=2;
    public final int droite=3;
    
    public void deplacer(int o);
    public void deplacerPion(Pions p);
}
