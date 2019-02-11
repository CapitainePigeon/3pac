package sample;

import Librairie.Case;


import java.util.Observable;

public class Jeu extends Observable implements Runnable
{
    Case[][] tab;
    public Jeu() {
        tab = new Case[31][28];
        for(int i=0;i<tab.length;i++){
            for(int k=0;k<tab[i].length;k++){
                tab[i][k]=new Case(false);
            }
        }

        int[] lignes= new int[] {1,5,8,14,20,23,26,29};
        for(int ligne : lignes) {
            for (int i = 1; i < 27; i++) {
                if(ligne!=14)
                    setPacGomme(ligne,i);
                else
                    tab[ligne][i] = new Case();
            }
        }
        tab[1][13]=new Case(false);
        tab[1][14]=new Case(false);


        tab[8][13]=new Case(false);
        tab[8][14]=new Case(false);
        tab[8][7]=new Case(false);
        tab[8][8]=new Case(false);
        tab[8][20]=new Case(false);
        tab[8][21]=new Case(false);

        for (int i = 9; i < 18; i++) {
            tab[14][i] = new Case(false);
        }
        tab[20][13]=new Case(false);
        tab[20][14]=new Case(false);

        tab[23][23]=new Case(false);
        tab[23][22]=new Case(false);
        tab[23][4]=new Case(false);
        tab[23][5]=new Case(false);

        tab[26][13]=new Case(false);
        tab[26][14]=new Case(false);
        tab[26][20]=new Case(false);
        tab[26][19]=new Case(false);
        tab[26][7]=new Case(false);
        tab[26][8]=new Case(false);



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
        setPacGomme(6,19);
        setPacGomme(7,19);

        tab[9][12]=new Case();
        tab[10][12]=new Case();
        tab[9][15]=new Case();
        tab[10][15]=new Case();


        for (int i = 9; i < 19; i++) {
            tab[11][i] = new Case();
            tab[17][i] = new Case();
            tab[i+2][9] = new Case();
            tab[i+2][18] = new Case();
        }


        setPacGomme(2,1);
        setPacGomme(2,12);
        setPacGomme(2,15);
        setPacGomme(2,26);

        for(int ligne = 3; ligne < 5; ligne++) {
            for (int i = 0; i < 27; i++) {
                if (tab[2][i] instanceof Case)
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

        setSuperPacGomme(3,1);
        setSuperPacGomme(3,26);
        setSuperPacGomme(23,1);
        setSuperPacGomme(23,26);




       // ((Case)tab[1][3]).add(new Fantominus());
    }

    public void setPacGomme(int ligne, int colone){
        Case c=new Case();
        tab[ligne][colone]= c;
        c.setPacGomme();
    }
    public void setSuperPacGomme(int ligne, int colone){
        Case c=new Case();
        tab[ligne][colone]= c;
        c.setSuperPacGomme();
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
    public Case[][] getState(){

        return tab;
    }
}
