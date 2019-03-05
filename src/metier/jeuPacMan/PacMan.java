package metier.jeuPacMan;

import metier.librairie.Grille;
import metier.librairie.Entite;

import static metier.librairie.Entite.Dir.*;

public class PacMan extends Entite{
    public String toString(){
        return "O";
    }

    public String getFileImg(){
        return "pacman.png";
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

    public PacMan(Grille grille,int x, int y) {
        this.grille = grille;
        this.x=x;
        this.y=y;
    }

    @Override
    public void run() {
        while(true){
            //System.out.println("pac");
            if(futureDirection!=null){
                switch (futureDirection){
                    case haut:
                        if(!grille.getTab(x-1,y).isWall())
                            direction=haut;
                        break;
                    case bas:
                        if(!grille.getTab(x+1,y).isWall())
                            direction=bas;
                        break;
                    case gauche:
                        if(!grille.getTab(x,y-1).isWall())
                            direction=gauche;
                        break;
                    case droite:
                        if(!grille.getTab(x,y+1).isWall())
                            direction=droite;
                        break;
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
        System.out.println("t mort");
    }


}
