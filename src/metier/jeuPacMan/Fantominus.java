package metier.jeuPacMan;


import metier.jeuPacMan.cerveauDeFantominus.IAFantominus;
import metier.librairie.Case;
import metier.librairie.Entite;

import java.util.List;

public class Fantominus extends Entite {
    @Override
    public boolean interagir(Entite entite) {
        if(entite.getClass().equals(PacMan.class)){
            ((PacMan)entite).kill();
            return true;
        }
        return false;
    }

    public String toString(){
        return "M";
    }

    public String getFileImg(){
        return this.IA.getFileImg();
    }

    private IAFantominus IA;
    public Fantominus(Case caseOccupe, IAFantominus IA) {
        this.IA=IA;
        this.caseOccupe=caseOccupe;
        caseOccupe.add(this);

    }

    @Override
    public void run() {
        List<Case> mouvement=IA.getCases(this);
        while(true){
            if(mouvement.size()<2)
                mouvement = IA.getCases(this);

            if(mouvement.size()>0)
                caseOccupe.deplacer(this, mouvement.get(0));
            if(mouvement.size()>1) {
                mouvement.remove(0);
            }
            //System.out.println("cc");
            try {
                Thread.sleep(IA.sleeptime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
