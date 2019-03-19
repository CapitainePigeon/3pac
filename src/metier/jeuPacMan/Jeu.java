package metier.jeuPacMan;

import metier.librairie.Case;
import metier.librairie.Entite;
import metier.librairie.Grille;

public class Jeu
{
    public Grille grille;
    public Jeu() {

        grille =new Grille(31,28);
        for(int i=0;i<grille.getTab().length;i++){
            for(int k=0;k<grille.getTab()[i].length;k++){
                grille.setTab(new Case(true),i,k);
            }
        }

        int[] lignes= new int[] {1,5,8,14,20,23,26,29};
        for(int ligne : lignes) {
            for (int i = 1; i < 27; i++) {
                if(ligne!=14)
                    setPacGomme(ligne,i);
                else
                    grille.setTab(new Case(),ligne,i);
            }
        }
        grille.setTab(new Case(true),1,13);
        grille.setTab(new Case(true),1,14);
        grille.setTab(new Case(true),8,19);

        grille.setTab(new Case(true),8,13);
        grille.setTab(new Case(true),8,14);
        grille.setTab(new Case(true),8,7);
        grille.setTab(new Case(true),8,8);
        grille.setTab(new Case(true),8,20);
        grille.setTab(new Case(true),8,21);

        for (int i = 9; i < 18; i++) {
            grille.setTab(new Case(true),14,i);
        }
        grille.setTab(new Case(true),20,13);
        grille.setTab(new Case(true),20,14);

        grille.setTab(new Case(true),23,23);
        grille.setTab(new Case(true),23,22);
        grille.setTab(new Case(true),23,4);
        grille.setTab(new Case(true),23,5);

        grille.setTab(new Case(true),26,13);
        grille.setTab(new Case(true),26,14);
        grille.setTab(new Case(true),26,20);
        grille.setTab(new Case(true),26,19);
        grille.setTab(new Case(true),26,7);
        grille.setTab(new Case(true),26,8);



        int[] Colones= new int[] {6,21};
        for(int colone : Colones) {
            for (int i = 1; i < 27; i++) {
                setPacGomme(i,colone);
            }
        }
        setPacGomme(6,1);
        setPacGomme(7,1);
        setPacGomme(6,26);
        setPacGomme(7,26);
        setPacGomme(6,9);
        setPacGomme(7,9);
        setPacGomme(6,18);
        setPacGomme(7,18);

        grille.setTab(new Case(),9,12);
        grille.setTab(new Case(),10,12);
        grille.setTab(new Case(),9,15);
        grille.setTab(new Case(),10,15);


        for (int i = 9; i < 19; i++) {
            grille.setTab(new Case(),11,i);
            grille.setTab(new Case(),17,i);
            grille.setTab(new Case(),i+2,9);
            grille.setTab(new Case(),i+2,18);
        }


        setPacGomme(2,1);
        setPacGomme(2,12);
        setPacGomme(2,15);
        setPacGomme(2,26);

        for(int ligne = 3; ligne < 5; ligne++) {
            for (int i = 0; i < 27; i++) {
                if (!grille.getTab(2,i).isWall())
                    setPacGomme(ligne,i);
            }
        }


        setPacGomme(28,1);
        setPacGomme(28,12);
        setPacGomme(28,15);
        setPacGomme(28,26);
        setPacGomme(27,1);
        setPacGomme(27,12);
        setPacGomme(27,15);
        setPacGomme(27,26);
        setPacGomme(25,3);
        setPacGomme(24,3);
        setPacGomme(25,9);
        setPacGomme(24,9);
        setPacGomme(25,18);
        setPacGomme(24,18);
        setPacGomme(25,24);
        setPacGomme(24,24);
        setPacGomme(22,1);
        setPacGomme(21,1);
        setPacGomme(22,12);
        setPacGomme(21,12);
        setPacGomme(22,15);
        setPacGomme(21,15);
        setPacGomme(22,26);
        setPacGomme(21,26);
        setPacGomme(20,9);
        setPacGomme(20,18);

        setSuperPacGomme(3,1);
        setSuperPacGomme(3,26);
        setSuperPacGomme(23,1);
        setSuperPacGomme(23,26);

        grille.getTab(14,1).setVoisin(grille.getTab(14,26), Entite.Dir.gauche);
        grille.getTab(14,26).setVoisin(grille.getTab(14,1), Entite.Dir.droite);
        grille.setCouloirs();
    }

    public void setPacGomme(int ligne, int colone){
        Case c=new Case();
        grille.setTab(c,ligne,colone);
        c.setPacGomme();
    }
    public void setSuperPacGomme(int ligne, int colone){
        Case c=new Case();
        grille.setTab(c,ligne,colone);
        c.setSuperPacGomme();
    }

    public Case[][] getState(){

        return grille.getTab();
    }
    public String toString(){
        return grille.toString();
    }

}
