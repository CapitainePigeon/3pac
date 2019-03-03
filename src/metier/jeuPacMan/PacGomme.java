package metier.jeuPacMan;

import metier.librairie.Entite;
import metier.librairie.Item;

public class PacGomme extends Item {

    public String toString(){
        return ".";
    }

    @Override
    public boolean utiliser(Entite entite) {
        if(entite.getClass().equals(PacMan.class)){
            ((PacMan)entite).setPacGommeMangé(((PacMan)entite).getPacGommeMangé()+1);
            return true;
        }
        return false;
    }
}
