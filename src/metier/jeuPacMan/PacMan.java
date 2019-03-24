package metier.jeuPacMan;

import metier.librairie.Case;
import metier.librairie.Entite;

public class PacMan extends Entite{

    public String toString(){
        return "O";
    }

    public String getFileImg(){
        String str="pacman_";
        if (this.direction==null){
            return "pacman_gauche.png";
        }
        switch (this.direction) {
            case haut:
                str = str + "haut";
                break;
            case bas:
                str = str + "bas";
                break;
            case droite:
                str = str + "droite";
                break;
            case gauche:
                str = str + "gauche";
                break;
        }
        return str+".png";
    }

    //protected Grille grille;
    private Dir futureDirection;

    public int getPacGommeMangé() {
        return pacGommeMangé;
    }

    void setPacGommeMangé(int pacGommeMangé) {
        this.pacGommeMangé = pacGommeMangé;
        setChanged();
        notifyObservers();
    }

    public int getSuperPacGommeMangé() {
        return superPacGommeMangé;
    }

    void setSuperPacGommeMangé(int superPacGommeMangé) {
        this.superPacGommeMangé = superPacGommeMangé;
    }

    private int pacGommeMangé=0;
    private int superPacGommeMangé=0;

    public PacMan(Case caseOccupe) {
        //this.grille = grille;
        this.caseOccupe=caseOccupe;
        caseOccupe.add(this);
    }

    @Override
    public void run() {
        int pheromonValue=0;
        while(!dead){
            //System.out.println("pac");
            if(futureDirection!=null){
                if(caseOccupe.getVoisin(futureDirection)!=null) {
                    direction=futureDirection;
                }
                pheromonValue+=1;
                caseOccupe.add(new Pherominus(pheromonValue));
                caseOccupe.deplacer(this);
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean interagir(Entite entite) {
        if(entite.getClass().equals(Fantominus.class)){
            this.kill();
            return true;
        }
        return false;
    }


    public void changeDir(Dir dir){
        futureDirection=dir;
    }

    public void kill() {
        dead=true;
        setChanged();
        notifyObservers();
        //System.out.println("t mor");
    }
    public boolean isDead(){
        return  dead;
    }

}
