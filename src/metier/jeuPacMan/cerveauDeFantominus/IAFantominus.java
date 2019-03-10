package metier.jeuPacMan.cerveauDeFantominus;

import metier.jeuPacMan.Fantominus;
import metier.librairie.Case;

import java.util.List;

public abstract class IAFantominus {
    protected GraphDesCouloirs grapheDesCouloir;

    public IAFantominus(GraphDesCouloirs graphDesCouloirs) {
        grapheDesCouloir = graphDesCouloirs;
    }
    public abstract List<Case> getCases(Fantominus fantominus);
}
