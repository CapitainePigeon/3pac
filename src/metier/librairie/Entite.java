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
