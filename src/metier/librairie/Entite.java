package metier.librairie;


import java.util.Observable;

public abstract class Entite extends Observable implements Runnable {
    public enum Dir {
        bas,
        haut,
        gauche,
        droite;
    }
    protected Dir direction;
    public Case caseOccupe;
    public abstract boolean interagir(Entite entite);
    public void changeDir(Dir dir){
        direction=dir;
    }

    public String toString(){
        return " ";
    }

    public String getFileImg(){
        return "couloir.png";
    }
}
