package Model;

import org.jgrapht.EdgeFactory;
import org.jgrapht.UndirectedGraph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// a graph that uses {@code Location} as vertices and {@LocEdge} as edges
public class LocGraph implements UndirectedGraph<Location, LocEdge> {
    // the set of all the graph's vertices
    private Set<Location> vertices;
    // the set of all the graph's edges
    private Set<LocEdge> edges;
    // a factory for producing {@code LocEdge}
    private final LocEdgeFactory factory = new LocEdgeFactory();

    public LocGraph() {
        this.vertices = new HashSet<Location>();
        this.edges = new HashSet<LocEdge>();
    }


    @Override
    public int degreeOf(Location location) {
        return 0;
    }

    @Override
    public Set<LocEdge> getAllEdges(Location location, Location v1) {
        return null;
    }

    public void setVertices(Set<Location> locations) {
        this.vertices = locations;
    }

    @Override
    public LocEdge getEdge(Location location, Location v1) {
        if (this.edges.contains(factory.createEdge(location, v1))) {
            return new LocEdge(location, v1);
        } else {
            return null;
        }
    }

    @Override
    public EdgeFactory<Location, LocEdge> getEdgeFactory() {
        return this.factory;
    }

    @Override
    public LocEdge addEdge(Location location, Location v1) {
        LocEdge e = new LocEdge(location, v1);
        LocEdge e2 = new LocEdge(v1, location);
        this.edges.add(e);
        this.edges.add(e2);
        return e;
    }

    @Override
    public boolean addEdge(Location location, Location v1, LocEdge edge) {
        return false;
    }

    @Override
    public boolean addVertex(Location location) {
        return this.vertices.add(location);
    }

    @Override
    public boolean containsEdge(Location location, Location v1) {
        return this.edges.contains(factory.createEdge(location, v1));
    }

    @Override
    public boolean containsEdge(LocEdge edge) {
        return this.edges.contains(edge);
    }

    @Override
    public boolean containsVertex(Location location) {
        return this.vertices.contains(location);
    }

    @Override
    public Set<LocEdge> edgeSet() {
        return this.edges;
    }

    @Override
    public Set<LocEdge> edgesOf(Location location) {
        Set<LocEdge> edgesOf = new HashSet<>();
        for (LocEdge edge : edges) {
            if (edge.getSource().equals(location)) {
                edgesOf.add(edge);
            }
        }
        return edgesOf;
    }

    @Override
    public boolean removeAllEdges(Collection<? extends LocEdge> collection) {
        boolean changed = false;
        for (LocEdge e : collection) {
            if (this.edges.contains(e)) {
                this.edges.remove(e);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public Set<LocEdge> removeAllEdges(Location location, Location v1) {
        if (!vertices.contains(location) || !vertices.contains(v1)) {
            return null;
        }
        Set<LocEdge> removed = new HashSet<>();
        for (LocEdge e : edges) {
            if (new LocEdge(location, v1).equals(e)) {
                edges.remove(e);
                removed.add(e);
            }
        }
        return removed;
    }

    @Override
    public boolean removeAllVertices(Collection<? extends Location> collection) {
        boolean changed = false;
        for (Location l: collection) {
            if (vertices.contains(l)) {
                this.vertices.remove(l);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public LocEdge removeEdge(Location location, Location v1) {
        LocEdge e = new LocEdge(location, v1);
        if (edges.contains(e)) {
            edges.remove(e);
            return e;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean removeEdge(LocEdge edge) {
        if (this.edges.contains(edge)) {
            this.edges.remove(edge);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeVertex(Location location) {
        if (this.vertices.contains(location)) {
            this.vertices.remove(location);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Set<Location> vertexSet() {
        return this.vertices;
    }

    @Override
    public Location getEdgeSource(LocEdge edge) {
        return edge.getSource();
    }

    @Override
    public Location getEdgeTarget(LocEdge edge) {
        return edge.getTarget();
    }

    @Override
    public double getEdgeWeight(LocEdge edge) {
        return 0;
    }
}