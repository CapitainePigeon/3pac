package metier.jeuPacMan;

import metier.librairie.Entite;
import metier.librairie.Item;

public class SuperPacGomme extends Item {
    public String toString(){
        return "¤";
    }
    @Override
    public boolean utiliser(Entite entite) {
        if(entite.getClass().equals(PacMan.class)){
            ((PacMan)entite).setSuperPacGommeMangé(((PacMan)entite).getSuperPacGommeMangé()+1);
            return true;
        }
        return false;
    }
}
