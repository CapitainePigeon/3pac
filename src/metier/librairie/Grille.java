package metier.librairie;

import metier.librairie.Case;

public class Grille {
    private Case[][] tab;

    public Case[][] getTab() {
        return tab;
    }

    public Case getTab( int Lignes, int Colones) {
        return tab[Lignes][Colones];
    }

    public void setTab(Case laCase, int Lignes, int Colones) {
        this.tab[Lignes][Colones] = laCase;
    }

    public Grille(int nbLignes, int nbColones) {
        tab = new Case[nbLignes][nbColones];
    }

    public String toString(){
        String sortie="";
        for(int i=0;i<tab.length;i++){
            for(int k=0;k<tab[i].length;k++){
                sortie+=("|"+tab[i][k]);
            }
            sortie+="\n";
        }
        return sortie;
    }
}
