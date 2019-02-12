package librairie;

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


}
