package Model;

import org.jgrapht.EdgeFactory;

/**
 * a factory for making {@code LocEdge}
 */
public class LocEdgeFactory implements EdgeFactory<Location, LocEdge> {

    @Override
    public LocEdge createEdge(Location location, Location v1) {
        return new LocEdge(location, v1);
    }
}
