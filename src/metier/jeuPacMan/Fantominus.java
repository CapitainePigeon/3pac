package metier.jeuPacMan;


import metier.librairie.Grille;
import metier.librairie.Entite;

public class Fantominus extends Entite {
    public String toString(){
        return "M";
    }
    protected Grille grille;

    public Fantominus(Grille grille) {
        this.grille = grille;
    }

    @Override
    public void run() {
        while(true){
            setChanged();
            notifyObservers();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
