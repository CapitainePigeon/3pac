package metier.librairie;


import static metier.librairie.Entite.Dir.*;

public class Grille {
    private Case[][] tab;

    public Case[][] getTab() {
        return tab;
    }

    public Case getTab( int ligne, int colone) {
        //if(ligne>=0 && colone>=0 && ligne<tab.length && colone<tab[0].length)

        return tab[ligne][colone];

        //return null;
    }

    public void setTab(Case laCase, int Lignes, int Colones) {
        this.tab[Lignes][Colones] = laCase;
    }

    public Grille(int nbLignes, int nbColones) {
        tab = new Case[nbLignes][nbColones];
    }
    public void setCouloirs(){
        for(int ligne = 1; ligne < tab.length-1; ligne++) {
            for (int colone = 1; colone < tab[0].length-1; colone++) {
                if (!tab[ligne][colone].isWall())
                {
                    if(!tab[ligne-1][colone].isWall()){
                        tab[ligne][colone].setVoisin(tab[ligne-1][colone],haut);
                    }
                    if(!tab[ligne+1][colone].isWall()){
                        tab[ligne][colone].setVoisin(tab[ligne+1][colone],bas);
                    }
                    if(!tab[ligne][colone-1].isWall()){
                        tab[ligne][colone].setVoisin(tab[ligne][colone-1],gauche);
                    }
                    if(!tab[ligne][colone+1].isWall()){
                        tab[ligne][colone].setVoisin(tab[ligne][colone+1],droite);
                    }
                }
            }
        }
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
