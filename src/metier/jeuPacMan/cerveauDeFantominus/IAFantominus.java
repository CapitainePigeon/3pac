package metier.jeuPacMan.cerveauDeFantominus;

import metier.jeuPacMan.Fantominus;
import metier.librairie.Case;

import java.util.List;

public abstract class IAFantominus {

    public float sleep;
    /*public IAFantominus(GraphDesCouloirs graphDesCouloirs) {
        grapheDesCouloir = graphDesCouloirs;
    }*/
    public abstract List<Case> getCases(Fantominus fantominus);

    public String getFileImg(){
        return "Error404lol";
    }
}
