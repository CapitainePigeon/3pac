package librairie.entites;


import librairie.Grille;

public class Fantominus extends Entite implements Runnable {
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
