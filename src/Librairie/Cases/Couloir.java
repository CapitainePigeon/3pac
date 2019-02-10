package Librairie.Cases;

import Librairie.Entites.*;

import java.util.ArrayList;

public class Couloir extends Case {
    ArrayList<Entite> contenu=new ArrayList<Entite>();

    public Couloir(ArrayList<Entite> contenu) {
        this.contenu = contenu;
    }

    public Couloir() {
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

    public String toString(){
        if(contenu.size()!=0)
            return contenu.get(contenu.size()-1).toString();
        return " ";
    }
}
