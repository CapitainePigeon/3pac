package metier.librairie;

import javafx.scene.image.ImageView;
import metier.jeuPacMan.*;

import java.util.ArrayList;
import java.util.Observable;

public class Case extends Observable {
    boolean isMur=false;
    ArrayList<Entite> entites =new ArrayList<>();
    ArrayList<Item> items=new ArrayList<>();
    ImageView imgview;

    public ImageView getImgview() {
        return imgview;
    }

    public void aChangé(){
        setChanged();
        notifyObservers();
    }

    public void setImgview(ImageView imgview) {
        this.imgview = imgview;
    }

    public Case(ArrayList<Entite> entites) {
        this.entites = entites;
    }

    public Case() {
    }

    public Case(boolean isMur) {
        this.isMur = isMur;
    }

    public void add(Entite entite){
        for (Entite ent :entites){
            if(ent.interagir(entite)){
                // TO DO
            }
        }
        this.entites.add(entite);
        ArrayList<Item> itemsASupprimer=new ArrayList<>();
        for(Item item :items){
            if(item.utiliser(entite)){
                itemsASupprimer.add(item);
            }
        }
        for(Item item :itemsASupprimer){
            if(item.utiliser(entite)){
                items.remove(item);
            }
        }

    }

    public void add(Item item){
        this.items.add(item);
    }

    public void setPacGomme(){
        this.add(new PacGomme());
    }

    public void setSuperPacGomme(){
        this.add(new SuperPacGomme());
    }

    public void remove(Entite entite){
        entites.remove(entite);
    }
    public void remove(Item item){
        items.remove(item);
    }
    public void clear (){
        entites.clear();
        items.clear();
    }

    public boolean isWall(){
        return isMur;
    }

    public String toString(){
        if (isMur)
            return "#";
        if(entites.size()!=0)
            return entites.get(entites.size()-1).toString();
        if(items.size()!=0)
            return items.get(items.size()-1).toString();
        return " ";
    }

}
