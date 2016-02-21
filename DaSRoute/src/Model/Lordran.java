package Model;

import org.jgrapht.alg.DijkstraShortestPath;

import java.util.EnumSet;
import java.util.List;

/**
 * The fully initialised graph of the Dark Souls game world (Lordran)
 */
public class Lordran extends LocGraph {

    public Lordran() {
        super();
        init();
    }

    /**
     * fill the graph with all the nodes and edges according to their relationship in the game
     */
    private void init() {
        //Unlocked edges
        this.setVertices(EnumSet.allOf(Location.class));
        this.addEdge(Location.NUA, Location.FLink);
        this.addEdge(Location.UBurg, Location.NUA);
        this.addEdge(Location.UBurg, Location.UParish);
        this.addEdge(Location.UParish, Location.Garden);
        this.addEdge(Location.Garden, Location.Basin);
        this.addEdge(Location.Basin, Location.Valley);
        this.addEdge(Location.Valley, Location.BTown);
        this.addEdge(Location.BTown, Location.Tree);
        this.addEdge(Location.Tree, Location.Lake);
        this.addEdge(Location.BTown, Location.Que);
        this.addEdge(Location.DRuins, Location.Izalith);
        this.addEdge(Location.LBurg, Location.Depths);
        this.addEdge(Location.FLink, Location.NLRuins);
        this.addEdge(Location.FLink, Location.Skeltal);
        this.addEdge(Location.Fort, Location.Anor);
        this.addEdge(Location.Duke, Location.Cave);

        //Locked Edges
        this.addEdge(Location.Anor, Location.Duke);
        this.addEdge(Location.Anor, Location.Paint);
        this.addEdge(Location.Fort, Location.UParish);
        this.addEdge(Location.FLink, Location.Kiln);
        this.addEdge(Location.Valley, Location.NLRuins);
        this.addEdge(Location.UBurg, Location.Basin);
        this.addEdge(Location.Skeltal, Location.Tomb);
        this.addEdge(Location.Que, Location.DRuins);
        this.addEdge(Location.UBurg, Location.LBurg);
        this.addEdge(Location.Depths, Location.BTown);
    }

    /**
     * find and print out the shortest path between two locations in the game
     * @param l1 the starting location
     * @param l2 the desired ending location
     */
    public void routing(Location l1, Location l2) {
        List<LocEdge> shortestPath = DijkstraShortestPath.findPathBetween(this, l1, l2);
        for (LocEdge e : shortestPath) {
            if (e == null) {
                System.out.println("No Path Exists");
            }
            else {
                System.out.println(e.getSource().getName() + "--->" + e.getTarget().getName());
            }
        }
    }


}
