package metier.jeuPacMan;

import metier.librairie.Case;
import metier.librairie.Grille;
import metier.librairie.Entite;

import static metier.librairie.Entite.Dir.*;

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

    protected Grille grille;
    private Dir futureDirection;

    public int getPacGommeMangé() {
        return pacGommeMangé;
    }

    public void setPacGommeMangé(int pacGommeMangé) {
        this.pacGommeMangé = pacGommeMangé;
    }

    public int getSuperPacGommeMangé() {
        return superPacGommeMangé;
    }

    public void setSuperPacGommeMangé(int superPacGommeMangé) {
        this.superPacGommeMangé = superPacGommeMangé;
    }

    private int pacGommeMangé=0;
    private int superPacGommeMangé=0;

    public PacMan(Grille grille,Case caseOccupe) {
        this.grille = grille;
        this.caseOccupe=caseOccupe;
        caseOccupe.add(this);
    }

    @Override
    public void run() {
        while(true){
            //System.out.println("pac");
            if(futureDirection!=null){
                if(caseOccupe.getVoisin(futureDirection)!=null) {
                    direction=futureDirection;
                }
                grille.deplacer(this);
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
        System.out.println("t mor");
    }

}
