package metier.librairie;

import javafx.scene.image.ImageView;
import metier.jeuPacMan.*;

import java.util.ArrayList;
import java.util.Observable;

public class Case extends Observable {
    boolean isMur=false;
    ArrayList<Entite> entites =new ArrayList<>();
    ArrayList<Item> items=new ArrayList<>();
    Case casesVoisines[]= new Case[4];
    ImageView imgview;

    public ImageView getImgview() {
        return imgview;
    }

    public void deplacer(Entite entite, Case caseSuivante){
        entite.caseOccupe = caseSuivante;
        caseSuivante.add(entite);
        remove(entite);
    }

    public void deplacer(Entite entite){
        if(!entites.contains(entite) || entite.direction==null)
            return ;
        switch (entite.direction) {
            case bas:
                if (casesVoisines[1]!=null) {
                    entite.caseOccupe = casesVoisines[1];
                    casesVoisines[1].add(entite);
                    remove(entite);
                }
                break;
            case haut:
                if (casesVoisines[2]!=null) {
                    entite.caseOccupe = casesVoisines[2];
                    casesVoisines[2].add(entite);
                    remove(entite);
                }
                break;
            case gauche:
                if (casesVoisines[3]!=null) {
                    entite.caseOccupe = casesVoisines[3];
                    casesVoisines[3].add(entite);
                    remove(entite);
                }
                break;
            case droite:
                if (casesVoisines[0]!=null) {
                    entite.caseOccupe = casesVoisines[0];
                    casesVoisines[0].add(entite);
                    remove(entite);
                }
                break;
        }

    }

    public Case getVoisin(Entite.Dir direction){
        switch (direction){
            case bas:
                return casesVoisines[1];
            case haut:
                return casesVoisines[2];
            case gauche:
                return casesVoisines[3];
            case droite:
                return casesVoisines[0];
        }
        return null;
    }
    public void setVoisin(Case caseVideVoisine, Entite.Dir direction){
        switch (direction){
            case bas:
                casesVoisines[1]=caseVideVoisine;
                break;
            case haut:
                casesVoisines[2]=caseVideVoisine;
                break;
            case gauche:
                casesVoisines[3]=caseVideVoisine;
                break;
            case droite:
                casesVoisines[0]=caseVideVoisine;
                break;
        }
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
        aChangé();
    }

    public void add(Item item){
        this.items.add(item);
        aChangé();
    }

    public void setPacGomme(){
        this.add(new PacGomme());
    }

    public void setSuperPacGomme(){
        this.add(new SuperPacGomme());
    }

    public void remove(Entite entite){
        entites.remove(entite);
        aChangé();
    }

    public void remove(Item item){
        items.remove(item);
        aChangé();
    }
    public void clear (){
        entites.clear();
        items.clear();
        aChangé();
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

    public String getFileImg(){
        if (isMur)
            return "mur.png";
        if(entites.size()!=0)
            return entites.get(entites.size()-1).getFileImg();
        if(items.size()!=0)
            return items.get(items.size()-1).getFileImg();
        return "couloir.png";
    }
}
