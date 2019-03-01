package metier.jeuPacMan;

import metier.librairie.Grille;
import metier.librairie.Entite;

public class PacMan extends Entite{
    public String toString(){
        return "O";
    }
    protected Grille grille;

    public PacMan(Grille grille,int x, int y) {
        this.grille = grille;
        this.x=x;
        this.y=y;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("pac");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
