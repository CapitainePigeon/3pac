package metier.jeuPacMan;

import metier.librairie.Entite;
import metier.librairie.Item;

public class Pherominus extends Item {
    int value;

    public Pherominus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    @Override
    public boolean utiliser(Entite entite) {
        if(entite.getClass().equals(PacMan.class))
            return true;
        return false;
    }
}
