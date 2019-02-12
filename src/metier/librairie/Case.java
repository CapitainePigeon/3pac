package metier.librairie;

import metier.jeuPacMan.*;
import metier.librairie.Entite;

import java.util.ArrayList;

public class Case {
    boolean isMur=false;
    ArrayList<Entite> contenu=new ArrayList<Entite>();

    public Case(ArrayList<Entite> contenu) {
        this.contenu = contenu;
    }

    public Case() {
    }

    public Case(boolean isMur) {
        this.isMur = isMur;
    }

    public void add(Entite contenu){
        this.contenu.add(contenu);
    }
    public void setPacGomme(){
        this.contenu.add(new PacGomme());
    }

    public void setSuperPacGomme(){
        this.contenu.add(new SuperPacGomme());
    }
    public void clear (){
        contenu.clear();
    }

    public boolean isWall(){
        return isMur;
    }
    public String toString(){
        if (isMur)
            return "#";
        if(contenu.size()!=0)
            return contenu.get(contenu.size()-1).toString();
        return " ";
    }
}
