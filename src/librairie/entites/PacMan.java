package librairie.entites;

import librairie.Grille;

public class PacMan extends Entite implements Runnable{
    public String toString(){
        return "O";
    }
    protected Grille grille;

    public PacMan(Grille grille) {
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
