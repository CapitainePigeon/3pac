package metier.librairie;

import metier.librairie.Case;

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

    public boolean deplacer(Entite entite){
        //System.out.println(entite);
        try {
            switch(entite.direction){
                case bas :
                    if(!getTab(entite.x+1,entite.y).isWall()){
                        getTab(entite.x+1,entite.y).add(entite);
                        getTab(entite.x,entite.y).remove(entite);
                        getTab(entite.x,entite.y).aChangé();
                        getTab(entite.x+1,entite.y).aChangé();
                        entite.x=entite.x+1;
                    }
                    break;
                case haut :
                    if(!getTab(entite.x-1,entite.y).isWall()){
                        getTab(entite.x-1,entite.y).add(entite);
                        getTab(entite.x,entite.y).remove(entite);
                        getTab(entite.x,entite.y).aChangé();
                        getTab(entite.x-1,entite.y).aChangé();
                        entite.x=entite.x-1;
                    }
                    break;
                case gauche :

                    if(!getTab(entite.x,entite.y-1).isWall()){
                        getTab(entite.x,entite.y-1).add(entite);
                        getTab(entite.x,entite.y).remove(entite);
                        getTab(entite.x,entite.y).aChangé();
                        getTab(entite.x,entite.y-1).aChangé();
                        entite.y=entite.y-1;
                    }
                    break;
                case droite :

                    if(!getTab(entite.x,entite.y+1).isWall()){
                        getTab(entite.x,entite.y+1).add(entite);
                        getTab(entite.x,entite.y).remove(entite);
                        getTab(entite.x,entite.y).aChangé();
                        getTab(entite.x,entite.y+1).aChangé();
                        entite.y=entite.y+1;
                    }
                    break;
            }
        }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("ArrayIndexOutOfBoundsException ligne:"+entite.x+" colone :"+entite.y);
                return false;
        }
        return false;
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
