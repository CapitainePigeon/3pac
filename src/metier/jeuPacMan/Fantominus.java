package metier.jeuPacMan;


import metier.librairie.Grille;
import metier.librairie.Entite;

public class Fantominus extends Entite {
    public String toString(){
        return "M";
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
