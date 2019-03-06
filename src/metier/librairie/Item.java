package metier.librairie;


public abstract class Item {

    public String toString(){
        return " ";
    }
    public String getFileImg(){
        return "couloir.png";
    }
    public abstract boolean utiliser(Entite entite);
}
