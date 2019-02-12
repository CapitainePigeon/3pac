package librairie.entites;


import java.util.Observable;

public abstract class Entite extends Observable {
    private enum Dir {
        bas,
        haut,
        gauche,
        droite;
    }

    boolean deplacer(String dir){
        Dir dir1;
        return false;
    }
    public String toString(){
        return " ";
    }
}
