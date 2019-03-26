package metier.jeuPacMan.cerveauDeFantominus;

import metier.librairie.Case;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;

public class FastRandom extends Random {

    private DijkstraShortestPath<Case, DefaultEdge> dij;
    private GraphDesCouloirs grapheDesCouloir;
    public FastRandom(GraphDesCouloirs graphDesCouloirs) {
        super(graphDesCouloirs);
        super.sleeptime=150;
    }
    public String getFileImg(){
        return "fantominus_rouge.png";
    }
}
