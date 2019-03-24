package metier.jeuPacMan;

import metier.librairie.Entite;
import metier.librairie.Item;

public class SuperPacGomme extends Item {
    public String toString(){
        return "¤";
    }

    public String getFileImg(){
        return "superpacgomme.png";
    }

    @Override
    public boolean utiliser(Entite entite) {
        if(entite.getClass().equals(PacMan.class)){
            ((PacMan)entite).setSuperPacGommeMangé(((PacMan)entite).getSuperPacGommeMangé()+1);
            System.out.println(((PacMan)entite).getSuperPacGommeMangé());
            return true;
        }
        return false;
    }
}
