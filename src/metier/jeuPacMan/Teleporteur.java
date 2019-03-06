package metier.jeuPacMan;

import metier.librairie.Case;
import metier.librairie.Entite;

public class Teleporteur extends Case {
    Case lien;
    Entite.Dir direction;


    public Case getLien() {
        return lien;
    }

    public void setLien(Case lien, Entite.Dir direction) {
        this.lien = lien;
        this.direction=direction;
    }

    public boolean teleport(Entite.Dir direction){
        return(this.direction==direction);
    }
}
