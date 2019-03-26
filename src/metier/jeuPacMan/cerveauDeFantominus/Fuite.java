package metier.jeuPacMan.cerveauDeFantominus;

public class Fuite extends  Random {
    public Fuite(GraphDesCouloirs graphDesCouloirs) {
        super(graphDesCouloirs);
    }
    public String getFileImg(){
        return "fantominus_ko.png";
    }
}
