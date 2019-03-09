package metier.jeuPacMan;


import metier.librairie.Case;
import metier.librairie.Grille;
import metier.librairie.Entite;

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
        return "fantominus.png";
    }

    protected Grille grille;

    public Fantominus(Grille grille, Case caseOccupe) {
        this.grille = grille;
        this.caseOccupe=caseOccupe;
        caseOccupe.add(this);
        this.direction=Dir.gauche;

    }

    @Override
    public void run() {
        while(true){
            grille.deplacer(this);
            //System.out.println("cc");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
