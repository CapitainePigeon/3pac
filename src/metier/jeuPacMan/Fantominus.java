package metier.jeuPacMan;


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

    public Fantominus(Grille grille,int x, int y) {
        this.grille = grille;
        this.x=x;
        this.y=y;
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
