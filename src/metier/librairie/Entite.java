package metier.librairie;



public abstract class Entite implements Runnable {
    public enum Dir {
        bas,
        haut,
        gauche,
        droite;
    }
    protected Dir direction;
    protected int x,y;

    public void changeDir(Dir dir){
        direction=dir;
    }

    public String toString(){
        return " ";
    }
}
