package metier.librairie;

import metier.jeuPacMan.*;

import java.util.ArrayList;

public class Case {
    boolean isMur=false;
    ArrayList<Entite> entites =new ArrayList<>();
    ArrayList<Item> items=new ArrayList<>();

    public Case(ArrayList<Entite> entites) {
        this.entites = entites;
    }

    public Case() {
    }

    public Case(boolean isMur) {
        this.isMur = isMur;
    }

    public void add(Entite entite){
        this.entites.add(entite);
    }

    public void add(Item item){
        this.items.add(item);
    }

    public void setPacGomme(){
        this.items.add(new PacGomme());
    }

    public void setSuperPacGomme(){
        this.items.add(new SuperPacGomme());
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
