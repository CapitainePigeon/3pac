package metier.jeuPacMan.cerveauDeFantominus;

import metier.jeuPacMan.Fantominus;
import metier.jeuPacMan.Pherominus;
import metier.librairie.Case;
import metier.librairie.Item;

import java.util.ArrayList;
import java.util.List;

public class Sniffer extends IAFantominus {
    Random random;
    public Sniffer(GraphDesCouloirs graphDesCouloirs) {
        random=new Random(graphDesCouloirs);
    }

    @Override

    public List<Case> getCases(Fantominus fantominus) {
        boolean sentir =false;
        int maxvalue=-100;
        Case maxvoisin=fantominus.caseOccupe;
        for(Case voisin : fantominus.caseOccupe.getVoisins()) {
            for (Item item : voisin.getItems()) {
                if (item.getClass() == Pherominus.class) {
                    sentir=true;
                    if(((Pherominus) item).getValue()>maxvalue){
                        maxvalue=((Pherominus) item).getValue();
                        maxvoisin=voisin;
                    }
                }
            }
        }
        if(!sentir)
            return random.getCases(fantominus);
        ArrayList<Case> list= new ArrayList<>() ;
        list.add(maxvoisin);
        return list;
    }
}
